-- ���� ������׷� �����ϱ�
select deptno, lpad('*',count(*),'*') as cnt
    from emp
group by deptno;