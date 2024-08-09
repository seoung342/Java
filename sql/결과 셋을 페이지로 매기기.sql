-- 결과 셋을 페이지로 매기기
select sal 
    from ( select row_number() over(order by sal) as rn, sal from emp ) x
where rn between 1 and 5;