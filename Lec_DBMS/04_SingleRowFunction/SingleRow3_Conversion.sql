-- 묵시적 자동 형변환 예 
SELECT 1 + 1 FROM DUAL ; -- 2
SELECT '1' + 1 FROM dual; -- 2  결과타입 : number (자바랑 반대!)  문자가 숫자로 변환.
  --  내부적으로 
SELECT TO_NUMBER('1') + 1 FROM DUAL;

-- TO_NUMBER() 문자에서 숫자로,  TO_DATE() 문자에서 날짜로,   TO_CHAR() 숫자, 날짜 에서 문자로 변환

-- TO_CHAR 함수(날짜 -> 문자)
SELECT 
	SYSDATE,
	TO_CHAR(SYSDATE, 'YYYY') 연도4자리,  -- 문자타입으로 변환    -- 2020 
	TO_CHAR(SYSDATE, 'RRRR') 연도Y2K버그이후,  -- 2020
	TO_CHAR(SYSDATE, 'YY') 연도2자리,
	TO_CHAR(SYSDATE, 'YEAR') 연도영문  -- TWENTY TWENTY
FROM DUAL;

SELECT 
	TO_CHAR(SYSDATE, 'DD') 일숫자2자리, -- 08
	TO_CHAR(SYSDATE, 'DDTH') 몇번째날, -- 08TH
	TO_CHAR(SYSDATE, 'DAY') 요일,  -- 수요일
	TO_CHAR(SYSDATE, 'DY') 요일앞자리  -- 수
FROM DUAL ;

SELECT 
	TO_CHAR(SYSDATE, 'MM') 월2자리,  -- 07월
	TO_CHAR(SYSDATE, 'MONTH')  월전체,  -- 7월
	TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE=ENGLISH') 월영문3자리,  -- JUL
	TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(대)", -- JULY
	TO_CHAR(SYSDATE, 'month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(소)",  -- july
	TO_CHAR(SYSDATE, 'Month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(첫글자대)" -- July
FROM DUAL ;

SELECT 
	TO_CHAR(SYSDATE, 'HH24') 시24hr,
	TO_CHAR(SYSDATE, 'HH')  시12hr,
	TO_CHAR(SYSDATE, 'MI') 분,
	TO_CHAR(SYSDATE, 'SS') 초,
	TO_CHAR(SYSDATE, 'HH:MI:SS') 
FROM dual;


-- #4301
-- 다음과 같은 형식으로 시간을 출력해보세요
-- ex) 2017-10-25:23:25:46
SELECT 
	SYSDATE, 
	TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') 날짜 
FROM DUAL;


-- 2017년10월25일 23시25분46초  <-- ??
-- 한글 date format 변환시
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일" HH24"시"MI"분"SS"초"') 
FROM DUAL;

-- #4302
-- 실습
-- t_student 테이블의 생일(birthday) 이 3월인 학생의 이름(name) 과 생일(birthday) 를 
-- 다음과 같은 형식으로 출력하세요 (TO_CHAR 사용)
SELECT NAME , TO_CHAR(BIRTHDAY , 'YYYY-MM-DD') 생일 
FROM T_STUDENT WHERE TO_CHAR(BIRTHDAY , 'MM') = '03'; 


-- TO_CHAR : 대소문자 지정예
SELECT
	SYSDATE,
	TO_CHAR(SYSDATE, 'Dy Month DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A1,
	TO_CHAR(SYSDATE, 'dy month dd, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A2,
	TO_CHAR(SYSDATE, 'DY MONTH DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A3
FROM DUAL;

--############################################################
-- TO_CHAR() 함수 - 숫자를 문자로 변환
SELECT 
	1234,
	TO_CHAR(1234,'99999') "9하나당 1자리",
	TO_CHAR(1234, '099999') "빈자리 0으로",
	TO_CHAR(1234, '$9999') "빈자리 $로",
	TO_CHAR(1234.1264, '9999.99') "소숫점이하 2자리", 
	TO_CHAR(123456789,'999999,999') "천단위에 구분기호"
FROM DUAL;	


-- #4303
-- t_professor 테이블에서 101번 학과 교수들의 이름(name), 연봉(pay) 를 출력하세요,
-- 단, 연봉은 (pay * 12) + bonus로 계산하고 천단위 구분기호로 표시하세요.
-- nvl / to_char() 사용
SELECT 
	NAME ,NVL(BONUS , TO_CHAR(PAY * 12 + BONUS, '99999,999') , TO_CHAR(PAY * 12, '99999,999')), 
FROM T_PROFESSOR WHERE DEPTNO = 101;


SELECT name, TO_CHAR( (pay*12) + nvl(bonus, 0), '99,999') 연봉
FROM t_professor
WHERE deptno=101;


--##############################################################3
-- TO_NUMBER() 함수 - 숫자로 변환



--##############################################################3
-- TO_DATE() 함수 - 문자 -> 날짜로 변환
SELECT 
	TO_DATE('2020-02-29', 'YYYY-MM-DD') TO_DATE 
FROM DUAL;


--SELECT 
--	NAME ,
--	TO_DATE(HIREDATE ,'YYYY-HH-DD') TO_DATE 
--FROM T_PROFESSOR WHERE TO_DATE('2000', 'YYYY') > HIREDATE ; 

SELECT 
	NAME , 
	TO_CHAR(HIREDATE , 'YYYY-MM-DD') 입사일,
	TO_CHAR(PAY * 12, '99,999') 연봉,
	TO_CHAR(PAY * 12 * 1.1, '99,999') 인상후 
FROM T_PROFESSOR WHERE TO_CHAR(HIREDATE , 'YYYY') < '2000'; 



