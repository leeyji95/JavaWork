-- 제약조건(Constraint)
-- 테이블 생성시 동시에 설정하기

-- t_dept2.dcode 참조예정
SELECT * FROM T_DEPT2 ;  -- DCODE: 0001, 1000 ...1011

-- #9001
-- 제약조건명을 명시하지 않는 방법
--  PPT 9 에 8PAGE 시험 비슷하게..


DROP TABLE T_EMP3 CASCADE CONSTRAINT;  -- 그냥은 삭제 되지 않고, 테이블 지울 때 제약조건까지 삭제. 
CREATE TABLE t_emp3(
	NO NUMBER(4) PRIMARY KEY, 
	NAME VARCHAR2(10) NOT NULL,
	JUMIN VARCHAR2(13) NOT NULL UNIQUE,
	AREA NUMBER(1) CHECK(AREA < 5),
	DEPTNO VARCHAR2(6) REFERENCES T_DEPT2(DCODE)
);

-- 별도의 항목으로 제약조건 정의 가능
CREATE TABLE T_EMP4(
	NO NUMBER(4) , 
	NAME VARCHAR2(10) NOT NULL,  -- NOT NULL 은 별도로 정의 안됨. 
	JUMIN VARCHAR2(13) NOT NULL ,
	AREA NUMBER(1) ,
	DEPTNO VARCHAR2(6),
	PRIMARY KEY(NO),  -- NO 에다가 PRIMARY KEY 설정 해줘라.
	UNIQUE(JUMIN),
	CHECK(AREA < 5),
	FOREIGN KEY(DEPTNO) REFERENCES T_DEPT2(DCODE)
);


--  제약조건을 관리해야하는 경우가 생긴다...
-- 그러므로 제약조건에다가 이름을 붙여서 정의해보자.

-- #9002
-- 제약조건명을  명시하여 정의
-- 테이블 이름_컬럼이름_제약조건이름   이렇게 작명한다 . 대부분  
DROP TABLE T_EMP3 CASCADE CONSTRAINT;  -- 실행하고 다시 생성하기
CREATE TABLE t_emp3(
	NO NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY, 
	NAME VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
	JUMIN VARCHAR2(13) 
		CONSTRAINT emp3_jumin_nn NOT NULL
		CONSTRAINT emp3_jumin_uk UNIQUE,
	AREA NUMBER(1) CONSTRAINT emp3_area_ck CHECK(AREA < 5),
	DEPTNO VARCHAR2(6) CONSTRAINT emp3_deptno_fk REFERENCES T_DEPT2(DCODE)
);
-- 제약조건 가지고 이름을 관리할 수 있음. 


-- 제약조건 따로 정의하는 방법
DROP TABLE T_EMP3 CASCADE CONSTRAINT;  -- 실행하고 만들어주세용 
CREATE TABLE t_emp3(
	NO NUMBER(4) , 
	NAME VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
	JUMIN VARCHAR2(13) CONSTRAINT emp3_jumin_nn NOT NULL,
	AREA NUMBER(1) ,
	DEPTNO VARCHAR2(6),
	CONSTRAINT emp3_no_pk PRIMARY KEY(NO),
	CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
	CONSTRAINT emp3_area_ck CHECK(AREA < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno) REFERENCES T_DEPT2(DCODE)
);

-- #9003 제약조건 조회하기 (오라클이 알아서 붙여주는 이름.. 관리하기 힘듦)
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'T_EMP4'; -- 테이블명 대문자로!

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'T_EMP3';


-- # 9005 : 제약조건에 위배되는 DML 시도해보기
INSERT INTO T_EMP3 VALUES(1, '오라클', '1234561234567', 4, 1000);
-- 두번 실행하면 오류! ORA-00001 : unique constraint (SCOTT0316.EMP3_NO_PK) violated

INSERT INTO T_EMP3 VALUES(2, '오라클', '1234561234567', 4, 1000);
-- JUMIN UNIQUE 오류! ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated

INSERT INTO T_EMP3 VALUES(2, '오라클', '22222222222222', 4, 1000);
-- VARCHAR2(13) 초과 오류! ORA-12899: value too large for column "SCOTT0316"."T_EMP3"."JUMIN" (actual: 14, maximum: 13)

INSERT INTO T_EMP3 VALUES(2, '오라클', '2222222222222', 10, 1000);
-- CHECK 오류 !  ORA-01438: value larger than specified precision allowed for this column

INSERT INTO T_EMP3 VALUES(2, '오라클', '2222222222222', 3, 2000);
-- FK 오류! : ORA-02291: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - parent key not found

INSERT INTO T_EMP3(NO, JUMIN, AREA, DEPTNO) VALUES(2, '2222222222222', 4, 1001);
-- NN 오류! : ORA-01400: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")

-- INSERT뿐 아니라 UPDATE/DELETE 에서도 오류 발생 가능 
UPDATE T_EMP3 SET AREA = 10 WHERE NO = 1;  -- AREA 값 5보다 작아야 하는데, 10으로 바꾸려 하면 에러뜨지 당연.
-- CHECK 값 오류

