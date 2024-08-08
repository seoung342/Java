select * from emp;
/** **/
select ename ||' WORKS AS A '||job as MSG from emp where deptno = 10;
/** sal�� 2000 ���ϸ� UNDERPAID 4000�̻��̸� OVERPAID �Ѵ� �ƴϸ� OK **/
select Empno, sal, 
    case
        when sal <= 2000 then 'UNDERPAID'
        when sal >= 4000 then 'OVERPAID'
        else 'OK'
    end as sal_text
from emp;

/* emp ���̺��� �������� 5���� ���ڵ常 ��ȯ�ϴ� SQL���� */
select ROWNUM, ename, sal from emp;

/* emp ���̺��� comm�� null�� ���ڵ常 ��ȯ�ϴ� ����*/
select * from emp where comm is null;

/* �μ� 10�� 20�� ����� �� �̸��� 'I'�� �ְų� ���޸��� 'ER'�� ������ �����*/
select * from emp where deptno in (10, 20) and (ename like '%I%' or job like '%ER');

/* emp ���̺��� deptno ���� ��������, sal�� ������������*/
select * from emp order by deptno asc, sal desc;

/* emp ���̺��� ������ ������ ��ȯ�ϵ� job ���� ������ �� ���ڸ� �������� ����*/
select job, substr(job, -2) from emp order by substr(job, -1) asc;

/* view ����� */
create view V as select ename ||' '||deptno as data from emp;
select data from v;

select * from v order by replace(data, replace(translate(data,'0123456789','#########'), '#', ''),'');

/* null�� �ƴ� comm�� �켱 ���������ϰ� null�� ���� ���� ������*/
select ename, sal, comm from emp order by comm nulls first;

/* job�� 'SALESMAN'�̸� comm �������� �����ϰ� �׷��� ������ sal �������� ����*/
select ename, sal, job, comm from emp order by case when job = 'SALESMAN' then comm else sal end ;