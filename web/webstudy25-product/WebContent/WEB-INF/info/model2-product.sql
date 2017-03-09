create table product(
 product_no number primary key,
 name varchar2(100) not null,
 maker varchar2(100) not null,
 price number not null,
 reg_date date not null
)

create sequence product_seq;
insert into product(product_no,name,maker,price,reg_date) values(product_seq.nextval,'새우깡','롯데',1500,sysdate);
select * from product;

select product_no,name,to_char(reg_date,'YYYY.MM.DD') from PRODUCT order by product_no asc;

select reg_date from product;