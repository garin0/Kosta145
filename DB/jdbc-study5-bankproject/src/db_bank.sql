create table account (
	acc_no varchar2(100) primary key,
	name varchar2(100) not null,
	password varchar2(100) not null,
	balance number not null
)
drop table account;
create sequence acc_seq;
drop sequence acc_seq;
insert into account(acc_no,name,password,balance) values(acc_seq.nextval,'Çöºó','4567',1000);
select * from account;  

select balance from account where acc_no = 23  and password = 1234;

