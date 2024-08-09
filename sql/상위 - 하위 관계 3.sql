-- 상위 - 하위 관계 3
select ltrim( sys_connect_by_path(ename, ' - '), ' - ' ) emp_tree
    from emp
    start with mgr is null
    connect by prior empno = mgr
order by 1;