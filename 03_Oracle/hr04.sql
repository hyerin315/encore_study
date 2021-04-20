--01/29
--1. dept 테이블을 department 테이블의 구조만 복사해서 생성 
create table dept
as
(select * from departments where 1=0); 
--where 1=0 : WHERE 조건절에 항상 flase가 되는 조건인 1=0을 주어 결국 데이터는 없는 빈 테이블을 만드는 쿼리문 (절대로 성립 안되는 다른 값을 넣어도 가능)

desc dept;

select * from dept;

--2-1. 테이블의 모든 칼럼에 값을 입력하겠다 (순서대로)
insert into dept values(10, 'aaa', 100, 1700);
insert into dept(department_id, department_name) --이 두개에 대한 것만 값을 넣겠다 (나머지는 null
values(20, 'bbb');

insert into dept(manager_id, location_id, department_id, department_name)
values(100,1700, 30, 'ccc');

insert into dept values(40, 'ddd', null, null);

--2-2. 서브쿼리를 이용하면 한 번에 여러줄 삽입 가능
insert into dept
select * from departments where department_id>40 and department_id<>80;
--다른 테이블의 내용을 복사해서 가져와 만들 수 있다

--3-1. 수정
update dept set department_name = 'xxx' where department_id=40;

--3-2. 서브쿼리 이용


--값 삭제
delete dept where department_id = 100;


--예제) 
--emp테이블을 employees 테이블 구조 복사하여 생성
/*create table emp
as(select * from employees where 1=0);*/

desc emp;
select * from emp;

-- 내용까지 복사하는 형태
drop table emp;
create table emp
as select * from employees;


--명시적 기본값 사용
create table dept_loc(
dept_id number primary key,
loc_name varchar2(20) default '서울');

insert into dept_loc(dept_id) values(10);
insert into dept_loc values(20, default);
insert into dept_loc values(30, null);
select * from dept_loc;


--alter문 사용
alter table dept_loc
add (dept_name varchar2(20));
alter table dept_loc
add (dept_name2 varchar2(20));
alter table dept_loc
add (dept_name3 varchar2(20));

--크기 수정
alter table dept_loc
modify (dept_name verchar2(30));

--삭제
alter table dept_loc
drop column dept_name;

desc dept_loc;

--컬럼 여러개 삭제
--unused를 사용하면 없는 것처럼 취급)
alter table dept_loc
set unused (dept_name);

alter table dept_loc
set unused (dept_name2);

alter table dept_loc
set unused (dept_name3);

--set unused 파일 한 번에 삭제
alter table dept_loc
drop unused columns;


-------------------------------------------------------------------------------
desc employees;

insert into emp
select * from employees;

select * from emp2;
create table emp2
as
select * from employees where department_id=80;


update emp2 set first_name='aaa', last_name='bbb';

-- emp : employees와 동일
-- emp2 : 부서 80번만, 모든 사람의 이름이 aaa, bbb


--Merge문
--emp와 emp2 합치면 emp2에 없는 것은 insert
--emp, emp2 양쪽에 값이 있지만 값이 같지 않으면 update(갱신)

merge into emp2 e2
using emp e
on(e2.employee_id = e.employee_id)
when matched then 
update set
    e2.first_name = e.first_name,
    e2.last_name = e.last_name --모든 칼럼에 대해 작성
    
when not matched then
insert values(e.employee_id, e.first_name)

--커밋 : 데이터 베이스 쓰기 완료 = 내가 변경한 다른 user에게도 적용되는 것 -> 커밋이 되면 취소 안됨
--sql 실행하는 app이 종료
--ddl 문장 하나 실행
--dcl 문장 하나 실행

select * from emp2;
commit;--DB연동을 할 때 커밋을 해야 자바 프로그램에서도 확인 가능하다(insert, rollback할 때 커밋해두고 확인하고 실행)
update emp2 set first_name='ccc' where employee_id = 145;
savepoint a
delete emp2 where employee_id = 145;
savepoint b
delete emp2 where first_name-'qqq', where employee_id=145;
rollback to a --a까지만 취소해라
rollback
