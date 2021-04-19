--01/28
-- ���� ��� ���
select department_id, department_name, d.location_id, city
from departments d, locations l
where d.location_id = l.location_id;

-- �ڿ�����(�����) : �����ϴ� ���̺��� ���� �̸��� �÷����� ���� ���� �������� ����
select department_id, department_name, location_id, city
from departments natural join locations;

select employee_id, last_name, e.department_id, location_id, e.manager_id
from employees e join departments d
on (e.department_id = d.department_id)
where e.manager_id=149;

select employee_id, hire_date, round(months_between('08/04/21', hire_date),0) tenure, 
add_months(hire_date, 6) review, next_day(hire_date, '�ݿ���'), last_day(hire_date)
from employees where months_between('08/04/21', hire_date) < 36;

select hire_date 
from employees 
order by hire_date desc;
