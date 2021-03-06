CREATE  OR REPLACE VIEW  V_PROF  -- v_TATBLE NAME  // OR REPLACE    있으면 지우고 다시 생성해라. 
AS 
SELECT PROFNO , NAME , EMAIL , HPAGE 
FROM T_PROFESSOR 
;

SELECT * FROM V_PROF;

SELECT TNAME FROM TAB; -- SCOTT0316 계정이 가지고 있는 테이블 목록 쫙 나옴. 테이블과 어깨를 나란히



-- VIEW 생성시 별도의 컬럼이름을 지정해줄 수 있다. ( 내 맘대로 컬럼이름 다시 만들기!)
CREATE OR REPLACE VIEW  V_PROF(PFNO, NM, EM, HP)   
AS 
SELECT PROFNO , NAME , EMAIL , HPAGE 
FROM T_PROFESSOR 
;


SELECT * FROM V_PROF;


-- #8102
CREATE OR REPLACE VIEW V_PROF_DEPT("교수번호", "교수명", "소속학과")
AS
SELECT P.PROFNO , P.NAME , D.DNAME 
FROM T_PROFESSOR P,  T_DEPARTMENT D
WHERE P.DEPTNO = D.DEPTNO 
;

SELECT * FROM V_PROF_DEPT;


-- #8103
CREATE OR REPLACE VIEW V_STU_DEPT
AS
SELECT D.DNAME 학과명, S.MAX_HEIGHT 최대키, S.MAX_WEIGHT 최대몸무게
FROM (SELECT DEPTNO1 , MAX(HEIGHT) "MAX_HEIGHT" , MAX(WEIGHT) MAX_WEIGHT FROM T_STUDENT GROUP BY DEPTNO1 ) S, T_DEPARTMENT D
WHERE S.DEPTNO1 = D.DEPTNO 
;
SELECT * FROM V_STU_DEPT;

-- #8104
CREATE OR REPLACE VIEW V_STU_DEPT1
AS
SELECT D.DNAME 학과명, A.MAX_HEIGHT 최대키, S.NAME 학생이름, S.HEIGHT 키
FROM 
	(SELECT DEPTNO1, MAX(HEIGHT) MAX_HEIGHT FROM T_STUDENT GROUP BY DEPTNO1) A, 
	T_STUDENT S, T_DEPARTMENT D
WHERE 
	S.DEPTNO1 = A.DEPTNO1 
	AND S.HEIGHT = A.MAX_HEIGHT
	AND S.DEPTNO1  = D.DEPTNO 
;

-- #8105 
SELECT GRADE , AVG(HEIGHT) AVG_HEIGHT FROM T_STUDENT GROUP BY GRADE;

SELECT S.GRADE 학년, S.NAME 이름, S.HEIGHT 키, A.AVG_HEIGHT 평균키
FROM 
	(SELECT GRADE , AVG(HEIGHT) AVG_HEIGHT FROM T_STUDENT GROUP BY GRADE) A,  -- 학년별  평균키 뽑고,  
	T_STUDENT S																	-- 그거랑 학생테이블이랑 쪼인 한 것으로부터 --> 
WHERE A.GRADE = S.GRADE  AND S.HEIGHT > A.AVG_HEIGHT  -- 평균키보다 큰 애들만 뽑힘. 			같은 학년 + 키 가 평균키보다 
ORDER BY 1 ASC 
;


-- FROM 절에 들어가는 서브쿼리문 들어가는 뷰를     인라인 뷰이라고 한다. 
-- 이걸 자주쓰면 아예 가상 테이블을 만들어라. CREATE 으로 만들었으므로 DROP 으로 삭제 ~