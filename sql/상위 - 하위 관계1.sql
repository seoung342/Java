-- ���� - ���� ����1
select ename
    from emp
    start with ename = 'MILLER'
connect by prior mgr = empno;