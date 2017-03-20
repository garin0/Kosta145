-- Oracle row_number() over() : row(줄)에 대한 순차적인 번호를 제공
-- View : 뷰는 물리적으로 존재하지 않은 가상테이블
--        SELECT 명령의 실행결과를 테이블처럼 사용
-- Inline View : SQL 문장에서 From 절에 사용된 subquery 
-- paging sql 정의시 사용됨 

drop table player;
create table player(
 no number primary key,
 title varchar2(1) not null,
 singer varchar2(30) not null
)
-- alter 를 이용해 price column 추가 
alter table player add price number;
-- alter 를 이용해 title 의 컬럼 사이즈 변경 
alter table player modify(title varchar2(100));

select * from player;
drop sequence mp3_seq;
create sequence mp3_seq;

insert into player(no,title,singer,price) values(mp3_seq.nextval,'그리고 하나','태연',700);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'Man In Love','인피니트',500);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'Crescendo','악동뮤지션',400);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'벚꽃엔딩','버스커버스커',800);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'둘이서한잔해','다비치',900);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'어느봄날','2AM',1000);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'기대해','걸스데이',300);
insert into player(no,title,singer,price) values(mp3_seq.nextval,'아니야','윤하',600);
commit
select count(*) from player;
--no 내림차순 정렬
select * from player order by no desc;
--row_number() over(정렬)
select row_number() over(order by no desc) as rnum,no,title from player;
--singer가 2AM인 곡을 삭제
delete from player where singer='2AM';
-- rnum이 3이하인 곡명들만 조회
-- 해결방안은 subquery로 rownum(행번호)을 생성한 후 
-- 바깥 sql에서 where절을 이용해 조회하면 된다.
-- Inline View : SQL 문장에서 From 절에 사용된 subquery 

SELECT b.empno,b.ename,b.job,b.sal, b.deptno
        FROM (SELECT empno
                  FROM emp  
                  WHERE sal >(SELECT AVG(sal) FROM emp WHERE deptno = 20)) a, emp b
        WHERE a.empno = b.empno
             AND b.mgr is NOT NULL
            AND b.deptno != 20
            
select no,title from (
select row_number() over(order by no desc) as rnum,no,title from player
)where rnum<=3;

-- rownum 기준 4이상 6이하 곡 no와 title을 조회한다.
select A.* from(
select row_number() over(order by no desc) as rnum,no,title,singer,price from player
)A where rnum between 4 and 6;

delete from board;
comit

select count(*) from board;
select * from board;
-- 게시판 목록 페이지에서 사용하기 위한 페이징sql
-- 최근 게시물 순으로 1~5번째 게시물 정보를 조회

select A.no,A.title,A.writer,A.time_posted,A.hit from (
	select row_number() over(order by no desc) as rnum,no,title,writer,to_char(time_posted,'YYYY/MM/DD') as time_posted,hit from board
)A  where rnum between 1 and 5;

select A.* from (
	select row_number() over(order by no desc) as rnum,no,title,writer,to_char(time_posted,'YYYY/MM/DD') as time_posted,hit from board
)A  where rnum between 1 and 5;


