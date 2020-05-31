
/* Drop Tables */

DROP TABLE TB_USER CASCADE CONSTRAINTS;


/* Create Tables */

CREATE TABLE TB_USER(
	userID varchar2(50) NOT NULL,
	userPassword varchar2(50) NOT NULL,
	userEmail varchar2(50) NOT NULL,
	userEmailHash varchar2(64),
	userEmailChecked NUMBER(1),
	PRIMARY KEY (userEmailHash)
);

ALTER TABLE TB_USER ADD CONSTRAINT USER_EMAILCHECKED CHECK(userEmailChecked IN(0, 1));


SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'TB_USER'; 


SELECT * FROM TB_USER;