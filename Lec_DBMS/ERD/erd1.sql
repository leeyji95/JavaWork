
/* Drop Tables */

DROP TABLE register CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE subject CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE professor
(
	profno number NOT NULL,
	name varchar2(10) NOT NULL,
	deptno number,
	PRIMARY KEY (profno)
);


CREATE TABLE register
(
	studno number NOT NULL,
	subjno number NOT NULL
);


CREATE TABLE student
(
	studno number NOT NULL,
	name varchar2(10) NOT NULL,
	deptno number,
	profno number NOT NULL,
	PRIMARY KEY (studno)
);


CREATE TABLE subject
(
	subjno number NOT NULL,
	name varchar2(10) NOT NULL,
	profno number NOT NULL,
	PRIMARY KEY (subjno)
);



/* Create Foreign Keys */

ALTER TABLE student
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE subject
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE register
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
;


ALTER TABLE register
	ADD FOREIGN KEY (subjno)
	REFERENCES subject (subjno)
;



/*-----------------------------------------------*/




-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- tb_user Table Create SQL
CREATE TABLE tb_user
(
    user_uid        NUMBER          NOT NULL, 
    user_email      VARCHAR2(30)    NOT NULL, 
    user_pw         VARCHAR2(60)    NOT NULL, 
    user_name       VARCHAR2(30)    NOT NULL, 
    user_regdate    DATE            DEFAULT SYSDATE NOT NULL, 
    user_phone      VARCHAR2(20)    NOT NULL, 
    user_isvalid    CHAR(1)         DEFAULT ''F'' NOT NULL, 
    user_auth       CHAR(1)         DEFAULT ''G'' NOT NULL, 
    user_sns        VARCHAR2(20)    NULL, 
    user_snsid      VARCHAR2(20)    NULL, 
    user_email2     VARCHAR2(30)    NULL, 
    CONSTRAINT TB_USER_PK PRIMARY KEY (user_uid)
)
/

CREATE SEQUENCE tb_user_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_user_AI_TRG
BEFORE INSERT ON tb_user 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_user_SEQ.NEXTVAL
    INTO :NEW.user_uid
    FROM DUAL;
END;
/

--DROP TRIGGER tb_user_AI_TRG;
/

--DROP SEQUENCE tb_user_SEQ;
/

COMMENT ON TABLE tb_user IS '회원의 정보를 모아놓은 테이블'
/

COMMENT ON COLUMN tb_user.user_uid IS '회원uid'
/

COMMENT ON COLUMN tb_user.user_email IS '회원은 ID가 아닌 email을 통해 로그인'
/

COMMENT ON COLUMN tb_user.user_pw IS '평문이 아닌 암호화 후 저장'
/

COMMENT ON COLUMN tb_user.user_name IS '중복불가'
/

COMMENT ON COLUMN tb_user.user_regdate IS '회원가입일'
/

COMMENT ON COLUMN tb_user.user_phone IS '접속email 잊어버렸을 시 전화번호로 확인 가능'
/

COMMENT ON COLUMN tb_user.user_isvalid IS '회원 가입 후 인증 메일을 통해 인증해야 유효회원이 된다'
/

COMMENT ON COLUMN tb_user.user_auth IS '운영자, 일반회원 구분 필요'
/

COMMENT ON COLUMN tb_user.user_sns IS 'sns로 가입한 회원의 sns서비스명(구글, 페이스북, 카카오 등)'
/

COMMENT ON COLUMN tb_user.user_snsid IS 'sns와 연동된 id나 email'
/

COMMENT ON COLUMN tb_user.user_email2 IS '접속email이나 비밀번호를 잊어벼렸을 시 보조 email을 활용 가능'
/


-- tb_user Table Create SQL
CREATE TABLE tb_post
(
    post_uid         NUMBER          NOT NULL, 
    post_category    VARCHAR2(30)    NOT NULL, 
    post_subject     VARCHAR2(60)    NOT NULL, 
    post_content     CLOB            NOT NULL, 
    post_regdate     DATE            DEFAULT SYSDATE NOT NULL, 
    post_viewcnt     NUMBER          DEFAULT 0 NOT NULL, 
    post_star        NUMBER          DEFAULT 0 NOT NULL, 
    user_uid         NUMBER          NOT NULL, 
    CONSTRAINT TB_POST_PK PRIMARY KEY (post_uid)
)
/

CREATE SEQUENCE tb_post_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_post_AI_TRG
BEFORE INSERT ON tb_post 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_post_SEQ.NEXTVAL
    INTO :NEW.post_uid
    FROM DUAL;
END;
/

--DROP TRIGGER tb_post_AI_TRG;
/

--DROP SEQUENCE tb_post_SEQ;
/

COMMENT ON TABLE tb_post IS '회원이 작성한 게시글'
/

COMMENT ON COLUMN tb_post.post_uid IS '게시물uid'
/

COMMENT ON COLUMN tb_post.post_category IS '강좌, 질문, 커뮤니티, JAVA, IT 등 다양한 카테고리명'
/

COMMENT ON COLUMN tb_post.post_subject IS '게시물제목'
/

