select * from ( select rownum rn, e.* from (select * from emp order by sal) e)
    where rn between 6 and 10;