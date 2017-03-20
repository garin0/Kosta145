/* subquery : 부쿼리
 * 			  SQL안의 SQL
 * 			  SQL문 안에 포함되는 또 다른 SQL문
 */
create table account_book(
	seq number primary key,
	content varchar2(100) not null,
	amount number not null
)
drop table account_book;
insert into account_book(seq,content,amount) values(1,'뻔맥',10000);
insert into account_book(seq,content,amount) values(2,'치맥',20000);
insert into account_book(seq,content,amount) values(3,'노맥',15000);
insert into account_book(seq,content,amount) values(4,'곱맥',25000);
insert into account_book(seq,content,amount) values(5,'골맥',18000);
select count(*) from account_book;
-- 지출 내역 중 최고액을 조회
select max(amount) from account_book;
-- 가장 높은 액수의 지출내역은? 곱맥
select max(amount) from account_book;
select content from account_book where amount= 25000;
-- 위 두 sql을 하나의 sql로 정의
select content from account_book where amount= (
	select max(amount) from account_book
);
select avg(amount) from account_book;
-- 연습) 평균액수보다 많은 금액을 가진 내역과 금액을 조회
select content,amount from account_book where amount > (
	select avg(amount) from account_book
) order by amount desc;
-- 평균액수보다 낮은 금액amount 중 가장 높은 금액의 내역content은?
select content from account_book where amount = (
	select max(amount) from account_book where amount < (	
		select avg(amount) from account_book
	)
);
select empno,ename,sal from emp order by sal desc;
-- 연습) 가장 낮은 sal을 받는 사원의 ename을 조회
select ename from emp where sal = (
	select min(sal) from emp
);
select * from emp;
-- 연습) 가장 낮은 sal을 받는 사원의 매니저의 사원명을 조회
select ename from emp where empno = (
	select mgr from emp where sal = (
		select min(sal) from emp
	)
);
--연습) 사원 평균월급액수보다 작은 월급을 받는 사원 중
-- 가장 높은 월급을 받는 사원의 매니저의 사원명을 조회
select ename from emp where empno = (
	select mgr from emp where sal = (
		select max(sal) from emp where sal < (
			select avg(sal) from emp
		)
	)
);




