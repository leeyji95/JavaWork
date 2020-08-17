
/* Drop Tables */

DROP TABLE tb_user CASCADE CONSTRAINTS;
DROP SEQUENCE user_seq;


/* Create Tables */
CREATE SEQUENCE user_seq;

-- 회원가입 시 사용자 테이블
CREATE TABLE tb_user
(
	user_uid number NOT NULL PRIMARY KEY,
	user_id varchar2(20) NOT NULL UNIQUE,
	user_pw varchar2(200) NOT NULL,
	user_email varchar2(50) NOT NULL UNIQUE,
	user_key varchar2(100)
);
SELECT * FROM tb_user;





DROP SEQUENCE email_seq;
DROP TABLE tb_email CASCADE CONSTRAINTS;
-- 이메일 테이블
CREATE TABLE tb_email(
	email_uid NUMBER NOT NULL PRIMARY KEY,
	email varchar2(50) NOT NULL,
	user_key varchar2(100)
);
CREATE SEQUENCE email_seq;
SELECT * FROM TB_EMAIL;
DELETE FROM TB_EMAIL;



