--#2
INSERT INTO T_STUDENT (STUDNO , NAME , ID , DEPTNO1 , GRADE , PROFNO ) 
	VALUES(9091, '김수진', 'sooplus', 101, 2, 1004);

--#3
DELETE FROM T_STUDENT WHERE GRADE = 4 ;

-- #4
SELECT NAME "이름", PAY "급여" FROM T_PROFESSOR WHERE PAY >= 5000 ;

--#5
CREATE UNIQUE INDEX idx_student_name ON T_STUDENT(NAME) ;

--#6
SELECT P.NAME "교수님 이름", D.DNAME "소속 학과명" 
FROM T_PROFESSOR P JOIN T_DEPARTMENT D
	ON P.DEPTNO = D.DEPTNO 
;

-- #7
SELECT DEPTNO FROM T_STUDENT WHERE NAME = '이윤나'
;
SELECT S.NAME "학생이름", D.DNAME "학과명"
FROM T_STUDENT S, T_DEPARTMENT D
WHERE S.DEPTNO1 = D.DEPTNO 
	AND S.DEPTNO1 = (SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나')
;

-- #8
CREATE OR REPLACE VIEW v_stud_info(sname, dname, pname)
AS
SELECT S.NAME , D.DNAME , P.NAME 
FROM T_STUDENT S 
	JOIN T_PROFESSOR P ON S.DEPTNO = P.DEPTNO 
	JOIN T_DEPARTMENT D ON S.DEPTNO = D.DEPTNO 
;


SELECT S.NAME , P.NAME , D.DNAME 
FROM T_STUDENT S , T_PROFESSOR P, T_DEPARTMENT D
;


-- #9
ALTER TABLE T_STUDENT ADD (BIRTHDAY DATE) ;

-- #10
SELECT tname FROM tab WHERE USERNAME = 'SCOTT0316';


-- #1 

