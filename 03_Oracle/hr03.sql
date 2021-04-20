--01/29
--조인이 계산에 시간과 비용이 많이 들어서 같은 경우엔 서브쿼리 사용 (조인은 행 BY 행으로 연결하기 때문)

3-8>
select last_name, lpad(salary, 15, '$') salary
from employees;

3-9>
select last_name, hire_date, to_char(next_day(add_months(hire_date, 6),'월요일'),
'fmday, "the" Ddspth "of" month, yyyy') review --대소문자 맞춰주고 싶으면 포맷을 대문자로
from employees;

3-10>
select last_name, hire_date, to_char(hire_date, 'day')
from employees
order by to_char(hire_date-1, 'd'); -- 눈속임

3-11>
/* select last_name, nvl(to_char(commission_pct), 'No Commission') comm
   from employees; */
select last_name, coalesce (to_char(commission_pct), 'No Commission') comm
from employees;

3-12>
select salary, last_name || ' ' || rpad(' ', salary/1000+1, '*') --salary랑 비교하기 위해 함께 출력
from employees;

5-9>
select manager_id, count(*), min(salary)
from employees
where manager_id is not null
group by manager_id
having min(salary)>=6000
order by min(salary) desc;

5-10>
select department_name "Name", location_id "Location", count(*) "Number of People",
round(avg(salary), 2) "Salary"
from employees e, departments d
where e.department_id = d.department_id
group by department_name, location_id; --그룹 묶을 때 위의 조건과 같도록 해줘야 정상 작동함

5-11>
select count(*) total, 
sum(decode(to_char(hire_date, 'yy'), 05, 1, 0)) "2005",
sum(decode(to_char(hire_date, 'yy'), 06, 1, 0)) "2006",
sum(decode(to_char(hire_date, 'yy'), 07, 1, 0)) "2007",
sum(decode(to_char(hire_date, 'yy'), 08, 1, 0)) "2008"
from employees;

5-12>
select job_id,
sum(decode(department_id, 20, salary, 0)) "Dept 20",
sum(decode(department_id, 50, salary, 0)) "Dept 50",
sum(decode(department_id, 80, salary, 0)) "Dept 80",
sum(decode(department_id, 90, salary, 0)) "Dept 90",
sum(salary) "Total"
from employees
group by job_id;

6-1>
select last_name, hire_date
from employees
where department_id = (select department_id from employees where last_name='Zlotkey')
and last_name <> 'Zlotkey';

6-3>
select employee_id, last_name
from employees
where department_id in (select department_id from employees where last_name like '%u%');

6-4>
select last_name, department_id, job_id
from employees
where department_id in (select department_id from departments where location_id=1700);

6-5>
select last_name, salary
from employees
where manager_id = (select employee_id from employees where last_name='King' and manager_id is null);

6-6>
select department_id, last_name, job_id 
from employees
where department_id = (select department_id from departments where department_name='Executive');
