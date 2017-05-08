select * from DEPT_EX;
select * from EMP_EX;

select e.ename,e.sal,d.dname,d.loc from(
select empno,ename,sal,deptno from EMP_EX) e, DEPT_EX d
where e.deptno = d.deptno and e.empno = 1;


select e.* from(
select row_number() over(order by empno asc) as rnum,empno,deptno from EMP_EX) e, DEPT_EX d
where e.deptno = d.deptno 

select empno from EMP_EX order by empno asc;