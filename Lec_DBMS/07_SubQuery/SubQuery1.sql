-- #7101
-- t_emp 테이블에서
--  scott 보다 급여를 많이 받는 사람의 이름과 급여 출력
SELECT * FROM T_EMP ;
 -- 일단 서브쿼리 먼저 만들고 -> 내가 원하는 결과 나오는지 확인한 다음에 
SELECT SAL FROM T_EMP WHERE ENAME = 'SCOTT';  -- 3000
-- 그 쿼리문을 대입한다. 
SELECT ENAME , SAL 
FROM T_EMP 
WHERE SAL > (SELECT SAL FROM T_EMP WHERE ENAME = 'SCOTT') ;  -- 값 하나만 나옴. 서브쿼리의 결과가 값이 하나만 나오는 단일행 서브쿼리이기 떄문이다.


-- #7102
-- t_student 테이블에서 가장 키 큰 학생의 '이름'과 '키'를 출력
SELECT MAX(HEIGHT) FROM T_STUDENT;

SELECT NAME , HEIGHT 
FROM T_STUDENT 
WHERE HEIGHT = (SELECT MAX(HEIGHT) FROM T_STUDENT) 
;



-- 1. 단일행 서브 쿼리

--#7103)연습
--t_student, t_department 테이블 사용하여 
--이윤나 학생과 1전공(deptno1)이 동일한 학생들의 
--이름(name)과 1전공이름(dname)을 출력하세요
SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나';

SELECT  S.NAME 학생이름, D.DNAME "1전공"
FROM T_STUDENT S, T_DEPARTMENT D
WHERE S.DEPTNO1  = D.DEPTNO  AND S.DEPTNO1 = (SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나')
;


-- #7104) 연습
--t_professor, t_department 테이블 : 입사일이 송도권 교수보다 나중에 입사한 사람의 
--이름과 입사일, 학과명을 출력하세요

SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '송도권';

SELECT P.NAME 교수명, TO_CHAR(P.HIREDATE, 'YYYY-MM-DD') 입사일, D.DNAME 학과명
FROM T_PROFESSOR P , T_DEPARTMENT D
WHERE P.DEPTNO = D.DEPTNO  AND HIREDATE > (SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '송도권')
;


-- #7105) 연습
--t_student 테이블 :  1전공이 101번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의 
--이름과 몸무게를 출력하세요
SELECT AVG(WEIGHT) FROM T_STUDENT WHERE DEPTNO1 = 101;

SELECT NAME  이름, WEIGHT 몸무게
FROM T_STUDENT 
WHERE WEIGHT > (SELECT AVG(WEIGHT) FROM T_STUDENT WHERE DEPTNO1 = 101);



--#7106) 연습
--t_professor 테이블에서 심슨 교수와 같은 입사일에 입사한 교수 중, 
--조인형 교수보다 월급을 적게 받는 교수의  이름과 급여, 입사일을 출력하세요
SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '심슨';
SELECT PAY FROM T_PROFESSOR WHERE NAME = '조인형';

SELECT NAME 이름, PAY 급여, TO_CHAR(HIREDATE , 'YYYY-MM-DD') 입사일 
FROM T_PROFESSOR 
WHERE HIREDATE = (SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '심슨')
	 AND PAY < (SELECT PAY FROM T_PROFESSOR WHERE NAME = '조인형')
;

---------------------------------------------------------------------------------------
-- 2. 다중행 쿼리
-- Sub Query 결과가 2건 이상 출력되는 것을 말합니다.
-- 다중행 Sub Query 와 함께 사용하는 연산자
--		 IN 같은 값을 찾음
--		>ANY 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 큰)  -> 좌측의 값이  괄호 안에 어떤 것(값)보다도 크면 됨. (모두 크지 않아도 됨)  => 즉 괄호 안에 제일 작은 값보다만 크면 됨.
--		<ANY 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 작은) -> 여기서 가장 큰값보다 작기만 하면 됨. 즉 최대값보다 작음
--		<ALL 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 작은)  ->  서브쿼리 안에 있는 모~든 것보다 작아야함. => 최소값보다 더 작아야지만 참. 최소값 반환 
--		>ALL 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 큰) -> 가장 큰값ㄷ보다 커야함으로, 최대값 반환.
--		EXIST Sub Query 값이 있을 경우 반환

--#7107
SELECT * FROM T_EMP2 ;
SELECT * FROM T_DEPT2 ;

SELECT DCODE FROM T_DEPT2 WHERE AREA = '서울지사';  -- 여러개로 결과가 나옴 

SELECT EMPNO , NAME , DEPTNO 
FROM T_EMP2
WHERE DEPTNO IN (SELECT DCODE FROM T_DEPT2 WHERE AREA = '서울지사');


-- #7108
SELECT PAY FROM T_EMP2 WHERE POST = '과장'
;
SELECT NAME 이름, POST 직급, TO_CHAR(PAY , '999,999,999') || '원' 연봉
FROM T_EMP2 
WHERE PAY >=ANY(SELECT PAY FROM T_EMP2 WHERE POST = '과장')
;


-- #7109
SELECT WEIGHT FROM T_STUDENT WHERE GRADE = 4;

SELECT NAME 이름, GRADE 학년, WEIGHT 몸무게
FROM T_STUDENT 
WHERE WEIGHT <ALL (SELECT WEIGHT FROM T_STUDENT WHERE GRADE = 4)
;

SELECT MIN(WEIGHT) FROM T_STUDENT WHERE GRADE = 4;

SELECT NAME , GRADE , WEIGHT 
FROM T_STUDENT 
WHERE WEIGHT  < (SELECT MIN(WEIGHT) FROM T_STUDENT WHERE GRADE = 4) ;


