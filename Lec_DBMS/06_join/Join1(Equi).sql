-- JOIN

-- FROM 절에 테이블에도 별칭(ALIAS) 를 줄 수 있다!
-- 20 레코드
SELECT S.STUDNO , S.NAME , S.DEPTNO1 
FROM T_STUDENT S;

-- 12레코드
SELECT D.DEPTNO , D.DNAME 
FROM T_DEPARTMENT D;


-- 카티션곱 (Cartesian Product)
-- 두개의 테이블을 JOIN 하게 되면, 
-- 각 테이블의 레코드들의 모든 조합이 출력된다.
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면 
-- 모든 카티션곱이 출력된다. 

-- 240개  ... 20개, 12개 레코드 의 모든 조합( 곱하기 240개)
SELECT *
FROM T_STUDENT S, T_DEPARTMENT D
;

SELECT S.STUDNO , S.NAME , S.DEPTNO1,
	D.DEPTNO , D.DNAME 
FROM T_STUDENT S, T_DEPARTMENT D  -- ORACLE 방식 
;


SELECT S.STUDNO , S.NAME , S.DEPTNO1,
	D.DEPTNO , D.DNAME 
FROM T_STUDENT S
 	CROSS JOIN T_DEPARTMENT D  -- ANSI 방식 
	ON S.DEPTNO1 = D.DEPTNO 
;

-- 비교해서 같은 것만 걸러내서 필요한 데이터만  가져감. 그게 쪼인!

-- 두 테이블이 조인해서 결과를 내야 함. 
-- EQUAL JOIIN(등가 join)
-- ORACLE JOIN 방식 
SELECT S.NAME "학생이름", S.DEPTNO1 학과번호, D.DNAME 학과이름
FROM T_STUDENT S, T_DEPARTMENT D
WHERE S.DEPTNO1 = D.DEPTNO  -- 조건 (Equi JOIN)


SELECT S.NAME "학생이름", S.DEPTNO1 학과번호, D.DNAME 학과이름
FROM T_STUDENT S 
	JOIN T_DEPARTMENT D ON S.DEPTNO1 = D.DEPTNO  -- JOIN 과 ON 은 쌍 .   WHERE는 다른 동작으로 쓰임 
;


SELECT * FROM T_STUDENT ;
-- 제 2전공?  DEPTNO2
SELECT S.NAME 학생이름, S.DEPTNO2 "제2학과", D.DNAME "제2학과이름"
FROM T_STUDENT S, T_DEPARTMENT D
WHERE S.DEPTNO2 = D.DEPTNO 
;

-- 두 테이블이 조인하는데, 조건이 맞는 애들만 결과에 나옴. NULL 인 애들은 조건에서 제외된다. 
-- 그 조인 조건에 맞는 애들만 결과로 나온다. 



-- #6102
-- ORACLE 방식
SELECT S.NAME 학생이름, S.PROFNO 지도교수, P.NAME 지도교수이름
FROM T_STUDENT S, T_PROFESSOR P
WHERE S.PROFNO = P.PROFNO  -- JOIN 조건
;
-- 결과 :  지도교수 배정되지 않은 학생들은 조건에 충족되지 못하므로  결과에서 배제됨.   

-- ANSI 방식
SELECT S.NAME 학생이름, S.PROFNO 지도교수, P.NAME 지도교수이름
FROM T_STUDENT S JOIN T_PROFESSOR P ON S.PROFNO = P.PROFNO 
;


-- #6103  이제 세개 이상인 테이블로  JOIN 해보자
-- ORACLE 방식
SELECT S.NAME 학생이름, D.DNAME 학과이름, P.NAME 교수이름
FROM T_STUDENT S, T_DEPARTMENT D, T_PROFESSOR P
WHERE S.DEPTNO1 = D.DEPTNO AND S.PROFNO = P.PROFNO 
;

-- ANSI 방식
SELECT S.NAME 학생이름, D.DNAME 학과이름, P.NAME 교수이름
FROM 
	T_STUDENT S 
	JOIN T_DEPARTMENT D ON S.DEPTNO1 = D.DEPTNO 
	JOIN T_PROFESSOR P ON S.PROFNO = P.PROFNO 
;

SELECT * FROM T_EMP2 ;
SELECT * FROM T_POST ;

-- ORACLE
SELECT E.NAME 사원이름, E.POST 현재, E.PAY 현재연봉, P.S_PAY 하한금액, P.E_PAY 상한금액
FROM T_EMP2 E, T_POST P 
WHERE E.POST = P.POST  -- JOIN 조건
;

-- ANSI
SELECT E.NAME 사원이름, E.POST 현재, E.PAY 현재연봉, P.S_PAY 하한금액, P.E_PAY 상한금액
FROM T_EMP2 E JOIN T_POST P ON E.POST = P.POST 
;


-- #6105
-- ORACLE
SELECT S.NAME 학생이름, P.NAME 교수이름
FROM T_STUDENT S, T_PROFESSOR P    -- 내부적으로 아래 검색조건 먼저 수행되고 범위 줄여서 카티션곱 수행한다. 1. 먼저 카티션곱 수행 , 2. WHERE 절 수행, 3.SELECT 뽑아냄
WHERE 
	S.PROFNO = P.PROFNO -- JOIN 조건 
	AND S.DEPTNO1 = 101 -- 검색조건    
;

--ANSI
SELECT S.NAME 학생이름, P.NAME 교수이름
FROM T_STUDENT S 
	JOIN T_PROFESSOR P ON S.PROFNO = P.PROFNO -- JOIN 조건 
WHERE S.DEPTNO1 = 101 -- 일반 검색조건    
;

SELECT S.NAME 학생이름, P.NAME 교수이름
FROM T_STUDENT S 
	JOIN T_PROFESSOR P ON S.PROFNO = P.PROFNO AND S.DEPTNO1 = 101 -- 일반 검색조건    
;



