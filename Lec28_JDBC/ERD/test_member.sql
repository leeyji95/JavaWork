
/* Drop Tables */

DROP TABLE test_member CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_member
(
	mb_no number,
	mb_name varchar2(40) NOT NULL,
	mb_birthdate date
);

-- 시퀀스
DROP SEQUENCE test_member_seq; -- 혹시 그 전에 시퀀스가 있다면 지우고 시작.
CREATE SEQUENCE test_member_seq;

DELETE FROM TEST_MEMBER ;

SELECT * FROM TEST_MEMBER ORDER BY MB_NO DESC ;