COMMENT ON COLUMN tb_post.post_content IS '게시물내용'
/

COMMENT ON COLUMN tb_post.post_regdate IS '게시물등록일'
/

COMMENT ON COLUMN tb_post.post_viewcnt IS '게시물조회수'
/

COMMENT ON COLUMN tb_post.post_star IS '좋은 글이라 생각되면 회원들이 추천 가능, 추천은 1인 1일 3회 한정'
/

COMMENT ON COLUMN tb_post.user_uid IS '회원uid'
/

ALTER TABLE tb_post
    ADD CONSTRAINT FK_tb_post_user_uid_tb_user_us FOREIGN KEY (user_uid)
        REFERENCES tb_user (user_uid)
/


-- tb_user Table Create SQL
CREATE TABLE tb_scrap
(
    scrap_uid    NUMBER    NOT NULL, 
    user_uid     NUMBER    NOT NULL, 
    post_uid     NUMBER    NOT NULL, 
    CONSTRAINT TB_SCRAP_PK PRIMARY KEY (scrap_uid)
)
/

CREATE SEQUENCE tb_scrap_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_scrap_AI_TRG
BEFORE INSERT ON tb_scrap 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_scrap_SEQ.NEXTVAL
    INTO :NEW.scrap_uid
    FROM DUAL;
END;
/

--DROP TRIGGER tb_scrap_AI_TRG;
/

--DROP SEQUENCE tb_scrap_SEQ;
/

COMMENT ON TABLE tb_scrap IS '회원이 마음에 들어 게시물을 스크랩'
/

COMMENT ON COLUMN tb_scrap.scrap_uid IS '스크랩uid'
/

COMMENT ON COLUMN tb_scrap.user_uid IS '회원uid'
/

COMMENT ON COLUMN tb_scrap.post_uid IS '게시물uid'
/

ALTER TABLE tb_scrap
    ADD CONSTRAINT FK_tb_scrap_user_uid_tb_user_u FOREIGN KEY (user_uid)
        REFERENCES tb_user (user_uid)
/

ALTER TABLE tb_scrap
    ADD CONSTRAINT FK_tb_scrap_post_uid_tb_post_p FOREIGN KEY (post_uid)
        REFERENCES tb_post (post_uid)
/


-- tb_user Table Create SQL
CREATE TABLE tb_comment
(
    comment_uid        NUMBER    NOT NULL, 
    comment_content    CLOB      NOT NULL, 
    comment_regdate    DATE      DEFAULT SYSDATE NOT NULL, 
    post_uid           NUMBER    NOT NULL, 
    user_uid           NUMBER    NOT NULL, 
    CONSTRAINT TB_COMMENT_PK PRIMARY KEY (comment_uid)
)
/

CREATE SEQUENCE tb_comment_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_comment_AI_TRG
BEFORE INSERT ON tb_comment 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_comment_SEQ.NEXTVAL
    INTO :NEW.comment_uid
    FROM DUAL;
END;
/

--DROP TRIGGER tb_comment_AI_TRG;
/

--DROP SEQUENCE tb_comment_SEQ;
/

COMMENT ON TABLE tb_comment IS '게시물의 댓글'
/

COMMENT ON COLUMN tb_comment.comment_uid IS '댓글uid'
/

COMMENT ON COLUMN tb_comment.comment_content IS '긴 댓글이나 사진삽입도 가능하게 하기 위해 CLOB으로 설정'
/

COMMENT ON COLUMN tb_comment.comment_regdate IS '댓글등록일'
/

COMMENT ON COLUMN tb_comment.post_uid IS '게시물uid'
/

COMMENT ON COLUMN tb_comment.user_uid IS '회원uid'
/

ALTER TABLE tb_comment
    ADD CONSTRAINT FK_tb_comment_user_uid_tb_user FOREIGN KEY (user_uid)
        REFERENCES tb_user (user_uid)
/

ALTER TABLE tb_comment
    ADD CONSTRAINT FK_tb_comment_post_uid_tb_post FOREIGN KEY (post_uid)
        REFERENCES tb_post (post_uid)
/


-- tb_user Table Create SQL
CREATE TABLE tb_mypage
(
    mypage_uid        NUMBER          NOT NULL, 
    mypage_subject    VARCHAR2(60)    NOT NULL, 
    mypage_content    CLOB            NOT NULL, 
    user_uid          NUMBER          NOT NULL, 
    CONSTRAINT TB_MYPAGE_PK PRIMARY KEY (mypage_uid)
)
/

CREATE SEQUENCE tb_mypage_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_mypage_AI_TRG
BEFORE INSERT ON tb_mypage 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_mypage_SEQ.NEXTVAL
    INTO :NEW.mypage_uid
    FROM DUAL;
END;
/

--DROP TRIGGER tb_mypage_AI_TRG;
/

--DROP SEQUENCE tb_mypage_SEQ;
/

COMMENT ON TABLE tb_mypage IS '회원이 꾸밀 수 있는 본인만의 페이지'
/

COMMENT ON COLUMN tb_mypage.mypage_uid IS '마이페이지uid'
/

COMMENT ON COLUMN tb_mypage.mypage_subject IS '마이페이지제목'
/

