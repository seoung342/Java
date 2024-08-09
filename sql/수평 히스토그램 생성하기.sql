-- 수평 히스토그램 생성하기
select deptno, lpad('*',count(*),'*') as cnt
    from emp
group by deptno;