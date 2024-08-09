-- 상위 - 하위 관계 5
select lpad('.',2*level,'.')||ename emp_tree
    from emp
    start with mgr is null
    connect by prior empno = mgr;