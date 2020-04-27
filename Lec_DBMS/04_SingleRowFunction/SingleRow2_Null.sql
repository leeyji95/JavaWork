SELECT * FROM T_PROFESSOR ;

SELECT NAME , PAY , BONUS , PAY + BONUS  -- 이거 조심! 단일함수에서는!! NULL 과  모든 연산결과 무조건 NULL 이 나온다. 
FROM T_PROFESSOR ;


-- 근데  그룹함수에서는 연산 동작한다
-- 그룹함수에서 NULL 은 연산에서 제외되어 동작.    
SELECT SUM(PAY), SUM(BONUS) FROM T_PROFESSOR ;


-- NVL() 함수   (NULL 로 연산하면 안되는 경우 사용)
SELECT NAME , PAY , BONUS ,
		PAY + BONUS, 
		PAY + NVL(BONUS , 0) 총지급액   -- NULL 을 0 으로 바꿔서 연산 할 수 있음. 
FROM T_PROFESSOR ;   -- NVL(BOUNUS 를 0 으로  치환하여 연산하는 함수다)


-- #4201  컬럼이 NULL을 허용하는지 아닌지 예의 주시해야한다!!!  
SELECT NAME , PAY , NVL(BONUS, 0) BONUS , PAY *12 + NVL(BONUS , 0) 연봉 
FROM T_PROFESSOR WHERE DEPTNO = 101;

-- #4202
SELECT NAME , PAY , 
		NVL2(BONUS, BONUS , 0) BONUS ,  -- 삼항연산자처럼, BONUS 가 NULL 이 아니면, BONUS로, NULL이면 0으로 
		NVL2(BONUS , PAY * 12 + BONUS , PAY * 12) 연봉
FROM T_PROFESSOR WHERE DEPTNO = 101;

-- 항상 신경쓰기. NULL을 허용하는 컬럼에 대해서는 말이야!
-- 모든 컬럼에 대해서 디폴트로 NULL 을 허용함. 







