drop table member_tx;

create table member_tx(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100) not null
);
insert into member_tx(id,password,name,address) values('java','1234','아이유','판교');

select * from member_tx;

drop table point_tx;

create table point_tx(
	id varchar2(100) primary key,
	point number not null,
	point_type varchar2(100) not null,
	constraint fk_tx_id foreign key(id) references member_tx
);

insert into point_tx(id,point,point_type) values('java',100,'cgv');

select * from point_tx;

-- 부모키가 없습니다.
insert into point_tx(id,point,point_type) values('java2',100,'cgv');

delete from member_tx;
delete from point_tx;
commit
