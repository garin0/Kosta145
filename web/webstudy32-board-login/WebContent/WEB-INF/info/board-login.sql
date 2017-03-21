create table login_member(
	id varchar2(100) primary key,
	password  varchar2(100) not null,
	name varchar2(100) not null
)
create table login_board(
	no number primary key,
	title varchar2(100) not null,
	content clob not null,
	hits number default 0,
	time_posted date not null,
	id varchar2(100) not null,
	constraint fk_id foreign key(id) references login_member(id)
)
create sequence login_board_seq;
drop table login_board;


select * from login_member;
select * from login_board;
insert into login_member(id,password,name) values('java','1234','자바자바');
insert into login_member(id,password,name) values('spring','1234','스프링');

insert into login_board(no,title,content,time_posted,id)
values(login_board_seq.nextval,'테스트2','흐항항항222',sysdate,'java');
insert into login_board(no,title,content,time_posted,id)
values(login_board_seq.nextval,'테스트33333','dgdsfs',sysdate,'spring');
select * from login_member where id='java' and password='1234';


select title,to_char(time_posted,'YYYY/MM/DD HH24:MI:SS'),hits,content,id from login_board where no = 1;


delete from login_board where no=14;




select C.* from (
select row_number() over(order by no desc)
as rnum,B.no,A.name,B.title,to_char(B.time_posted,'YYYY/MM/DD'),B.hits
from login_member A,login_board B 
where A.id = B.id
)C where rnum between 6 and 10

select count(*) from login_board

select m.id,m.name, A.*  from(select row_number() over(order by no desc) as rnum,no,title,content,hits,
to_char(time_posted,'yyyy.MM.DD'), id 
from login_board) A, login_member m where m.id=A.id and rnum between 1 and 5 order by no desc

update login_board set title=?,content=? where no =?
