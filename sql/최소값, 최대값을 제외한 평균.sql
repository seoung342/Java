-- 최소값 최대값을 제외한 평균
select avg(sal)
    from ( select sal, min(sal) over() min_sal, max(sal) over() max_sal from emp) x
    where sal not in (min_sal, max_sal);