--02/03
--PLSQL : 조금 더 복잡한 기능을 구현할 수 있도록 해주는 것,
--        한 번 실행하고 끝나는 것 (다른 코드 사이에 끼워넣는다거나 하는 건 안함)
--        함수로 만들어서 저장 프로시저를 하면, 기능으로 저장되어서 나중에 자바에서 기능 호출할 수 있음

--프로시저 생성 후 실행
--1) PROC1
set serveroutput on
var emp_name varchar2(25);
var emp_salary number; 
exec proc1(206, :emp_name, :emp_salary); -- ':' : 바인드 변수
print emp_name;
print emp_salary;

----------------------
select * from emp;
delete * emp; --전체 줄 삭제
--값이 없으면 값 넣어주기
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
exec add_product('컴퓨터', '삼성',to_date('18/12/25', 'yy/mm/dd'),1000, 13);
select * from product;

5) GET_PRODUCT
exec get_product(1);

6) GET_PRODUCT_BY_NAME
exec get_product_by_name('컴퓨터');

7) EDIT_PRODUCT
exec edit_product(1, 1300);

8) TEST1
var emp_name VARCHAR2(25);
exec test1('Fay', :emp_name);
print emp_name;

-------------------------------------------------------------------------------
함수

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
