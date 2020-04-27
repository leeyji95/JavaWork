CREATE TABLE test_emp_a(
	emp_id NUMBER,
	emp_name VARCHAR2(100)
);

CREATE TABLE test_emp_b (
	emp_id NUMBER,
	emp_name VARCHAR2(100)
);

DELETE FROM test_emp_a;
DELETE FROM test_emp_b;

-- 시험.>!!

INSERT INTO TEST_EMP_A VALUES(101, '장윤성');
INSERT INTO TEST_EMP_B VALUES(102, '고유성');

SELECT *FROM TEST_EMP_A ;
SELECT *FROM TEST_EMP_B ;

-- 동시에 여러개 테이블에 INSERT 하기
-- 다중 테이블 INSERT 구문에 SUB QUERY 필요 
INSERT ALL
	INTO TEST_EMP_A VALUES(102, '조현주')
	INTO TEST_EMP_B VALUES(202, '최현주')
SELECT * FROM DUAL;  -- 이것까지 꼭 작성해야 실행됨!



--SUB QUERY 로 INSERT 가능
INSERT INTO TEST_EMP_A (SELECT 400, '안성원' FROM DUAL);  -- values() 값에 -> 서브쿼리 결과가 INSERT 된다. 
INSERT INTO TEST_EMP_B (SELECT 500, '김성원' FROM DUAL);
	

SELECT *FROM TEST_EMP_A ;
SELECT *FROM TEST_EMP_B ;
	
-- 테이블 묻고 더블로!
INSERT INTO TEST_EMP_A  (SELECT * FROM TEST_EMP_A );
SELECT *FROM TEST_EMP_A ;

INSERT INTO TEST_EMP_B(EMP_NAME) (SELECT EMP_NAME FROM TEST_EMP_B );
SELECT *FROM TEST_EMP_B ;






