/* 
 * ERD 
 * 논리 모델링
 * 물리 모델링
 */
-- DDL
drop table spring_member;
drop table spring_board;

create table spring_member(
   id varchar2(100) primary key,
   password varchar2(100) not null,
   name varchar2(100) not null
);

create sequence spring_member_seq;

create table spring_board(
   no number primary key,
   title varchar2(100) not null,
   content clob not null,
   hit number default 0,
   time_posted date not null,
   smid varchar2(100) not null,
   constraint fk_smid foreign key(smid) references spring_member(id)
);

drop sequence spring_member_seq;
create sequence spring_board_seq;

insert into SPRING_MEMBER values('java','1234','김자바');
insert into spring_board(no,title,content,time_posted,smid) values(spring_board_seq.nextval,'11','11',sysdate,'java');
insert into spring_board(no,title,content,time_posted,smid) values(spring_board_seq.nextval,'11','11',sysdate,'java');
insert into spring_board(no,title,content,time_posted,smid) values(spring_board_seq.nextval,'11','11',sysdate,'java');
insert into spring_board(no,title,content,time_posted,smid) values(spring_board_seq.nextval,'11','11',sysdate,'java');
insert into spring_board(no,title,content,time_posted,smid) values(spring_board_seq.nextval,'11','11',sysdate,'java');
select * from spring_board;



select *
from(select row_number() over(order by no desc) as rnum,no,title,content,hit,
to_char(time_posted,'yyyy.MM.DD'), smid 
from spring_board) A, 
spring_member m where m.id=A.smid 
and rnum between 1 and 5 order by no desc;
               
SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DOCNUM DESC) 
RNUM, BRD_TYPE, BRD_CD, DOCNUM, ADD_USR_NM, 
TITLE, CONTENTS, ATTACH, DEL_CONF, VIEWCOUNT FROM BOARD_MAIN_TEST ) X WHERE X.RNUM BETWEEN #{first} AND #{last}

select * from spring_board b,spring_member m where b.smid = m.id and no = 2;

update spring_board set hit=hit+1 where no=2;
select * from spring_board;
select spring_board_seq.nextval from dual;

update spring_board
set title ='바꿈',content = 'ggggggdfs'
where no = 46