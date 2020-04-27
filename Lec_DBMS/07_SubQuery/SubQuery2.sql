-- 3. 다중칼럼 Sub Query
-- Sub Query 결과가 여러 칼럼인 경우.  
-- 주로 Primary Key 를 여러 칼럼을 합쳐서 만들었을 경우 한꺼번에 
-- 비교하기 위해서 자주 사용.


--#7201) 예제
-- t_student 테이블을 조회하여  각 학년별로 최대 키를 가진 학생들의 
-- 학년과 이름과 키를 출력하세요 학년 오름차순으로 출력
SELECT GRADE , MAX(HEIGHT) FROM T_STUDENT GROUP BY GRADE 
;

SELECT GRADE 학년, NAME 이름, HEIGHT 키
FROM T_STUDENT 
WHERE (GRADE , HEIGHT) IN (SELECT GRADE , MAX(HEIGHT) FROM T_STUDENT GROUP BY GRADE)
--다중은 두개의 컬럼으로 받아야 한다
ORDER BY 학년 ASC   -- SELECT 다음에 수행되기 떄문에 별명 쓸 수 있다   ,,    ORDER BY 는 별명, 인덱스번호, 컬럼네임 모두 사용가능하다 
;

-- #7202
SELECT DEPTNO , TO_CHAR(MIN(HIREDATE), 'YYYY-MM-DD')
FROM T_PROFESSOR 
GROUP BY DEPTNO 
;

SELECT P.PROFNO 교수번호, P.NAME 교수명, TO_CHAR(P.HIREDATE, 'YYYY-MM-DD') 입사일, D.DNAME 학과명
FROM T_PROFESSOR P, T_DEPARTMENT D
WHERE (D.DEPTNO , P.HIREDATE) 
	IN (SELECT DEPTNO , TO_CHAR(MIN(HIREDATE), 'YYYY-MM-DD') FROM T_PROFESSOR 
		GROUP BY DEPTNO )
ORDER BY 4 ASC 
;


-- #7203
SELECT POST , MAX(PAY) 
FROM T_EMP2 
GROUP BY POST 
;

SELECT NAME 사원명, POST 직급, PAY 연봉
FROM T_EMP2 
WHERE (POST , PAY) IN (SELECT POST , MAX(PAY) FROM T_EMP2 GROUP BY POST )
ORDER BY PAY ASC
;

SELECT * FROM T_EMP2 ;
SELECT * FROM T_DEPT2 ;


-- #7204
-- t_emp2, t_dept2 테이블 : 
-- 각 부서별 평균 연봉을 구하고 
-- 그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다 적게 받는 
-- 직원들의 부서명, 직원명, 연봉을 출력 하세요
SELECT AVG(PAY) FROM T_EMP2 GROUP BY DEPTNO ;

SELECT D.DNAME 부서명, E.NAME 직원명, PAY 연봉
FROM T_EMP2 E, T_DEPT2 D
WHERE D.DCODE = E.DEPTNO  AND (E.PAY) <ALL (SELECT AVG(PAY) FROM T_EMP2 GROUP BY DEPTNO)
ORDER BY E.PAY ASC
;



-- 직급별 평균연봉... 
SELECT NVL2(E.POST, E.POST, ' '), TRUNC(AVG(E.PAY)) FROM T_EMP2 E GROUP BY E.POST 
;
SELECT TRUNC(AVG(E1.PAY)) FROM T_EMP2 E1 GROUP BY E1.POST 
;


SELECT E.NAME 사원이름, E.POST 직급 
FROM T_EMP2 E
WHERE E.PAY >= (E.POST 직급의 평균연봉)
;

SELECT E.NAME 사원이름, NVL(E.POST, ' ') 직급, E.PAY 급여 
FROM T_EMP2 E
WHERE E.PAY >= (SELECT TRUNC(AVG(E1.PAY)) FROM T_EMP2 E1 WHERE NVL(E1.POST, ' ') = NVL(E.POST, ' ')) 
;




--t_emp2 테이블 직원들 중에서 자신의 직급의 평균연봉과  같거나 많이 받는 사람들의 
--이름과 직급, 현재 연봉을 출력하세요.

SELECT a.name "사원이름", NVL(a.post, ' ') "직급", a.pay "급여"
FROM t_emp2 a
-- WHERE a.pay >= (  a.post 직급의 평균연봉 )
WHERE a.pay >= (SELECT avg(b.pay) FROM t_emp2 b WHERE NVL(a.post, ' ') = NVL(b.post, ' '))     
;

SELECT avg(b.pay) FROM t_emp2 b WHERE '과장' = b.post;



-------------------------------------------
-- 스칼라 서브 쿼리
SELECT NAME 사원이름,
	(SELECT D.DNAME FROM T_DEPT2 D WHERE E.DEPTNO = D.DCODE ) 부서이름   -- <-- 하나의 값만 출력해야함. 두개 출력할려하면 에러.
FROM T_EMP2 E;




