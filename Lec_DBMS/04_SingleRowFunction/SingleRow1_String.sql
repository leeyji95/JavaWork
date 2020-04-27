-- INITCAP() 함수

--#4101  -- 소문자로만 입력한 단어들이 첫문자를 대문자로 바꾸어 출력함
SELECT INITCAP('pretty girl') 
FROM DUAL ;  --한행짜리더미 테이블임

SELECT INITCAP('i like the way you are') 
FROM  DUAL;

--#4102      -- 개별적으로 함수가 적용되서 동작한 거,    별거 없음 ~ (모든 ID 앞글자만 대문자로)
SELECT  ID , INITCAP(ID) ID
FROM T_STUDENT 
WHERE DEPTNO1 = 201;


-- LOWER(). UPPER()  : 전부다 소문자 또는 대문자로
-- #4103 
SELECT NAME, ID, UPPER(ID) 대문자, LOWER(ID) 소문자
FROM T_STUDENT 
WHERE DEPTNO1  = 201;

-- LENGTH() / LENGTHB()    
--#4104 
SELECT NAME 이름 , ID , LENGTH(ID) "글자수" 
FROM T_STUDENT 
WHERE LENGTH(ID) >= 9; -- 단일행 함수는 where 조건절에서 사용 가능! 


-- #4105
SELECT  NAME , LENGTH(NAME ), LENGTHB(NAME )
FROM T_STUDENT 
WHERE DEPTNO1 = 201
;


-- CONCAT() 함수     문자열 연결 
-- #4106 
SELECT CONCAT(NAME , "POSITION" )  "교수님 명단"  -- NAME 과 POSITION 문자열 연결함
FROM T_PROFESSOR 
WHERE DEPTNO = 101;


-- SUBSTR() 함수
SELECT SUBSTR('ABCDE', 2, 3)  -- BCD  ..2번째 부터 시작해서 3개의 문자를 뽑아내라. B부터 시작해서 세글자니까 BCD    -- 'BCD' 문자열 인덱스 1부터 시작!
FROM DUAL ;

SELECT SUBSTR('ABCDE', 20, 3)   -- NULL  (에러아님, 아웃오브인덱스.. 이런 에러 안남)
FROM DUAL ;

SELECT SUBSTR('ABCDE', -2, 3)  -- DE
FROM DUAL ;

-- #4107
SELECT  NAME,  SUBSTR(JUMIN , 1, 6) 생년월일 -- jumin 에서 첫번째 글자부터 시작해서 6글자 뽑겠다
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

--#4108
SELECT NAME , SUBSTR(JUMIN , 1, 6) 생년월일
FROM T_STUDENT 
--WHERE SUBSTR(JUMIN , 3, 2) = '08';  -- ** 문자열로!  
WHERE JUMIN LIKE '__08%' ; --  앞에 두글자 꼭 와야하고, 08 꼭 와야 하고 뒤에 어떤 글자가 와도 상관없음

SELECT name, SUBSTR(JUMIN , 1, 6) 
FROM T_STUDENT 
WHERE SUBSTR(JUMIN , 3, 2) = '08';   -- jumin 에서 3번째 글자부터 시작해서 2글자 뽑는데, 그게 '08' 일떄만,  뽑겠따.  

-- 조건절에서 A = B  이냐? 할 때   ' 문자열로 감싸기!!'



--#4109
SELECT NAME , JUMIN 
FROM T_STUDENT 
WHERE GRADE = 4 AND SUBSTR(JUMIN , 7, 1) = '2'   -- 성별 구분하는 숫자 

--  04.08---------------------------

