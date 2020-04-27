-- 상위 몇개만 뽑고 싶을 떄 
-- -- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

SELECT EMPNO, ENAME, SAL FROM T_EMP ;


-- 자동적으로 오라클에서 붙여주는 행번호 객체(ROWNUM)
SELECT ROWNUM, EMPNO, ENAME, SAL FROM T_EMP ;


-- 직원번호 역순으로 오더바이 해도, ROWNUM 은 1 부터 시작한다! 
SELECT ROWNUM, EMPNO, ENAME, SAL FROM T_EMP ORDER BY EMPNO DESC ;


-- 여기서 상위 5개만 뽑고 싶으면? 
SELECT ROWNUM, EMPNO, ENAME, SAL FROM T_EMP 
WHERE ROWNUM <= 5   --  WHERE 조건절에 ROWNUM 조건 붙여준다 !
ORDER BY EMPNO DESC ;


-- SELECT에 ROWNUM 없어도 동작한다   -- 눈에 보이지 않아도 오라클에서 자동으로 생성해주는 객체이므로 사용가
SELECT EMPNO, ENAME, SAL FROM T_EMP 
WHERE ROWNUM <= 5   --  WHERE 조건절에 ROWNUM 조건 붙여준다 !
ORDER BY EMPNO DESC ;


-- ROWNUM > 5 ??? 동작안함. ..   ROWNUM 범위가 1이 포함안되면 동작 안함. 
SELECT ROWNUM, EMPNO, ENAME, SAL FROM T_EMP 
WHERE 5 < ROWNUM  --  안된다.  동작 xx
ORDER BY EMPNO DESC ;



-- 행이 여러개가 나왔는데, ROWNUM 을 제어할 수 있어야지, 페이징 크롤링 할 수 있는거임. 


SELECT ROWNUM, EMPNO, ENAME, SAL FROM T_EMP 
WHERE ROWNUM >= 1 AND ROWNUM < 1 + 5
ORDER BY EMPNO DESC ;

SELECT ROWNUM, EMPNO, ENAME, SAL FROM T_EMP 
WHERE ROWNUM >= 6 AND ROWNUM < 6 + 5
ORDER BY EMPNO DESC ;  -- 출력 안 된다... 

-- PHONEBOOK 뻥튀기..
SELECT * FROM PHONEBOOK ;
INSERT INTO PHONEBOOK (SELECT * FROM PHONEBOOK);  -- PRIMARY KEY 제약조건 설정되어 있어서  !  중복! 

INSERT INTO PHONEBOOK 
 	(SELECT PHONEBOOK_SEQ.NEXTVAL, PB_NAME , PB_PHONENUM, PB_MEMO , SYSDATE FROM PHONEBOOK);
 	
 -- ROWNUM REV.
 SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID  DESC;	

SELECT T.*
FROM (SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID  DESC) T    -- SELECT 도 하나의 테이블이므로 FROM 절에 들어올 수 있따. 별명 T 로 하고,
;

SELECT ROWNUM AS RNUM, T.*
FROM (SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID  DESC) T    -- SELECT 도 하나의 테이블이므로 FROM 절에 들어올 수 있따. 별명 T 로 하고,
;


-- 한 페이지 당 5개 데이터 출력 시 ,
-- 2 번째 페이지에 해당하는 걸 뽑은 거다. ...   오라클 더럽네.. 
SELECT  * FROM 
(
	SELECT ROWNUM AS RNUM, T.*
	FROM (SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID  DESC) T    -- SELECT 도 하나의 테이블이므로 FROM 절에 들어올 수 있따. 별명 T 로 하고,
)
WHERE RNUM >= 6 AND RNUM < 6 + 5
;

SELECT  * FROM 
(
	SELECT ROWNUM AS RNUM, T.*
	FROM (SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID  DESC) T    -- SELECT 도 하나의 테이블이므로 FROM 절에 들어올 수 있따. 별명 T 로 하고,
)
WHERE RNUM >= 21 AND RNUM < 21 + 10
;




SELECT  * FROM 
(
	SELECT ROWNUM AS RNUM, T.*
	FROM (SELECT PB_UID , PB_NAME , PB_PHONENUM FROM PHONEBOOK ORDER BY PB_UID  DESC) T    -- SELECT 도 하나의 테이블이므로 FROM 절에 들어올 수 있따. 별명 T 로 하고,
)
WHERE RNUM >= ? AND RNUM < ? + ?
;
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	


