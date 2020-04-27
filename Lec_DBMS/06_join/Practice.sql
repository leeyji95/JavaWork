-- SINGLE 함수 - 문자열, 숫자, 시간/날짜
--  INICAP() LENGTH(컬럼이름) CONCAT() ★SUBSTR() ★INSTR() ★TRIM() ★REPLACE()
-- ★SUBSTR() : 어떤 컬럼값에서, 몇번째 글자부터 시작해서 , 몇 글자 뽑겠다.
-- ★INSTR()_숫자리턴  : 어떤 컬럼값에서, 찾을 문자, 몇번쨰 글자에서 시작하고, 몇번째에 등장하는 문자   -> 개의 인덱스 번호(갸의 위치 번호 리턴함)
-- ★(R/L)TRIM()   : 어떤 컬럼값에서, 어떤 문자 를 제거. (DENAME, '부') DENAME 에서 부 삭제 
-- ★REPLACE(): 어떤 컬럼에서, 어떤 문자를 어떤 문자로 바꿈.

-- ★ NVL() NVL2()
-- TO_NUMBER() ★TO_CHAR() ★TO_DATE()
-- ★ROUND() ★TRUNC() CEIL()FLOOR() MOD() ★POWER()

-- GROUP 함수 
-- COUNT() SUM() AVG() MAX() MIN()

-- JOIN(등가,비등가) -> ANSI 방식, ORACLE 방식 

-- -------------------------------------------------------------

SELECT NAME 이름, ID, LENGTH(ID) "글자수"
FROM T_STUDENT 
WHERE LENGTH(ID) >= 9   -- ID 의 길이가 9 이상일때.
;

SELECT NAME, LENGTH(NAME), LENGTHB(NAME)
FROM T_STUDENT 
WHERE DEPTNO1 = 201
;

SELECT CONCAT(NAME, "POSITION") "교수님 명단" 
FROM T_PROFESSOR 
WHERE DEPTNO = 101
;

SELECT SUBSTR('ABCDE', 2, 3)  -- 두번째 글자부터 시작해서 3글자 뽑겠다
FROM DUAL;

SELECT SUBSTR('ABCDE', -2, 3) -- DE  뒤에서 2번째 글자부터 시작해서 3글자 뽑겠다. 
FROM DUAL;

SELECT NAME, SUBSTR(JUMIN , 1, 6) 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

SELECT NAME, SUBSTR(JUMIN , 1, 6) 
FROM T_STUDENT 
WHERE JUMIN LIKE '__08%'  -- 앞ㅇ 두글자 꼭 들어가야 되고, 3, 4번째에 08 숫자가 꼭 들어가야하ㅗㄱ, 뒤에 아무글자 와두 됨
;

SELECT NAME, SUBSTR(JUMIN , 1, 6)
FROM T_STUDENT
WHERE SUBSTR(JUMIN , 3, 2) = '08'  -- JUMIN 에서 세번째 글자부터 시작해서 2글자 뽑겠다.
;

SELECT NAME, JUMIN 
FROM T_STUDENT 
WHERE GRADE = 4 AND SUBSTR(JUMIN , 7, 1) = '1' 
;

----- 오늘 수업내용
SELECT NAME, TEL, INSTR(TEL, ')',1,1) AS 위치   -- 1번글자부터 시작, 1번째 등장 ==> 디폴트값임. 주로 생략 많이함.
FROM T_STUDENT 
WHERE DEPTNO1 = 101
;

SELECT NAME, TEL, SUBSTR(TEL, 1, INSTR(TEL, ')') -1) AS 지역변호 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;


SELECT DNAME , RTRIM(DNAME , '부') -- 부  가진 이름에서 부 제거  
FROM T_DEPT2 
;

SELECT 
	TRIM('                 슈  퍼  멘                 ') TRIM 
FROM DUAL;

SELECT REPLACE('               슈퍼                     맨       ', ' ')
FROM DUAL;    -- 모든 공백 제거 

SELECT NAME, REPLACE(NAME, SUBSTR(NAME , 2, 1), '#' )
FROM T_STUDENT ;

