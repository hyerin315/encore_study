--02/03
--PLSQL : ���� �� ������ ����� ������ �� �ֵ��� ���ִ� ��,
--        �� �� �����ϰ� ������ �� (�ٸ� �ڵ� ���̿� �����ִ´ٰų� �ϴ� �� ����)
--        �Լ��� ���� ���� ���ν����� �ϸ�, ������� ����Ǿ ���߿� �ڹٿ��� ��� ȣ���� �� ����

--���ν��� ���� �� ����
--1) PROC1
set serveroutput on
var emp_name varchar2(25);
var emp_salary number; 
exec proc1(206, :emp_name, :emp_salary); -- ':' : ���ε� ����
print emp_name;
print emp_salary;

----------------------
select * from emp;
delete * emp; --��ü �� ����
--���� ������ �� �־��ֱ�
insert into emp
as
select * from employees;
----------------------
2) ADD_SAL
var sal number;
begin :sal := 100; end;
/
exec add_sal(105, :sal);
print sal;

3) DEPT_LIST
exec dept_list();

-----------------------
create table product(
sno number primary key,
name varchar2(20),
company varchar2(50),
p_date date,
price number,
quantity number
);

create sequence seq_prod;
-------------------------

4) ADD_PRODUCT
exec add_product('��ǻ��', '�Ｚ',to_date('18/12/25', 'yy/mm/dd'),1000, 13);
select * from product;

5) GET_PRODUCT
exec get_product(1);

6) GET_PRODUCT_BY_NAME
exec get_product_by_name('��ǻ��');

7) EDIT_PRODUCT
exec edit_product(1, 1300);

8) TEST1
var emp_name VARCHAR2(25);
exec test1('Fay', :emp_name);
print emp_name;

-------------------------------------------------------------------------------
�Լ�

1) make_name
select make_name(first_name, last_name)
from employees;

2) make_grade
var grade varchar2;
exec :grade:=make_grade(175);
print grade;


-------------------------------------
create table job_grades(
grade varchar2(2),
lowest number(8,2),
highest number(8,2)
);
select * from job_grades;
--------------------------------------
3) sal_grade
select employee_id, last_name, salary, 
sal_grade(salary) "sal grade"
from employees;
