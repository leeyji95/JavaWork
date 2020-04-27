-- 산술연산자
SELECT ENAME , sal, SAL  * 1.1	AS "월급의 10%" -- 급여 10% 인상분  
FROM T_EMP ;

SELECT ENAME , sal, comm, sal + COMM   -- NUll 값과의 산술연산은 무.조.건 NULL !
FROM T_EMP ;

-- WHERE 조건절
SELECT  * FROM  T_EMP  WHERE JOB  = 'SALESMAN'; -- 직원 테이블(t_emp) 에서 직책이 salesman 인 사람만 조회
SELECT  * FROM T_EMP  WHERE job = 'SALESman';  -- 문자열은 대소문자 구분! 

-- 직원 테이블(t_emp) 에서 10번 부서(deptno)에 근무하는 직원의  
-- 이름(ename)과 급여(sal)와 부서번호(deptno) 출력
SELECT ENAME 이름, SAL 급여, DEPTNO 부서번호
FROM T_EMP 
WHERE DEPTNO = 10;  -- 자바와 다른 점 :  ==  안쓴다!

--직원 테이블(t_emp) 에서 급여(sal) 가 2000보다 큰 사람의 
--이름(ename)과 급여(sal)를 출력하세요
SELECT ENAME , SAL FROM T_EMP WHERE SAL > 2000;

--직원 테이블(t_emp) 에서 이름(ename)이 SCOTT인 사람의 
--이름(ename)과 사원번호(empno), 급여(sal) 출력
SELECT ENAME 이름, EMPNO 사원번호, sal 급여
FROM T_EMP 
WHERE ENAME = 'SCOTT';  -- 홑따옴표로!!

-- 연습
-- 학생 테이블(t_student) 에서
-- 2,3 학년(grade) 학생의  이름(name), 학년(grade) 출력
SELECT name, GRADE FROM T_STUDENT WHERE GRADE = 2 OR GRADE = 3;
SELECT NAME , GRADE FROM T_STUDENT WHERE GRADE IN(2, 3);
SELECT NAME , GRADE FROM T_STUDENT WHERE GRADE > 1 AND GRADE < 4;
SELECT NAME , GRADE FROM T_STUDENT WHERE GRADE NOT IN (1, 4);
SELECT NAME , GRADE FROM T_STUDENT WHERE GRADE BETWEEN 2 AND 3;
-- 모두 같은 결과 출력


-- 연습
-- 교수님 (t_professor) 중에서
-- 급여 (pay) 가 300 보다 크고,
-- 직급 (position) 이 '정교수' 인 분들의
-- 이름(name), 급여(pay), 직급(position) 을 출력하세요
SELECT NAME 이름, PAY 급여, "POSITION" AS 직급
FROM T_PROFESSOR 
WHERE PAY > 300 AND "POSITION" = '정교수';

-- 보너스(bonus)를 못받고 있는 
-- 교수님의 이름(name)과 직급(position)를 출력하세요
SELECT name 이름, "POSITION" 직급
FROM T_PROFESSOR 
WHERE BONUS IS NULL;   --  bonus = null  이렇게 하지 말라 그랬지..!  is null / is not null 이렇게해야 함!!


-- LIKE 
-- 교수님 중에서 김씨 성을 가진 교수님의 이름만 출력 (LIKE 사용)
SELECT  name 
FROM T_PROFESSOR  
WHERE name LIKE '김%';  -- '김'으로 시작하는 이름 출력

-- 직원 테이블(t_emp)에서 직원이름 (ename) 중에
-- NE 문자열이 포함된 직원만 출력
SELECT ENAME 
FROM T_EMP 
WHERE ENAME LIKE '%NE%';  -- N 으로 시작하거나, NE 를 가지고 있는 사람들의 이름 출력

-- 직원 테이블(t_emp)에서 직원이름 (ename) 중에
-- 두번째 글자가 'A' 인 사람의 이름(ename)만 출력
SELECT ENAME 
FROM  T_EMP 
WHERE ENAME LIKE '_A%';


------------------------------------------
-- ORDER BY
-- 직원중 이름에 L 이 들어간 사람의 이름을 사전내림차순으로 출력하기
SELECT ENAME 
FROM T_EMP 
WHERE ENAME LIKE '%L%' -- 이름에 L 에 포함되어 있는 사람의 이름 
ORDER BY ENAME DESC ;


-- 직원의 이름,직책, 급여를 출력하되
-- 우선은 직책(job) 사전 내림차순으로, 
-- 그리고 급여(sal) 오름차순으로 출력
SELECT ENAME , JOB , SAL 
FROM T_EMP 
ORDER BY SAL ASC , JOB DESC   -- 컬럼 순서대로 정렬함. 
;
-- 만약에 sal 먼저 오름차순 했으면, 그에 맞게 job 이 내림차순되고,
-- job 이 먼저 내림차순 했으면, 그에 맞게 sal 이 오름차순이 된다. 


-- 연습
-- 학생 테이블(t_student) 에서  학생의 이름(name)과 학년(grade)와 키(height)를 출력하세요, 
-- 단 학년은 1학년부터 출력하고,  키는 큰사람부터  출력하세요
SELECT NAME 이름, GRADE 학년, HEIGHT 키
FROM T_STUDENT 
ORDER BY GRADE ASC , HEIGHT DESC ;