SELECT NAME , REPLACE(JUMIN , SUBSTR(JUMIN , 7, 7), '*******' )
FROM T_STUDENT ;

SELECT NAME, TEL, REPLACE(TEL, SUBSTR(TEL, INSTR(TEL, ')') + 1 , 3), '###') 
FROM T_STUDENT 
WHERE DEPTNO1 = 102;

---------------------------------------------------

SELECT  * FROM T_PROFESSOR ;

SELECT NAME, PAY, BONUS , PAY+BONUS , PAY+NVL(BONUS, 0)   -- BONUS 가 NULL 이면 -> ㅁBONUS 를 0 으로 치환 하여 생각하면 쉬움.
FROM T_PROFESSOR 
;

SELECT NAME, PAY, NVL2(BONUS , BONUS , 0) BONUS ,
	NVL2(BONUS , PAY*12+BONUS , PAY*12)   -- BONUS 가 NULL이 아니면, 두번째 수행, NULL 이면 세번째 수행.
FROM T_PROFESSOR 
;
SELECT 
	SYSDATE,
	TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS 날짜
FROM DUAL;


SELECT 
	SYSDATE,
	TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일" HH24"시"MI"분"SS"초"') 
FROM DUAL;

-- #4302)  t_student 테이블의 생일(birthday)이 
-- 3월인 학생의 이름(name) 과 생일(birthday) 를  
-- 다음과 같은 형식으로 출력하세요 (TO_CHAR 사용)
SELECT NAME 이름, TO_CHAR(BIRTHDAY , 'YYYY-MM-DD') 생일
FROM T_STUDENT 
WHERE TO_CHAR(BIRTHDAY, 'MM') = '03' 
;


SELECT 
	TO_CHAR(SYSDATE, 'MM') 월,
	TO_CHAR(SYSDATE, 'YYYY') 연도,
	TO_CHAR(SYSDATE, 'DD') 일,
	TO_CHAR(SYSDATE, 'HH24') 시,
	TO_CHAR(SYSDATE, 'DAY') 요일,
	TO_CHAR(SYSDATE, 'DY') 요일앞자리,
	TO_CHAR(SYSDATE, 'MONTH'),
FROM DUAL;

SELECT 
	TO_CHAR(SYSDATE, 'YEAR') 영문연도, 
	TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE=ENGLISH')  
FROM DUAL;

SELECT 
	TO_CHAR(7880999, '$99999,999') 
FROM DUAL;

SELECT  NAME 이름, NVL2(BONUS , TO_CHAR((PAY*12)+BONUS , '9999,999'), TO_CHAR(PAY*12,'99999,999')) 
FROM T_PROFESSOR 
WHERE DEPTNO = 101
;

SELECT NAME, TO_CHAR(PAY * 12 + NVL(BONUS , 0), '9999,999') 
FROM T_PROFESSOR 
WHERE DEPTNO = 101
;


SELECT 
	TO_DATE('2020-02-29', 'YYYY-MM-DD') TO_DATE
FROM DUAL;


SELECT 
	NAME 이름, 
	TO_CHAR(HIREDATE , 'YYYY-MM-DD') 입사일, 
	TO_CHAR(PAY * 12, '999,999') 연봉, 
	TO_CHAR(PAY * 12 * 1.1 , '999,999') 인상후 
FROM T_PROFESSOR 
WHERE TO_CHAR(HIREDATE, 'YYYY') < '2000'
;

SELECT 
	SYSDATE 오늘,
	TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD HH24:MI:SS') 시작한날,
	SYSDATE -  TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD HH24:MI:SS') 경과
FROM DUAL;


SELECT 
	MONTHS_BETWEEN() 
FROM DUAL;

SELECT 
	NAME 이름,
	TO_CHAR(SYSDATE, 'YYYY-MM-DD') 오늘, 
	TO_CHAR(HIREDATE, 'YYYY-MM-DD') 입사일,
	TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIREDATE, 'YYYY') 근속연수,
--	TO_CHAR(SYSDATE, 'DD') - TO_CHAR(HIREDATE, 'DD')   오늘의 일  - 입사한 일 을  뺸 결과가 나오지.
	TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 근속개월,
	TRUNC(SYSDATE - HIREDATE) 근속일수
