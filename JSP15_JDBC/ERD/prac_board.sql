
/* Drop Tables */

DROP TABLE prac_board CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE 
prac_board
(
	pr_uid number NOT NULL,
	pr_subject varchar2(200) NOT NULL,
	pr_content clob,
	pr_name varchar2(40) NOT NULL,
	pr_viewcnt NUMBER DEFAULT 0,
	pr_regdate DATE DEFAULT SYSDATE,
	PRIMARY KEY (pr_uid)
);

CREATE SEQUENCE PRAC_BOARD_SEQ;

SELECT * FROM prac_board;

-- 기본데이터 작성
INSERT INTO PRAC_BOARD VALUES
(PRAC_BOARD_SEQ.nextval, '첫번째 제목', '오늘은 집에 가자', '이예지', 0, '2020-05-21');
INSERT INTO PRAC_BOARD VALUES
(PRAC_BOARD_SEQ.nextval, '두번째 제목','디비디비디비', '임상빈', 0, sysdate);
INSERT INTO PRAC_BOARD VALUES
(PRAC_BOARD_SEQ.nextval, '세번째 제목', '취업하자아아아', '한수빈' , 0, '2020-05-21');
INSERT INTO PRAC_BOARD VALUES
(PRAC_BOARD_SEQ.nextval, '네번째 제목', '우린 할 수 있어요', '장윤성', 0, '2019-07-15');
INSERT INTO PRAC_BOARD VALUES
(PRAC_BOARD_SEQ.nextval, '다섯번째 제목', '알겠죠 ? 우린 모두 할 수 있다구요 예?', '홍성용', 0, sysdate);



