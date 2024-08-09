-- 단순 소계 계산하기
select case grouping(job)
            when 0 then job
            else 'TOTAL'
        end job,
        sum(sal) sal
    from emp
    group by rollup(job);