--02/02
--���պ�� ���Ϻ並 ���� �ʿ�� ���� : ��� �׳� �б⸸ ���� (�並 ���ؼ� insert�� �� �ʿ䰡 ����)

--�������� = �ζ��� ��

--Top-N �м�
select rownum as rank, last_name, salary
from (select last_name, salary from employees
      order by salary DESC)
where ROWNUM <= 3;