FROM T_PROFESSOR ;


SELECT 
	TO_CHAR(SYSDATE, 'YYYY-MM-DD') 오늘,
	TO_CHAR(HIREDATE , 'YYYY-MM-DD') 입사일,
	TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIREDATE , 'YYYY') 근속연수,
	TRUNC(SYSDATE - HIREDATE) 근속일수,
	TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 근속개월
FROM T_PROFESSOR ;



SELECT DEPTNO , ROUND(AVG(NANVL(BONUS ,0)), 1) 보너스평균
FROM T_PROFESSOR 
GROUP BY DEPTNO 
;

SELECT DEPTNO , "POSITION" , AVG(PAY) 평균급여
FROM T_PROFESSOR 
GROUP BY DEPTNO , "POSITION" 
ORDER BY DEPTNO ASC, "POSITION" ASC 
;


-- #5102 
SELECT * FROM T_EMP ;
SELECT 
	MGR 매니저,  				-- 4 ,5 , 6 ... 수행
	COUNT(*) 직원수,  -- --> 매니저를 그룹핑했기때문에 그 결과 바탕으로 COUNT 수 집계. 
	SUM(SAL) 급여총액,
	ROUND(AVG(SAL ), 1) 급여평균,
	TRUNC(AVG(NVL(COMM, 0))) 교통비평균 
FROM T_EMP                  -- 1번으로 수행
WHERE JOB != 'PRESIDENT'    -- 2번으로 수행
GROUP BY MGR 				-- 3번으로 수행
--HAVING JOB IS NOT 'PRESIDENT'
;

SELECT * FROM T_PROFESSOR ;
SELECT 
	DEPTNO , 
	COUNT(DEPTNO ) 총인원, 
	TRUNC(AVG(SYSDATE - HIREDATE)) 근속평균,
	AVG(PAY ) 급여평균,
	TRUNC(AVG(NVL(BONUS, 0))) 보너스평균
FROM T_PROFESSOR 
WHERE "POSITION" IN('정교수', '조교수')
GROUP BY DEPTNO 
ORDER BY DEPTNO 
;


SELECT S.STUDNO , S.NAME , S.BIRTHDAY 
FROM T_STUDENT S
;




SELECT S.NAME 학생이름, S.PROFNO 지도교수, P.NAME 지도교수이름
FROM T_STUDENT S, T_PROFESSOR P
WHERE S.PROFNO = P.PROFNO 
;

SELECT S.NAME 학생이름, S.PROFNO 지도교수, P.NAME 지도교수이름
FROM T_STUDENT S JOIN T_PROFESSOR P
	ON S.PROFNO = P.PROFNO 
;

SELECT S.NAME, D.DNAME , P.NAME 
FROM T_STUDENT S, T_DEPARTMENT D, T_PROFESSOR P
WHERE S.DEPTNO1 = D.DEPTNO AND S.PROFNO = P.PROFNO 
;

SELECT S.NAME, D.DNAME , P.NAME 
FROM
	T_STUDENT S	
	JOIN T_DEPARTMENT D ON S.DEPTNO1 = D.DEPTNO 
	JOIN T_PROFESSOR P ON S.PROFNO = P.PROFNO 
;



---------------------------------------------------
SELECT * FROM T_DEPT2 ;
-- #9001
DELETE TABLE T_EMP7 CASCADE CONSTRAINT ; 
-- 테이블 생성과 동시에 제약조건 걸기
CREATE TABLE T_EMP7(
	NO NUMBER(4) PRIMARY KEY,
	NAME VARCHAR2(10) NOT NULL,
	JUNIM VARCHAR2(13) NOT NULL UNIQUE,
	AREA NUMBER(1) CHECK(AREA < 5),
	DEPTNO VARCHAR2(6) REFERENCES T_DEPT2(DCODE)
);

SELECT * FROM T_EMP7;

