create table spring_product(
	id number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
)
create sequence product_seq;

select * from spring_product;