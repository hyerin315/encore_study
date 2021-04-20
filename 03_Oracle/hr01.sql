--01/28

2-4> 
select last_name, job_id, hire_date 
from employees
where hire_date between '05/02/20' and '05/05/01';

2-7> 
select last_name, hire_date 
from employees
where hire_date like '04%';

2-11> 
select last_name from employees
where last_name like '%a%'
and last_name like '%e%';

2-13> 
select last_name, salary, commission_pct, department_id from employees
where salary between 5000 and 12000
and department_id in(20, 50, 80)
and commission_pct = .2;

4-2>
select distinct job_id, location_id
from employees e, departments d
where e.department_id=d.department_id
and e.department_id=80;

4-4>
select last_name, department_name
from employees e, departments d
where e.department_id=d.department_id
and last_name like '%a%';

4-6>
select w.last_name "Employee", w.employee_id "Emp#", m.last_name "Manager",
m.employee_id "Mgr#"
from employees w, employees m
where w.manager_id=m.employee_id;

4-7>
select w.last_name "Employee", w.employee_id "Emp#", m.last_name "Manager",
m.employee_id "Mgr#"
from employees w, employees m
where w.manager_id=m.employee_id(+);

4-8>
select e.department_id department, e.last_name employee, c.last_name colleague
from employees e, employees c
where e.department_id=c.department_id
and e.employee_id <> c.employee_id
order by e.department_id, e.last_name;

4-9>
create table job_grades(
grade varchar2(1) primary key, 
lowest_sal number(8, 2),
highest_sal number(8, 2)
);

insert into job_grades values('A', 1000, 2999);
insert into job_grades values('B', 3000, 5999);
insert into job_grades values('C', 6000, 9999);
insert into job_grades values('D', 10000, 14999);
insert into job_grades values('E', 15000, 24999);
insert into job_grades values('F', 25000, 40000);

desc job_grades;

select last_name, job_id, department_name, salary, grade
from employees e, departments d, job_grades g
where e.department_id=d.department_id
and salary between lowest_sal and highest_sal;

4-10>
select c.last_name, c.hire_date
from employees d, employees c
where d.last_name = 'Davies'
and d.hire_date < c.hire_date;

select last_name, hire_date
from employees where last_name = 'Davies';

4-11>
select w.last_name "Employee", w.hire_date "Emp Hired", m.last_name "Manager", m.hire_date "Mgr Hired"
from employees w, employees m
where w.manager_id = m.employee_id
and w.hire_date < m.hire_date;