--< 테이블 생성과 별도로 제약조건 정의 가능 >---- 
CREATE TABLE T_EMP8(
	NO NUMBER(4),
	NAME VARCHAR2(10) NOT NULL,
	JUMIN VARCHAR2(13) NOT NULL,
	AREA NUMBER(1),
	DEPTNO VARCHAR2(6),
-- 컬럼 이름과 타입 먼저 지정해주고~   아래에다가 제약조건 나열하기 
	PRIMARY KEY(NO),
	UNIQUE(JUMIN), 
	CHECK(AREA < 5),
	FOREIGN KEY(DEPTNO) REFERENCES T_DEPT2(DCODE)
);


--------------- <제약 조건에 이름붙이기> --------------------  동시에 만들때에는, 제약조건 앞에다가 이름 붙여주기 
-- # 9002
-- 제약조건에 이름붙이기 (효율적인 관리위해)
-- 테이블 동시에 생성하면서 제약조건명 붙이기
DROP TABLE T_EMP7 CASCADE CONSTRAINT;  -- **  TABLE 삭제 --> DROP!   DELETE XXXXX
CREATE TABLE T_EMP7(
	NO NUMBER(4) CONSTRAINT emp7_no_pk PRIMARY KEY, -- CONSTRAINT emp7_no_pk
	NAME VARCHAR2(10) CONSTRAINT emp7_name_nn NOT NULL, --CONSTRAINT emp7_name_nn
	JUMIN VARCHAR2(13) CONSTRAINT emp7_jumin_nn NOT NULL -- ONSTRAINT emp7_jumin_nn 
						CONSTRAINT emp7_jumin_uk UNIQUE,  -- CONSTRAINT emp7_jumin_uk
	AREA NUMBER(1) CONSTRAINT emp7_area_ck CHECK(AREA < 5),  -- CONSTRAINT emp7_area_ck
	DEPTNO VARCHAR(6) CONSTRAINT emp7_deptno_fk REFERENCES T_DEPT2(DCODE)  -- CONSTRAINT emp7_deptno_fk
);


----< 제약조건이름붙이기  따로 정의> ---------------------
DROP TABLE T_EMP7 CASCADE CONSTRAINT; 
CREATE TABLE T_EMP7(
	NO NUMBER(4), 
	NAME VARCHAR(10) CONSTRAINT emp7_name_nn NOT NULL,
	JUMIN VARCHAR(13) CONSTRAINT emp7_jumin_nn NOT NULL,
	AREA NUMBER(1),
	DEPTNO VARCHAR(6),
	CONSTRAINT emp7_no_pk PRIMARY KEY(NO),
	CONSTRAINT emp7_jumin_uk UNIQUE(JUMIN),
	CONSTRAINT emp7_area_ck CHECK(AREA < 5),
	CONSTRAINT emp7_deptno_fk FOREIGN KEY(DEPTNO) REFERENCES T_DEPT2(DCODE)
);

SELECT * FROM T_EMP7;


-- 제약조건 조회하기!!
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'T_EMP7'
;

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_EMP8'
;



INSERT INTO T_EMP7 VALUES(1, '오라클', '1234561234567', 4, 1001);
INSERT INTO T_EMP7 VALUES(2, '키득', '7234561234567', 4, 1001);
INSERT INTO T_EMP7 VALUES(4, '메롱', '1589661234567', 4, 1006);

UPDATE T_EMP7 SET AREA = 3 WHERE NO = 2;

DELETE FROM T_EMP7 WHERE DEPTNO = 1001;

 SELECT * FROM T_EMP7;
---------------------------------------------------------
 SELECT S.NAME 이름, P.PROFNO 지도교수, P.NAME 지도교수이름
 FROM T_STUDENT S RIGHT JOIN T_PROFESSOR P
 	 ON S.PROFNO = P.PROFNO 
 ;
SELECT * FROM T_STUDENT ;
SELECT * FROM T_DEPARTMENT ;

SELECT S.NAME 학생이름, D.DNAME 학과이름, P.NAME 교수이름
FROM T_STUDENT S, T_DEPARTMENT D, T_PROFESSOR P
WHERE S.DEPTNO1 = D.DEPTNO AND S.PROFNO = P.PROFNO 
;

