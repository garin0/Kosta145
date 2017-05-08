create table spring_member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100) not null
)
insert into spring_member values('java','1234','아이유','판교');
commit
select * from spring_member;
select * from dept;
select * from emp;
select * from salgrade;
select * from emp e,dept d where e.empno = d.deptno;

select e.empno,e.ename,d.deptno,d.dname,d.loc
from emp e,dept d
where e.deptno(+) = d.deptno
---------------------------------------------
영화제목,장르,관객수,감동명,감독소개
---------------------------------------------
create table director(
	director_id varchar2(100) primary key,
	director_name varchar2(100) not null,
	director_intro varchar2(100) not null
)
select * from movie;
create table movie(
	movie_id varchar2(100) primary key,
	title varchar2(100) not null,
	genre varchar2(100) not null,
	attendance number default 0,
	director_id varchar2(100) not null constraint fk_director_id references director(director_id)
)

insert into director values('a','봉준호','한국영화아카데미수료,황금사자상수상');


select m.title as TITLE ,m.genre as GENRE,m.attendance as ATTENDANCE,
 		d.director_name as DIRECTOR_NAME
 		from movie m,director d
 		where d.director_id = 'a';
 		
drop table guestbook;
create table guestbook(
	no number primary key,
	title varchar2(100) not null,
	content clob not null
)

create sequence guestbook_seq;

insert into guestbook(no,title,content)
values(guestbook_seq.nextval,'마지막예제','고생하셨습니다~');
insert into guestbook(no,title,content)
values(guestbook_seq.nextval,'마지막예제','고생하셨습니다~2');
insert into guestbook(no,title,content)
values(guestbook_seq.nextval,'마지막예제','고생하셨습니다~3');
commit

select * from guestbook;

select no,title,content
 		from guestbook