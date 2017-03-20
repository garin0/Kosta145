/* JOIN SQL: 두개 이상의 테이블에서 행을 결합하기 위해
 * 사용하는 sql.
 * 사례) 사원정보 : 사원번호, 사원명, 입사일,월급,부서명,부서지역,부서전화번호
 * 실제 데이터
 * 1	아이유	2017	300		개발	판교	031
 * 2	오남준	2017	300		개발	판교	031
 * 
 * 위와 같이 사원수가 늘어날 수록 동일한 부서정보가 중복되어 저장된다.
 * 테이블을 분리하여 설계
 * 
 * 사원테이블,부서테이블
 * 부서정보의 PK(primary key)를 사원정보에서 참조하도록
 * FK(foreign key)로 설계
 * FK: 한 테이블의 키 중 다른 테이블의 행을 식별할 수 있도록
 * 		하기 위한 key(두 테이블 간의 연결을 위한 key)
 * 부모테이블(master table):참조대상테이블을 말한다. -> 부서테이블
 * 자식테이블:참조하는 테이블을 말한다(fk) -> 사원테이블
 * 
 * FK(foreign key 외래키 참조키)
 * constraint 제약조건명 foreign eky(참조정보저장컬럼명)
 * references 부모테이블(컬럼명)
 * 또는
 * 컬럼 선언시 바로 제약조건 줄 때는
 * 컬럼명 데이터타입 constraint 제약조건명 references 부모테이블(컬럼명)
 * 
 * 위와 같이 foreign key 제약조건을 주면 참조하는 부모테이블의 컬럼에 존재하지 않는 정보를 insert할 때는
 * 무결성 제약 조건 에러가 발생한다.
 * ex) 부서 테이블의 부서정보번호가 10,20,30이 존재할 때
 * 사원 테이블의 부서번호 40이 insert될 경우에는
 * 부모(부서) 테이블에 존재하지 않는 정보이므로 error가 발생
 */
create table dept_ex(
	deptno number primary key,
	dname varchar2(100) not null,
	loc varchar2(100) not null,
	tel varchar2(100) not null
)
drop table dept_ex;
create table emp_ex(
	empno number primary key,
	ename varchar2(100) not null,
	sal number not null,
	deptno number not null,
	constraint fk_deptno_ex foreign key(deptno) references dept_ex(deptno)
)
부서(부모) 테이블 부터 생성해야 사원(자식)테이블 생성 가능하다.
insert into emp_ex(empno,ename,sal,deptno) values(1,'아이유',300,10);
-- 무결성 제약조건(SCOTT.FK_DEPTNO_EX)이 위배되었습니다.
-- 부서테이블에 존재하지 않는 부서정보를 INSERT 하려고 했기 때문에
insert into dept_ex(deptno,dname,loc,tel) values(10,'개발','판교','031');
insert into dept_ex(deptno,dname,loc,tel) values(20,'영업','용인','070');

insert into emp_ex(empno,ename,sal,deptno) values(2,'김문일',400,10);
insert into emp_ex(empno,ename,sal,deptno) values(3,'강정호',700,20);

select * from dept_ex;
select * from emp_ex;

commit

-- 모든 사원의 사원번호,사원명,부서명을 조회하고자 한다.
-- 테이블이 분리되어있는 상태이므로 두 테이블의 정보를 결합(join)하여 조회해야 한다.
/* Equi join: 동등조인,inner join
 * 두개 이상의 테입ㄹ로 부터 자료를 조회하기 위해 사용
 * 일반적으로 pk와 fk를 이용해 join 한다.
 * 사례)부서 테이블의 부서번호와 사원 테이블의 부서번호가 상응하는 컬럼
 *  SELECT 컬럼명 ...
 *  FROM TABLE 1 별칭, TABLE2 별칭
 *  WHERE 별칭.컬럼 = 별칭.컬럼 ;  --> 조인 조건,조인시 별칭권장
 */

select e.empno,e.ename,d.dname
from emp_ex e, dept_ex d
where e.deptno = d.deptno
order by e.empno asc;

-- 사원번호 2인 사원이 근무하는 지역을 조회

select d.loc
from emp_ex e, dept_ex d
where e.deptno = d.deptno and e.empno = 2;

select * from emp;
select * from dept;
-- emp 와 dept 테이블을 join sql로 아래와 같이 정보를 조회하세요.
-- empno,ename,sal,deptno,dname,loc 를 

select e.empno,e.ename,e.sal,e.deptno,d.dname,d.loc
from emp e, dept d
where e.deptno = d.deptno;

