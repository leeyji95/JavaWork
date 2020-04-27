-- dual 은 ROW 1개짜리 dummy TABLE;
SELECT 'abcd' FROM dual;
SELECT '안녕하세요' FROM  dual;
SELECT  100 FROM dual;
SELECT 100 + 10 FROM dual;

-- * : '모든 컬럼' 
SELECT  * FROM T_EMP ;

-- 월하는 컬럼만 조회
SELECT EMPNO , ENAME 
FROM T_EMP ;


-- 교수들의 정보만
SELECT  * FROM T_PROFESSOR ;   
SELECT BONUS FROM  T_PROFESSOR ; -- 교수님 정보 중 보너스만

SELECT '안녕하세요' FROM T_PROFESSOR ;

SELECT  name, '교수님 사랑해용' FROM  T_PROFESSOR ;

-- 컬럼 별명(alias) 사용한 출력
SELECT STUDNO 학번, name 이름
FROM T_STUDENT ;

SELECT STUDNO "학번" , NAME AS 이름 
FROM T_STUDENT ;

SELECT STUDNO "학생 학번", name 이름    -- 학생 학번 -> 에러, "학생 학번" -> "" 로 묶어주기
FROM T_STUDENT ;

--연습1
--emp 테이블에서  empno 를 '사원번호',
--ename 을 '사원명'. 
-- job 을 '직업'으로 별명을 설정하여 출력
SELECT EMPNO 사원번호, ENAME 사원명, JOB 직업
FROM T_EMP ;

-- tdept 테이블을 사용하여 deptno를 '부서#', 
-- dname을 '부서명', 
-- loc를 '위치' 로 별명을 설정하여 출력
SELECT DEPTNO "부서#", DNAME  부서명, LOC 위치
FROM T_DEPT ;


-- DISTINCT 연습
-- 학생테이블(t_student) 에서
-- 제1전공 (deptno1) 을 중복값을 제거하여 출력해보기
SELECT DISTINCT  deptno1 FROM T_STUDENT ;
SELECT DISTINCT  job FROM T_EMP ;


-- || : 필드, 문자열 연결 연산
SELECT  NAME , "POSITION" 
FROM T_PROFESSOR ;

SELECT name || '-' || "POSITION" AS "교수님 명단"  -- AS 뒤에 한글 띄어쓰기 조심!!
FROM T_PROFESSOR ;

-- 학생테이블(t_student)를 사용하여 
-- 모든 학생들이 
-- ‘서진수의 키는 180cm, 몸무게는 55kg 입니다’ 
-- 와 같은 형식으로 출력되도록 문자를 추가하고, 
-- 칼럼 이름은 ‘학생의 키와 몸무게’ 라는 별명으로 출력하세요	
SELECT 
	NAME || '의 키는 ' ||
	HEIGHT || 'cm, ' ||
	'몸무게는 ' || WEIGHT  || ' kg 입니다'  AS "학생의 키와 몸무게"
FROM T_STUDENT ;
