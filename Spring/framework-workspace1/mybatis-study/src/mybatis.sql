create table spring_member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100) not null
)
insert into spring_member values('java','1234','아이유','판교');
commit