/* 2. Non-Equi Join
 *    테이블 간의 컬럼이 상응하지 않은 관계에서의 조인 
 *    EMP(사원)            SALGRADE(월급등급)
 *    sal (월급)            grade , hisal , losal 
 *    두 테이블의 연관성은 사원의 월급과 월급등급의 최고액과 최저액
 *    사이에 있다. 
 *    ex) SMITH 의 sal 이 800이면 월급등급은 1등급이다. 
 */

drop table salgrade;
create table salgrade(
     grade number primary key,
     losal number,
     hisal number
 )
    insert into salgrade(grade,losal,hisal) values(1,700,1200); 
    insert into salgrade(grade,losal,hisal) values(2,1201,1400);  
    insert into salgrade(grade,losal,hisal) values(3,1401,2000);  
    insert into salgrade(grade,losal,hisal) values(4,2001,3000);   
    insert into salgrade(grade,losal,hisal) values(5,3001,9999); 
    select * from salgrade;
    select * from emp;
/*
 * emp 테이블의 empno,ename,sal,grade,losal,hisal을 조회
 * (emp dhk salgrade table을 non-equi join으로 조회)
 */
select e.empno,e.ename,e.sal,s.grade,s.losal,s.hisal
from emp e,salgrade s
where e.sal >= s.losal and e.sal <= s.hisal;

-- ename이 SMITH인 사원의 SALGRADE
select s.grade
from emp e,salgrade s
where e.sal >= s.losal and e.sal <= s.hisal and e.ename='SMITH';

-- ename이 MILLER인 사원의 SALGRADE와 부서명 DNAME을 조회
select s.grade, d.dname
from emp e, salgrade s, dept d
where e.deptno = d.deptno and e.sal >= s.losal and e.sal <= s.hisal and e.ename='MILLER';


/* 3. Outer Join 
    *     일반적인 조인은 테이블간의 컬럼에 일치되는 값이 없으면
    *     데이터 조회가 안된다 
    *     예를 들면 부서 정보는 10,20,30,40 이 있지만
    *     40번 부서는 사원 정보가 없으므로 
    *     사원과 부서의 equi join 시에 
    *     40번 부서에 대한 정보는 조회되지 않는다 
    *     이와 같이 일반적인 조인으로는 조회되지 않는 
    *     정보까지 모두 조회하기 위해 Outer Join을 사용한다. 
    *    ( 사원이 없는 부서의 정보까지 함께 조회하기 위해 사용 ) 
    * 
    *     how? join 조건에 (+) 을 명시 ( 조인시킬 값이 없는 측에 표기 ) 
    *           select column ...
    *           from table1,table2
    *           where table1.컬럼(+)=table2.컬럼
    * 
    */

select distinct deptno from emp;
select distinct deptno from dept;

select e.empno,e.ename,d.deptno,d.dname
from emp e,dept d
where e.deptno = d.deptno
order by d.deptno asc;
-- 위 join sql을 실행하면 사원정보가 없는 부서정보(40)는 조회되지 x
-- 사원이 없는 부서정보까지 모두 조회하고자 할 때에는 Outer join을 이용하여 조회하면 된다.
select e.empno,e.ename,d.deptno,d.dname
from emp e,dept d
where e.deptno(+) = d.deptno
order by d.deptno asc;
-- 데이터가 없는 측에(+) : Outer join 연산자 이용
  /* 4. Self Join
     *     테이블 자체에서 조인 
     *     동일한 테이블이지만 개념적으로 다른 정보를 결합 
     *     사례 - 사원 정보와 매니저 정보를 함께 조회 
     * 
     */
-- 사원의 사원번호, 사원명,매니저,매니저의 사원번호, 매니저의 사원명
select worker.empno,worker.ename,worker.mgr,manager.empno,manager.ename
from emp worker, emp manager
where worker.mgr = manager.empno;

-- GROUP BY: 데이터들을 원하는 그룹으로 집계하기 위해 사용
-- 부서별로 사원수를 집계
select deptno, count(*) emp_count
from emp
group by deptno
order by emp_count asc;
-- 부서별 사원의 평균월급(반올림)을 조회
-- 부서번호, 평균월급, 평균월급 내림차순으로
select deptno,round(avg(sal)) avg_sal
from emp
group by deptno
order by avg_sal desc;

-- 부서번호 deptno,부서명 dname,부서별 사원수 emp_count,부서별 평균월급 avg_sal
select d.deptno,d.dname, emp_count,avg_sal
from ( 
select deptno, count(*) emp_count, round(avg(sal)) avg_sal
from emp
group by deptno
order by emp_count asc) e, dept d
where e.deptno = d.deptno;

select * from emp;