SELECT E.NAME 사원이름, E.POST 현재, E.PAY 현재연봉, P.S_PAY 하한금액, P.E_PAY 상한금액
FROM T_EMP2 E, T_POST P 
WHERE E.POST = P.POST 
;

SELECT S.NAME 학생이름, P.NAME 교수이름
FROM T_STUDENT S JOIN T_PROFESSOR P
 ON S.PROFNO = P.PROFNO  -- 2. 학생의 교수번호 = 교수번호 
WHERE S.DEPTNO1 = 101  -- 1. 먼저 검색조건 수행
;

SELECT * FROM T_CUSTOMER ;
SELECT * FROM T_GIFT ;

SELECT G.G_NAME 상품명, COUNT(*) 필요수량  
FROM T_CUSTOMER C, T_GIFT G
WHERE C.C_POINT BETWEEN G.G_START AND G.G_END 
GROUP BY G.G_NAME 
;

SELECT * FROM T_CREDIT ;
SELECT * FROM T_EXAM01 ;

SELECT S.NAME 이름, E.TOTAL 점수, C.GRADE 학점
FROM T_STUDENT S 
	JOIN T_EXAM01 E ON S.STUDNO = E.STUDNO 
	JOIN T_CREDIT C ON E.TOTAL BETWEEN C.MIN_POINT AND C.MAX_POINT 
;

SELECT * FROM T_EMP2 ;
SELECT * FROM T_POST ;

SELECT E.NAME 사원이름, 
	(TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(E.BIRTHDAY, 'YYYY') + 1) 나이,
	NVL(E.POST , ' ') 현재직급, P.POST 예상직급
FROM T_EMP2 E, T_POST P
WHERE 	((TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(E.BIRTHDAY, 'YYYY') ) + 1)
		BETWEEN P.S_AGE AND P.E_AGE 
;


SELECT E.NAME 사원이름, 
	(TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(E.BIRTHDAY, 'YYYY') + 1 ) 나이,
	NVL(E.POST , ' ') 현재직급,
	P.POST 예상직급
FROM T_EMP2 E
 	JOIN T_POST P
 	ON (TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(E.BIRTHDAY, 'YYYY') + 1 )
 		BETWEEN P.S_AGE AND P.E_AGE 
 ;

SELECT  * FROM T_DEPT2 ;

SELECT D1.DNAME, D2.DNAME 
FROM T_DEPT2 D1, T_DEPT2  D2
WHERE D1.DCODE = D2.PDEPT 
;


-----------------------------------------------------------------

SELECT SAL FROM T_EMP WHERE ENAME = 'SCOTT';

SELECT  ENAME , SAL 
FROM T_EMP 
WHERE SAL > (SELECT SAL FROM T_EMP WHERE ENAME = 'SCOTT')
;

SELECT  MAX(HEIGHT) "HEIGHT" FROM T_STUDENT;
SELECT NAME , HEIGHT 
FROM T_STUDENT 
WHERE HEIGHT = (SELECT  MAX(HEIGHT) "HEIGHT" FROM T_STUDENT)
;


SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나';

