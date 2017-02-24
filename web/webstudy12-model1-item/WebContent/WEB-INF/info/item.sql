create table item(
	item_no number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
)

create sequence item_seq;

select * from item;
select item_no,name from item  order by item_no asc;

