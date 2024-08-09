-- 가능한 모든 식 조합의 소계 계산하기
select deptno,
        job,
        case grouping(deptno)||grouping(job)
            when '00' then 'TOTAL by dept and job'
            when '10' then 'total by job'
            when '01' then 'total by dept'
            when '11' then 'grant total for table'
        end category,
        sum(sal) sal
    from emp
group by cube(deptno, job)
order by grouping(job), grouping(deptno);