SELECT * FROM T_PROFESSOR ;
SELECT COUNT(*), COUNT(HPAGE ) FROM T_PROFESSOR ;  -- 그룹함수에서는 NULL 값은 계산에서 제외.
SELECT COUNT(BONUS ), SUM(BONUS ), AVG(BONUS ) FROM T_PROFESSOR ;
SELECT MAX(HIREDATE), MIN(HIREDATE )FROM T_EMP ; 

-- AVG 의 경우, 보너스 받는 사람들만 계산된다. 그럼 평균이 객관적이지 않지.
-- 그러므로~ NULL 허용 컬럼의 그룹함수 적용시,
-- NVL, NVL2 사용해야한다.
SELECT AVG(BONUS), AVG(NVL(BONUS , 0)) 
FROM T_PROFESSOR ;

-- T_PROFESSOR 테이블에서 '학과별' 로 교수들의 평균 보너스 출력하세요

-- ★★ 불가능하다! SELECT 절에 GROUP 함수와 GROUP 함수가 아닌 것과는 같이 출력 불가 ~~~
--SELECT DEPTNO , AVG(BONUS )   -- SELECT 자리에 그룹함수와 그룹함수가 아닌것들이 함께 올 수 없다. !!  
--FROM T_PROFESSOR ;

SELECT DEPTNO , ROUND(AVG(NVL(BONUS , 0)), 1) 보너스평균 
FROM T_PROFESSOR 
GROUP BY DEPTNO ;  --  그룹함수가 아닌건, 그룹으로 묶으면 가능하다!!

-- #5101
SELECT DEPTNO , "POSITION" ,AVG(PAY) 평균급여 
FROM T_PROFESSOR 
GROUP BY DEPTNO ,"POSITION"   -- 단계별로  1. 학과별 그룹핑, 2. 직급별 그룹핑, 
ORDER BY DEPTNO ASC , "POSITION" ASC
;


SELECT DEPTNO , ROUND(AVG(PAY), 1) 평균급여
FROM T_PROFESSOR
--WHERE AVG(PAY) > 450  -- 그룹함수는 WHERE 절에서 사용불가 
GROUP BY DEPTNO
HAVING AVG(PAY) > 300 
;


-- <SELECT 쿼리문 순서>
--SELECT
--FROM
--WHERE
--GROUP BY
--HAVING
--ORDER BY

SELECT * FROM T_EMP ;

-- #5102
SELECT 						-- 4, 5, 6, ... 수행
	MGR 매니저, 			
	COUNT(*) 직원수,  	-- -> 매니저를 그룹핑했기 때문에 그 결과 바탕으로 COUNT 수 집계.		
	SUM(SAL) 급여총액,
	TRUNC(AVG(SAL)) 급여평균, 
	AVG(NVL(COMM , 0)) 교통비평균
FROM T_EMP 					-- 1번으로 수행
WHERE JOB != 'PRESIDENT'	-- 2번으로 수행
GROUP BY MGR  				-- 3번으로 수행
--HAVING MGR IS NOT NULL 
;


-- #5103
SELECT 
	DEPTNO , 
	COUNT(DEPTNO) 총인원, 
	ROUND(AVG(SYSDATE - HIREDATE),1) 근속평균,
	AVG(PAY) 급여평균, 
	AVG(NVL(BONUS , 0)) 보너스평균 
FROM T_PROFESSOR 
WHERE "POSITION" IN ('정교수', '조교수')
GROUP BY DEPTNO 
;

SELECT 
	DEPTNO , 
	COUNT(*) 총인원, 
	ROUND(AVG(SYSDATE - HIREDATE), 1) 근속일수평균,
	AVG(PAY ) 급여평균, 
	AVG(NVL(BONUS , 0)) 보너스평균 
FROM T_PROFESSOR 
WHERE "POSITION" LIKE '%교수'
GROUP BY DEPTNO ;




-- #5104
SELECT DEPTNO1 학과, MAX(WEIGHT ) - MIN(WEIGHT) 최대최소몸무게차
FROM T_STUDENT 
GROUP BY DEPTNO1; 

-- #5105
SELECT MAX(WEIGHT ) - MIN(WEIGHT) "30이상"
FROM T_STUDENT 
GROUP BY DEPTNO1
HAVING MAX(WEIGHT ) - MIN(WEIGHT) >= 30;

