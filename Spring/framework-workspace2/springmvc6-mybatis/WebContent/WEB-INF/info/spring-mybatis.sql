create table spring_customer(
	id varchar2(100) primary key,
	name varchar2(100) not null,
	address varchar2(100) not null
)
insert into spring_customer values('java','아이유','판교');

commit

select * from guestbook;
