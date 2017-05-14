-- table myproduct
-- column : id , name ,maker , price 
create table myproduct(
	id number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
)
-- sequence myproduct_seq 
drop sequence myproduct_seq;
delete from myproduct;
commit
create sequence myproduct_seq nocache;
insert into myproduct(id,name,maker,price) values(myproduct_seq.nextval,'아이폰4','애플',400);
insert into myproduct(id,name,maker,price) values(myproduct_seq.nextval,'아이폰5','애플',500);
insert into myproduct(id,name,maker,price) values(myproduct_seq.nextval,'아이폰6','애플',600);
insert into myproduct(id,name,maker,price) values(myproduct_seq.nextval,'갤럭시5','삼성',500);
insert into myproduct(id,name,maker,price) values(myproduct_seq.nextval,'갤럭시노트7','삼성',100);
insert into myproduct(id,name,maker,price) values(myproduct_seq.nextval,'갤럭시7','삼성',300);
insert into myproduct(id,name,maker,price) values(myproduct_seq.nextval,'G5','LG',500);

select * from myproduct;






create table report(
	keyword varchar2(100) primary key,
	count number default 1
)
select report.*,rank() over(order by count desc) as rk,
row_number() over(order by count desc) as rnum from report;

select A.* from(
select report.*,rank() over(order by count desc) as rk,
row_number() over(order by count desc) as rnum from report
		) A where rnum between 1 and 5;