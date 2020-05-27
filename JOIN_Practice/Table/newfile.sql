
/* Drop Tables */

DROP TABLE TB_USER CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE TB_USER
(
	userID varchar2(50) NOT NULL,
	userPassword varchar2(50) NOT NULL,
	userEmail varchar2(50) NOT NULL,
	userEmailHash varchar2(64) NOT NULL,
	userEmailChecked char,
	PRIMARY KEY (userEmailHash)
);


SELECT * FROM TB_USER;