-- INSTR() 함수  (인덱스 번호 리턴)
SELECT INSTR('A*b*c*', '*', 1, 1) FROM  DUAL ; -- 2
SELECT INSTR('A*b*c*', '*', 1, 2) FROM  DUAL ; -- 4
SELECT INSTR('A*b*c*', '*', 3, 2) FROM  DUAL ; -- 6
SELECT INSTR('A*b*c*', '*', -4, 1) FROM  DUAL ; -- -5번째인 글자의 인덱스 번호  => 2   음수 인덱스의 경우 검색도 음의 방향으로 진행
SELECT INSTR('A*b*c*', '*', -4, 2) FROM  DUAL ; -- 0  없으면 0 리턴(에러아님) ( 데베는 없으면 0 리턴하게 설계해놨구나 알 수 있음)
SELECT INSTR('A*b*c*', '*', -2, 2) FROM  DUAL ; -- 2  


--#4110   ) 위치를 찾아서 출력할 것
--SELECT NAME , TEL, INSTR(TEL, ')', 1 ,1) AS 위치    -- TEL 에서 ) 이 문자열을 찾을 건데, 첫번쨰 인덱스문자부터 시작해서 첫번째 나오는 ) 찾겠다. 
SELECT NAME , TEL, INSTR(TEL, ')') AS 위치    -- 1, 1 E디폴트 값   
FROM T_STUDENT  WHERE DEPTNO1 = 101;

--#4111
SELECT NAME , TEL, SUBSTR(TEL, 1, INSTR(TEL, ')') - 1) 지역변호 
FROM T_STUDENT WHERE DEPTNO1 = 101;


--LTRIM(), RTRIM(), TRTIM()
SELECT 
	LTRIM('슈퍼슈퍼슈가맨', '슈퍼') LTRIM, 
	LTRIM('슈퍼슈퍼슈가맨', '슈') LTRIM, 
	LTRIM('  슈퍼슈가맨', ' ') LTRIM, 
	LTRIM('  슈퍼슈가맨') LTRIM,  -- 디폴트값으로 '공백' 제거
	RTRIM('우측 공백 제거    ') RTRIM,
	TRIM('     슈퍼맨      ') TRIM,   -- 좌우공백 모두 제거 
	LTRIM('*****10000', '*') LTRIM 
FROM DUAL ;



-- #4117
SELECT * FROM T_DEPT2 ;

SELECT dname, RTRIM(DNAME, '부') RTRIM예제 
FROM T_DEPT2 ;



-- REPLACE 함수  :    의미 : 첫번쨰 매개변수 에서 슈퍼를 찾아서 파워로 바꿔라 .
SELECT REPLACE('슈퍼맨 슈퍼걸', '슈퍼', '파워')
FROM DUAL ;

SELECT REPLACE('아버지가 방에 들어간다', ' ', '')   -- 중간에 있는 공백을 이렇게 제거한
FROM DUAL;

--#4118 
SELECT NAME, REPLACE (NAME , SUBSTR(NAME, 1, 1) , '#') 학생   -- 먼저 SUBSTR 함수 이용해서 NAME 에서 1, 1 해서 성뽑고, 다시 REPLACE() 함수 이용해서  NAME 에서, 성만, # 으로 바꾸겠다.
FROM T_STUDENT WHERE DEPTNO1  = 102;

-- #4119
SELECT NAME, REPLACE(NAME, SUBSTR(NAME, 2, 1) , '#')
FROM T_STUDENT WHERE DEPTNO1=101;

--#4120
SELECT NAME, REPLACE (JUMIN ,SUBSTR(JUMIN , 7, 7), '*******')   -- '*' 이렇게 말고, '*******' 이렇게 해야함.
FROM T_STUDENT WHERE DEPTNO1 =101;

-- #4121
SELECT NAME , TEL, REPLACE (TEL, SUBSTR(TEL, 5, 3), '###') AS 전화번호
FROM T_STUDENT WHERE DEPTNO1  =102;

SELECT NAME , TEL, REPLACE (TEL, SUBSTR(TEL, INSTR(TEL, ')') + 1, 3), '###') AS 전화번호
FROM T_STUDENT WHERE DEPTNO1  =102;










