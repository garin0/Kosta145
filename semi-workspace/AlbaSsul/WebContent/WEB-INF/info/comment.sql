create table reply(
 reply_id number not null, -- 댓글 번호
 article_id number not null, --게시물 번호
 member_id varchar2(100) not null, -- 작성자
 reply_date date, -- 작성일자
 description varchar2(1000) not null, -- 댓글 내용
 group_id number not null, -- 댓글과 대댓글 하나의 그룹번호
 parent_id number  not null, -- 부모 댓글 표시
 depth number default 0, -- 몇대손인지 dept
 order_id number not null, -- 게시물 기준으로 몇번째인지
 primary key(reply_id)
 
)
create sequence reply_id_seq;

drop table reply;
select * from reply;

-- 새로 작성된 댓글은 reply_id와 group_id는 동일하다.

-- fake data 
insert into reply(reply_id,article_id,member_id,reply_date,description,group_id,parent_id,depth,order_id)
values(reply_id_seq.nextval,1,'imUser',sysdate,'댓글 테스트입니다',1,0,0,1);

insert into reply(reply_id,article_id,member_id,reply_date,description,group_id,parent_id,depth,order_id)
values(reply_id_seq.nextval,1,'kosta145',sysdate,'이건 대댓글이야',1,1,1,2);

insert into reply(reply_id,article_id,member_id,reply_date,description,group_id,parent_id,depth,order_id)
values(reply_id_seq.nextval,1,'semi',sysdate,'새로운 댓글입니당',2,0,0,1);

/*1차 정렬 
Order BY Group_id Desc
     Order_id Asc

일반 댓글과 첫 번째 대댓글을 달 때
depth = parent.depth + 1
order_no = order_no + 1

존재하는 대댓글을 달 떄
depth = parent.depth + 1
order_no = parent_id 값의 max+1
 * 
 */