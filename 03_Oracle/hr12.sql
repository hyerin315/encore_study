--02/03
--Ʈ���� : � ������ �� ��, �� �۾��� �Ͼ�� ���̳� �Ŀ� ���������� ó���Ǿ���ϴ� ������� �����ϱ� ���� ���
--        ex.���ο� ����� ���ͼ� insert�Ҷ� ���� (�˻��� �������) ���� �۾��� �ϰ��� �ϴ� �� ���α׷��� �ϴ� ��
----------------------------------------------
create table emp_tmp
as
select employee_id, last_name, job_id, salary
from employees
where 1=0;

alter table emp_tmp
add (action varchar2(1));

select * from emp_tmp;
-----------------------------------------------
1) Trigger1
- ����
insert into emp values(306, 'aaa', 'bbb', 'emaila', '111.222.3333', 
sysdate, 'MK_MAN', 13000, null, 100, 20);
- ����
update emp set salary=15000 where employee_id=306;
- ����
delete emp where employee_id=306; --�����Ǿ����� ����� ��������


--------------------
--��Ŭ���� ��� �߰� Ȯ��
select * from member;