SELECT S.NAME 학생이름, D.DNAME "1전공"
FROM T_STUDENT S, T_DEPARTMENT D
WHERE S.DEPTNO1 = D.DEPTNO AND S.DEPTNO1 = (SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나')
;

SELECT TO_CHAR(HIREDATE ,'YYYY-MM-DD') FROM T_PROFESSOR WHERE NAME = '송도권';
SELECT P.NAME 교수명, TO_CHAR(P.HIREDATE , 'YYYY-MM-DD') 입사일, D.DNAME 학과명
FROM T_PROFESSOR P, T_DEPARTMENT D
WHERE P.DEPTNO = D.DEPTNO 
	AND P.HIREDATE > (SELECT TO_CHAR(HIREDATE ,'YYYY-MM-DD') FROM T_PROFESSOR WHERE NAME = '송도권')
;


SELECT AVG(WEIGHT) FROM  T_STUDENT  WHERE DEPTNO1 = 101 ;
SELECT NAME 이름, WEIGHT 몸무게
FROM T_STUDENT 
WHERE WEIGHT  > (SELECT AVG(WEIGHT) FROM  T_STUDENT  WHERE DEPTNO1 = 101 )
;

SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '심슨';
SELECT NAME 이름, PAY 급여, TO_CHAR(HIREDATE , 'YY/MM/DD') 
FROM T_PROFESSOR 
WHERE HIREDATE = (SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '심슨')
	AND PAY < (SELECT PAY FROM T_PROFESSOR WHERE NAME = '조인형')
;

SELECT * FROM T_DEPT2 ;
SELECT DCODE FROM T_DEPT2 WHERE AREA = '서울지사'
; -- 다중행 서브쿼리 결과 

SELECT * FROM T_EMP2 ;
SELECT E.EMPNO 사번, E.NAME 이름, D.DCODE 부서번호
FROM T_DEPT2 D, T_EMP2 E
WHERE E.DEPTNO = (SELECT DCODE FROM T_DEPT2 WHERE AREA = '서울지사')
;

SELECT EMPNO , NAME , DEPTNO 
FROM T_EMP2 
WHERE DEPTNO IN (SELECT DCODE FROM T_DEPT2 WHERE AREA = '서울지사')
;  -- 


SELECT MIN(PAY) FROM T_EMP2 WHERE POST = '과장';
SELECT NAME 이름, POST 직급, TO_CHAR(PAY, '9999,999,999') || '원'  연봉
FROM T_EMP2 
WHERE PAY >ANY (SELECT MIN(PAY) FROM T_EMP2 WHERE POST = '과장')
;


SELECT MIN(WEIGHT) FROM T_STUDENT WHERE GRADE = 4;
SELECT NAME, GRADE , WEIGHT 
FROM T_STUDENT 
WHERE WEIGHT <ALL (SELECT MIN(WEIGHT) FROM T_STUDENT WHERE GRADE = 4)
;

SELECT GRADE, MAX(HEIGHT) FROM T_STUDENT GROUP BY GRADE ;
SELECT GRADE , NAME , HEIGHT 
FROM T_STUDENT 
WHERE (GRADE , HEIGHT) IN (SELECT GRADE, MAX(HEIGHT) FROM T_STUDENT GROUP BY GRADE )
;

SELECT DEPTNO , MIN(HIREDATE ) FROM T_PROFESSOR GROUP BY DEPTNO 
;
SELECT P.PROFNO 교수번호, P.NAME 교수명, 
	TO_CHAR(HIREDATE , 'YYYY-MM-DD') 입사일,
	D.DNAME 학과명
FROM T_PROFESSOR P, T_DEPARTMENT D
WHERE (P.DEPTNO, HIREDATE) IN (SELECT DEPTNO , MIN(HIREDATE ) FROM T_PROFESSOR GROUP BY DEPTNO)
	AND P.DEPTNO = D.DEPTNO 
ORDER BY 4 ASC
;

SELECT NVL(POST, ' '), MAX(PAY) FROM T_EMP2 GROUP BY POST ;
SELECT NAME 사원명, POST 직급, TO_CHAR(PAY, '9999,999,999')||'원' 연봉
FROM T_EMP2 
WHERE (POST, PAY) IN (SELECT NVL(POST, ' '), MAX(PAY) FROM T_EMP2 GROUP BY POST)
ORDER BY PAY ASC 
;

SELECT MIN(AVG(PAY )) FROM T_EMP2 GROUP BY DEPTNO ;

SELECT D.DNAME 부서명, E.NAME 직원명, E.PAY 연봉
FROM T_EMP2 E, T_DEPT2 D
WHERE  E.PAY <ALL  (SELECT MIN(AVG(PAY )) FROM T_EMP2 GROUP BY DEPTNO )
	AND E.DEPTNO = D.DCODE 
ORDER BY PAY ASC
;


-- 직급별 평균연봉
SELECT AVG(A.PAY) FROM T_EMP2 A WHERE A.POST = '과장';

SELECT B.NAME 사원이름, NVL(B.POST , ' ') 직급, PAY 급여
FROM T_EMP2 B
WHERE B.PAY >= (SELECT AVG(A.PAY) FROM T_EMP2 A WHERE NVL(A.POST, ' ') = NVL(B.POST, ' '))
;












