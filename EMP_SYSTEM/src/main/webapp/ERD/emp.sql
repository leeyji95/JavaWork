
/* Drop Tables */

DROP TABLE tb_emp CASCADE CONSTRAINTS;


/* Create Tables */

CREATE TABLE tb_emp
(
	emp_uid number NOT NULL,
	emp_num number(3) NOT NULL UNIQUE,
	emp_dept varchar2(10) NOT NULL,
	emp_name varchar2(20) NOT NULL,
	emp_tel varchar2(20)  UNIQUE,
	emp_email varchar2(50) UNIQUE,
	PRIMARY KEY (emp_uid)
);

CREATE SEQUENCE emp_seq;
DROP SEQUENCE  emp_seq;	

INSERT INTO TB_EMP VALUES (emp_seq.nextval, 5, '사원', '이예지', '010-4107-5672', 'leeyji95@naver.com');
INSERT INTO TB_EMP VALUES (emp_seq.nextval, 52,  '주임', '이효리', '010-5634-5688', 'adsf34@naver.com');
INSERT INTO TB_EMP VALUES (emp_seq.nextval, 3,  '대리','유재석', '010-2355-6453', 'lhh6@naver.com');
INSERT INTO TB_EMP VALUES (emp_seq.nextval, 521, '과장','강다니엘', '010-5463-9887',  'sdfse543@naver.com');

SELECT 
LPAD(EMP_NUM , 3, '0') 직원번호 , EMP_DEPT 직급, EMP_NAME 이름, EMP_TEL 전화번호, EMP_EMAIL 이메일 
FROM TB_EMP 
ORDER BY EMP_NAME ;
