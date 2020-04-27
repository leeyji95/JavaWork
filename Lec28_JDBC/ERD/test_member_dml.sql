SELECT * FROM TEST_MEMBER;

-- INSERT INTO 테이블 이름 
-- UPDATE 테이블 이름 SET
-- DELETE FROM 테이블 이름

INSERT INTO test_member VALUES(10, '남윤주', SYSDATE);
SELECT *FROM TEST_MEMBER ;


INSERT INTO TEST_MEMBER VALUES(22, '이승환', '1994-02-21');
INSERT INTO TEST_MEMBER VALUES(17, '윤종섭', '2019-08-03');
INSERT INTO TEST_MEMBER values('', '이예지', '');  -- 비어있는 ''를 INSERT 하면 NULL 값 처리     오라클 sql문에서 비어있는 문자는 null 로 인식함
--INSERT INTO TEST_MEMBER values(10, '', SYSDATE);   NOT NULL
INSERT INTO TEST_MEMBER values(nullm, '문상현', '2017-01-01');

--debeaver 에서는 기본적으로 auto-commit 수행 

SELECT *FROM TEST_MEMBER ;

