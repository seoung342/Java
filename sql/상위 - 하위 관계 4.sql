-- 상위 - 하위 관계 4
select ltrim( sys_connect_by_path(ename,'-->'),'-->') leaf__branch__root
    from emp
    where level = 3
    start with ename = 'MILLER'
    connect by prior mgr = empno;