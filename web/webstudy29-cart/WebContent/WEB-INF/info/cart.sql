drop table item;
create table item(
	item_no number primary key,
	name varchar2(200) not null, 
	maker varchar2(200) not null,
	price number not null,
	detail varchar2(2000) not null
)
drop sequence item_seq;
create sequence item_seq;

insert into item(item_no,name,maker,price,detail) values(item_seq.nextval,'아이폰3','애플',60,'모르게써');
insert into item(item_no,name,maker,price,detail) values(item_seq.nextval,'갤럭시7','삼성',100,'갤럭시이이');
select * from item;

select * from member;


