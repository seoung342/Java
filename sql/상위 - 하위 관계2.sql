-- 상위 - 하위 관계2
select sys_connect_by_path(ename,'-->') tree
    from emp
    start with ename = 'MILLER'
    connect by prior mgr = empno;