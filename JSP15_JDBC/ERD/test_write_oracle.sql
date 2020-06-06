
/* Drop Tables */

DROP TABLE test_write CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_write
(
	wr_uid number NOT NULL,
	wr_subject varchar2(200) NOT NULL,
	wr_content clob,
	wr_name varchar2(40) NOT NULL,
	wr_viewcnt number DEFAULT 0,
	wr_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (wr_uid)
);

-- 시퀀스
CREATE SEQUENCE TEST_WRITE_SEQ;

SELECT * FROM test_write;

-- 기본데이터 작성
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '뼈해장국에 대하여', '난 뼈해장국...', '이예지', 0, '2017-03-02');
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '순대국이나해장국이나','아무거나 난 좋아', '한수빈', 0, '2017-03-02');
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '난 먹는거라면 다 좋지 ㅎㅎ', '나도 그냥 따라갈게', '홍성용' , 0, '2017-08-12');
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '난 순대국 아니면 안먹어 ', '오늘은 순대국', '임상빈', 0, '2018-02-09');
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '암흑기의 시대는지났다.', '우리는 할 수 있다', '맥심조', 0, sysdate);



-- 다량의 데이터 필요 
SELECT * FROM TEST_WRITE ORDER BY wr_uid DESC;
INSERT INTO TEST_WRITE(WR_UID, WR_SUBJECT , WR_CONTENT , WR_NAME )
	SELECT test_write_seq.nextval, WR_SUBJECT , WR_CONTENT , WR_NAME FROM TEST_WRITE ;







