-- 계층형 쿼리(hierarchical Query)

SELECT * FROM T_DEPT2 ; -- 하나의 테이블 안에 계층적으로 이루어진 컬럼들이 있다. 이 테이블에서 "서로의 계층관계에 주목!" 해야한다.

SELECT LPAD(DNAME, 10, '*') 부서명 FROM T_DEPT2 ;

-- LEVEL
SELECT DNAME, LEVEL
FROM T_DEPT2
CONNECT BY PRIOR DCODE = PDEPT -- 2. 우선순위로 가겠다.    
START WITH DCODE = 0001  -- 1. 사장실부터   
;

/* 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR  :  각 row 들이 어떻게 연결되어야 하는지 조건 지정      
 * PRIOR를 어느쪽에 주느냐가 중요!
 */

-- PRIOR 를 다른데 주면? ? 
SELECT DNAME, LEVEL
FROM T_DEPT2
CONNECT BY  DCODE = PRIOR PDEPT -- 2. 우선순위로 가겠다.         사장실의 PDEPT 의 부모(?) 윗대를 찾아감. 근데  값이 없어. 그래서 사장실만 나옴. 
START WITH DCODE = 0001  -- 1. 사장실부터 
;

SELECT DCODE, DNAME, PDEPT , LEVEL
FROM T_DEPT2
CONNECT BY  DCODE = PRIOR PDEPT -- 
START WITH DCODE = 1005  -- S/W지원(1) -> 기술부(2) -> 사장실(3)   타고타고 올라감
--START WITH DCODE = 1011  -- 영업4팀 -> 영업기획팀 -> 영업부 -> 사장실(LEVEL4) 
;


SELECT LPAD(DNAME , LEVEL * 6,  '*') 부서명 
FROM T_DEPT2 
CONNECT BY PRIOR DCODE = PDEPT 
START WITH DCODE = 0001
;

SELECT  * FROM T_EMP2 ;
SELECT DNAME ,DCODE , PDEPT FROM T_DEPT2;

SELECT LPAD(E.NAME ||' '|| D.DNAME || ' ' ||NVL(E.POST , '사원') , LEVEL*22, '-') "이름과 직급"
FROM T_EMP2 E, (SELECT DNAME ,DCODE , PDEPT FROM T_DEPT2) D
WHERE E.DEPTNO = D.DCODE  -- 조인조건
CONNECT BY PRIOR E.EMPNO = E.PEMPNO 
START WITH E.EMPNO = 20000101
;


SELECT LEVEL - 1  HR
FROM DUAL 
CONNECT BY LEVEL <= 10 

-- https://programmers.co.kr/ 
-- 계층형 쿼리 + 그룹, 아우터조인까지 
SELECT H.HR "HOUR", COUNT(DATETIME) "COUNT"
FROM 
    (SELECT LEVEL - 1 HR FROM DUAL CONNECT BY LEVEL <=24) H
    LEFT OUTER JOIN ANIMAL_OUTS A
    ON H.HR = TO_NUMBER(TO_CHAR(A.DATETIME, 'HH24'))
GROUP BY H.HR
ORDER BY 1
;
