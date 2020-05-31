
/* Drop Tables */

DROP TABLE user_join CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE user_join
(
	user_uid number NOT NULL,
	user_id varchar2(50) NOT NULL UNIQUE,
	user_password varchar2(50) NOT NULL,
	user_email varchar2(50) NOT NULL UNIQUE,
	user_emailhash varchar2(70) NOT NULL UNIQUE,
	user_emailchecked varchar2(1) NOT NULL,
	PRIMARY KEY (user_uid)
);

CREATE SEQUENCE user_seq;

DROP SEQUENCE user_seq;

SELECT * FROM USER_JOIN;

INSERT INTO USER_JOIN VALUES(USER_SEQ.NEXTVAL, 'MAXIIM', '12345678', 'LEEYJI95@NAVER.COM', '#SJKDKF123456', '1');

