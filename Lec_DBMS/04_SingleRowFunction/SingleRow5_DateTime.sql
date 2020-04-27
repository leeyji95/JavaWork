-- 날짜 함수
SELECT SYSDATE FROM DUAL;

-- 기본적인 날짜 연산
SELECT 
	SYSDATE "오늘",
	SYSDATE + 1 "내일(24시간 뒤)", -- +1 의 의미: 24시간 뒤 의미 	
	SYSDATE - 1 "그저께",
	SYSDATE + 1/24 "한시간뒤"
FROM DUAL;

-- 일자 차이 계산
SELECT 
	SYSDATE "오늘",
	TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD HH:MI:SS') "시작한 날", 
	SYSDATE - TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD HH:MI:SS') "경과"
FROM DUAL;

-- MONTHS_BETWEEN : 날짜 사이의 개월수
SELECT 
	-- 규칙1: 두 날짜 중 큰 날짜를 먼저 써야 양수값으로 나옴 
	MONTHS_BETWEEN('2012-03-01', '2012-01-01') "양수값",  -- 여기서 나오는 
	MONTHS_BETWEEN('2012-01-01', '2012-03-01') "음수값",
	-- 규칙2: 두 날짜가 같은 달에 속해 있으면 특정 규칙으로 계산된 값
	MONTHS_BETWEEN('2012-02-29', '2012-02-28') "2/29-2/01",  -- 29일 중 28 일  28/29 의 결과.. 나올거구
	MONTHS_BETWEEN('2012-04-30', '2012-04-01') "4/30-4/01",  -- 29일 중 28 일  28/29 의 결과.. 나올거구
	MONTHS_BETWEEN('2012-05-31', '2012-05-01') "5/31-5/01"  -- 29일 중 28 일  28/29 의 결과.. 나올거구
FROM DUAL;


-- #4501
SELECT 
	NAME 이름,
	TO_CHAR(SYSDATE, 'YYYY-MM-DD') 오늘,
	TO_CHAR(HIREDATE , 'YYYY-MM-DD') 입사일,
	TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIREDATE, 'YYYY') 근속연수,
	ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE), 1) 근속개월,
	ROUND(SYSDATE - HIREDATE , 1) 근속일수 
FROM T_PROFESSOR ;



-- ADD_MONTH() 개월 추가
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 3) FROM DUAL;   -- 3개월 뒤

SELECT 
	SYSDATE,
	LAST_DAY(SYSDATE) "이번달 마지막날",
	NEXT_DAY(SYSDATE, '화') "다음 월요일"   -- 돌아오는 요일. 지났으면 다음주, 안지났으면 이번주에 있는 요일 
FROM DUAL;


-- 날짜의 ROUND() 함수  ,  하루의 반은 정오 12:00:00 이다. 이를 넘어서면 다음 날짜
-- 날짜의 TRUNC() 함수,  무조건 당일 출력.
-- 원서 접수나 상품 주문 등에서 오전까지 접수된 건은 당일 접수 처리. 오후접수는 익일 처리 등에서 사용.
SELECT 
	SYSDATE,
	ROUND(SYSDATE),
	TRUNC(SYSDATE)
FROM DUAL;

















