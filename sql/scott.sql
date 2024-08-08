select * from emp;
/** **/
select ename ||' WORKS AS A '||job as MSG from emp where deptno = 10;
/** sal이 2000 이하면 UNDERPAID 4000이상이면 OVERPAID 둘다 아니면 OK **/
select Empno, sal, 
    case
        when sal <= 2000 then 'UNDERPAID'
        when sal >= 4000 then 'OVERPAID'
        else 'OK'
    end as sal_text
from emp;

/* emp 테이블에서 무작위로 5개의 레코드만 반환하는 SQL문장 */
select ROWNUM, ename, sal from emp;

/* emp 테이블에서 comm이 null인 레코드만 반환하는 문장*/
select * from emp where comm is null;

/* 부서 10과 20의 사원들 중 이름에 'I'가 있거나 직급명이 'ER'로 끝나는 사원만*/
select * from emp where deptno in (10, 20) and (ename like '%I%' or job like '%ER');

/* emp 테이블에서 deptno 기준 오름차순, sal을 내림차순으로*/
select * from emp order by deptno asc, sal desc;

/* emp 테이블에서 사원명과 직급을 반환하되 job 열의 마지막 두 문자를 기준으로 정렬*/
select job, substr(job, -2) from emp order by substr(job, -1) asc;

/* view 만들기 */
create view V as select ename ||' '||deptno as data from emp;
select data from v;

select * from v order by replace(data, replace(translate(data,'0123456789','#########'), '#', ''),'');

/* null이 아닌 comm을 우선 오름차순하고 null이 가장 위에 나오게*/
select ename, sal, comm from emp order by comm nulls first;

/* job이 'SALESMAN'이면 comm 기준으로 정렬하고 그렇지 않으면 sal 기준으로 정렬*/
select ename, sal, job, comm from emp order by case when job = 'SALESMAN' then comm else sal end ;