COMMENT ON COLUMN tb_mypage.mypage_content IS '마이페이지내용'
/

COMMENT ON COLUMN tb_mypage.user_uid IS '회원uid'
/

ALTER TABLE tb_mypage
    ADD CONSTRAINT FK_tb_mypage_user_uid_tb_user_ FOREIGN KEY (user_uid)
        REFERENCES tb_user (user_uid)
/


-- tb_user Table Create SQL
CREATE TABLE tb_attach
(
    attach_uid        NUMBER           NOT NULL, 
    attach_type       VARCHAR2(10)     NOT NULL, 
    attach_url        VARCHAR2(100)    NOT NULL, 
    attach_regdate    DATE             DEFAULT SYSDATE NOT NULL, 
    attach_size       NUMBER           NOT NULL, 
    post_uid          NUMBER           NOT NULL, 
    CONSTRAINT TB_ATTACH_PK PRIMARY KEY (attach_uid)
)
/

CREATE SEQUENCE tb_attach_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_attach_AI_TRG
BEFORE INSERT ON tb_attach 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_attach_SEQ.NEXTVAL
    INTO :NEW.attach_uid
    FROM DUAL;
END;
/

--DROP TRIGGER tb_attach_AI_TRG;
/

--DROP SEQUENCE tb_attach_SEQ;
/

COMMENT ON TABLE tb_attach IS '게시물의 첨부파일'
/

COMMENT ON COLUMN tb_attach.attach_uid IS '첨부파일uid'
/

COMMENT ON COLUMN tb_attach.attach_type IS '첨부파일의 종류 혹은 확장자(미디어, 동영상, jpg, txt 등)'
/

COMMENT ON COLUMN tb_attach.attach_url IS '첨부파일이 위치한 서버상 주소'
/

COMMENT ON COLUMN tb_attach.attach_regdate IS '첨부파일등록일'
/

COMMENT ON COLUMN tb_attach.attach_size IS '첨부파일사이즈'
/

COMMENT ON COLUMN tb_attach.post_uid IS '게시물uid'
/

ALTER TABLE tb_attach
    ADD CONSTRAINT FK_tb_attach_post_uid_tb_post_ FOREIGN KEY (post_uid)
        REFERENCES tb_post (post_uid)
/


-- tb_user Table Create SQL
CREATE TABLE tb_rank
(
    rank_uid      NUMBER          NOT NULL, 
    user_uid      NUMBER          NOT NULL, 
    rank_point    NUMBER          DEFAULT 10 NOT NULL, 
    rank_grade    VARCHAR2(30)    DEFAULT ''bronze'' NOT NULL, 
    CONSTRAINT TB_RANK_PK PRIMARY KEY (rank_uid)
)
/

CREATE SEQUENCE tb_rank_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_rank_AI_TRG
BEFORE INSERT ON tb_rank 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_rank_SEQ.NEXTVAL
    INTO :NEW.rank_uid
    FROM DUAL;
END;
/

--DROP TRIGGER tb_rank_AI_TRG;
/

--DROP SEQUENCE tb_rank_SEQ;
/

COMMENT ON TABLE tb_rank IS '사이트 이용을 통해 얻은 포인트로 랭크 설정'
/

COMMENT ON COLUMN tb_rank.rank_uid IS '랭킹uid'
/

COMMENT ON COLUMN tb_rank.user_uid IS '회원uid'
/

COMMENT ON COLUMN tb_rank.rank_point IS '사이트 이용에 유용한 포인트로 회원가입 시 기본 지급되고, 커뮤니티 활동을 하면서 획득할 수 있다'
/

COMMENT ON COLUMN tb_rank.rank_grade IS '보유포인트에 맞춰 등급이 조정된다'
/

ALTER TABLE tb_rank
    ADD CONSTRAINT FK_tb_rank_user_uid_tb_user_us FOREIGN KEY (user_uid)
        REFERENCES tb_user (user_uid)
/


-- tb_user Table Create SQL
CREATE TABLE tb_site
(
    site_uid        NUMBER           NOT NULL, 
    site_url        VARCHAR2(100)    NOT NULL, 
    site_subject    VARCHAR2(60)     NOT NULL, 
    site_desc       CLOB             NULL, 
    CONSTRAINT TB_SITE_PK PRIMARY KEY (site_uid)
)
/

CREATE SEQUENCE tb_site_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tb_site_AI_TRG
BEFORE INSERT ON tb_site 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT tb_site_SEQ.NEXTVAL
    INTO :NEW.site_uid
    FROM DUAL;
END;
/

--DROP TRIGGER tb_site_AI_TRG;
/

--DROP SEQUENCE tb_site_SEQ;
/

COMMENT ON TABLE tb_site IS '개발자에게 유용한 웹사이트'
/

COMMENT ON COLUMN tb_site.site_uid IS '웹사이트uid'
/

COMMENT ON COLUMN tb_site.site_url IS '웹사이트url'
/

COMMENT ON COLUMN tb_site.site_subject IS '웹사이트제목'
/

COMMENT ON COLUMN tb_site.site_desc IS '웹사이트설명'
/





























































