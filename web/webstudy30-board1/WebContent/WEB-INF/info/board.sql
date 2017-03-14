create table board(
	no number primary key,
	title varchar2(100) not null,
	writer varchar2(100) not null,
	password varchar2(20) not null,
	content clob not null,
	hit number default 0,
	time_posted date not null
)
drop table board;
drop sequence board_seq;
create sequence board_seq;

select * from board;

insert into board(no,title,writer,password,content,time_posted) 
values(board_seq.nextval,'하잉','가린','1234','집에 가고 싶다',sysdate);

insert into board(no,title,writer,password,content,time_posted) 
values(board_seq.nextval,'집에 가자아','테스트','abcd','빨리 가자~',sysdate);

select no,title,writer,to_char(time_posted,'YYYY/MM/DD'),hit from board order by no desc;

select title,writer,to_char(time_posted,'YYYY/MM/DD'),hit,content from board where no = 1;