SELECT * FROM T_EMP3;
DELETE FROM T_DEPT2  WHERE DCODE = 1000; -- 참조하고 있는 부모는 삭제 불가 
-- ORA-02292: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - child record found


-- #9005) 테이블 생성 후에 ALTER 명령 사용하여 제약 조건 추가 가능!
-- T_EMP4 의 NAME 컬럼에 UNIQUE 제약조건 추가
--ALTER ~ ADD
--ALTER ~ MODIFY
--ALTER ~ DROP

ALTER TABLE T_EMP4 ADD CONSTRAINT EMP4_NAME_UK UNIQUE(NAME);


-- #9006
-- T_EMP4 테이블 AREA 컬럼에 NOT NULL 제약조건 추가해보세요
ALTER TABLE T_EMP4 ADD CONSTRAINT EMP4_AREA_NN NOT NULL(AREA);
-- 기본적으로 컬럼은 NULL을 허용함. 이미 지정이 되어 있기 떄문에  ADD가 안된다. 
-- NODIFY 로 가야 한다. 
-- 쌤: 이미 컬럼의 기본값이 NULL 하용으로 되어 있기 때문에 ADD 가 아닌 MODIFY 로 해야 한다.
ALTER TABLE T_EMP4 MODIFY (AREA CONSTRAINT EMP4_AREA_NN NOT NULL);


-- #9007 ) 외래키 추가
ALTER TABLE T_EMP4 ADD CONSTRAINT EMP4_NAME_FK FOREIGN KEY(NAME) REFERENCES T_EMP2(NAME);
-- 그냥 실행하면 에러다 :  ORA-02270: no matching unique or primary key for this column-list
-- 참조된 부모 데이블의 컬럼은 PRIMARY KEY  이거나 UNIQUE 해야한다. !! !

-- 일단 부모테이블의 NAME 을 UNIQUE 로 바꾼뒤 위의 쿼리를 다시 실행해보세요 
ALTER TABLE T_EMP2 ADD CONSTRAINT EMP2_NAME_UK UNIQUE(NAME);


-- #9008
DROP TABLE T_EMP3 CASCADE CONSTRAINT;  -- 실행하고 만들어주세용 
CREATE TABLE t_emp3(
	NO NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY, 
	NAME VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
	JUMIN VARCHAR2(13) 
		CONSTRAINT emp3_jumin_nn NOT NULL
		CONSTRAINT emp3_jumin_uk UNIQUE,
	AREA NUMBER(1) CONSTRAINT emp3_area_ck CHECK(AREA < 5),
	DEPTNO VARCHAR2(6) CONSTRAINT emp3_deptno_fk REFERENCES T_DEPT2(DCODE)
	ON DELETE CASCADE -- 부모삭제 되면 자식도 같이 삭제된다. 
	-- ON DELETE SET NULL  -- 부모 삭제되면 NULL 값으로 
	-- ON UPDATE -> ORACLE 은 지원안합니다
);

-- #9009
-- T_EMP4 테이블의 NAME 필드 제약조건 예
-- 부모테이블이 삭제되면 NULL 이 되도록 설정하기 (ALTER 사용)

ALTER TABLE T_EMP4 DROP CONSTRAINT EMP4_NAME_FK;  -- 일단 기존 제약조건 삭제 

ALTER TABLE T_EMP4
ADD CONSTRAINT EMP4_NAME_FK FOREIGN KEY(NAME)
	REFERENCES T_EMP2(NAME)
	ON DELETE SET NULL -- 부모가 삭제되면 자식은 NULL 로 남아있겠다. 의미
;   


--  지금까지 우리 모한거다?   테이블 생성 후에도 컬럼들에 걸려 있는 제약조건들을 생성, 수정 , 삭제 할 수 있다는 거 배운거임. 


--------------------------------------------------------------
-- 제약조건, TEST 위해 잠시 꺼둘 수 있다. ENABLED 된거 아까 봤쥬? 
-- DISABLE

-- #9010
SELECT * FROM T_NOVALIDATE;
SELECT * FROM T_VALIDATE;

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_VALIDATE';  

INSERT INTO T_VALIDATE VALUES(1, 'DDD');  -- PK 중복 되니까// 처음에는 에러! PK니까!



SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_NOVALIDATE';  

INSERT INTO T_NOVALIDATE VALUES(1, 'DDD');  -- PK 중복 되니까// 처음에는 에러! PK니까!

ALTER TABLE T_NOVALIDATE 
DISABLE NOVALIDATE CONSTRAINT SYS_C007066;  -- 여기서 PK   DISABLED 해주면 윗줄 실행 됨(INSERT 됨)

SELECT * FROM T_NOVALIDATE;

-- 이 상태에서  PK 다시  켤수 있을까?    NOP!
ALTER TABLE T_NOVALIDATE 
ENABLE NOVALIDATE CONSTRAINTS SYS_C007066; -- 처음엔 PK 활성화 시키면 에러! 

DELETE FROM T_NOVALIDATE WHERE  NAME = 'DDD'; -- 삭제 하고 -> PK 다시 활성화 시키면 ? 작동됨!
