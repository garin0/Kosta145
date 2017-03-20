select * from dept_ex;

select * from emp_ex;

select e.empno,e.ename,d.dname,d.loc from emp_ex e, dept_ex d where e.deptno = d.deptno;

select e.empno,e.ename,e.sal,d.deptno,d.dname,d.loc,d.tel from emp_ex e, dept_ex d where e.deptno = d.deptno and e.empno =2;