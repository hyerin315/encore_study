--01/29
--1. dept ���̺��� department ���̺��� ������ �����ؼ� ���� 
create table dept
as
(select * from departments where 1=0); 
--where 1=0 : WHERE �������� �׻� flase�� �Ǵ� ������ 1=0�� �־� �ᱹ �����ʹ� ���� �� ���̺��� ����� ������ (����� ���� �ȵǴ� �ٸ� ���� �־ ����)

desc dept;

select * from dept;

--2-1. ���̺��� ��� Į���� ���� �Է��ϰڴ� (�������)
insert into dept values(10, 'aaa', 100, 1700);
insert into dept(department_id, department_name) --�� �ΰ��� ���� �͸� ���� �ְڴ� (�������� null
values(20, 'bbb');

insert into dept(manager_id, location_id, department_id, department_name)
values(100,1700, 30, 'ccc');

insert into dept values(40, 'ddd', null, null);

--2-2. ���������� �̿��ϸ� �� ���� ������ ���� ����
insert into dept
select * from departments where department_id>40 and department_id<>80;
--�ٸ� ���̺��� ������ �����ؼ� ������ ���� �� �ִ�

--3-1. ����
update dept set department_name = 'xxx' where department_id=40;

--3-2. �������� �̿�


--�� ����
delete dept where department_id = 100;


--����) 
--emp���̺��� employees ���̺� ���� �����Ͽ� ����
/*create table emp
as(select * from employees where 1=0);*/

desc emp;
select * from emp;

-- ������� �����ϴ� ����
drop table emp;
create table emp
as select * from employees;


--����� �⺻�� ���
create table dept_loc(
dept_id number primary key,
loc_name varchar2(20) default '����');

insert into dept_loc(dept_id) values(10);
insert into dept_loc values(20, default);
insert into dept_loc values(30, null);
select * from dept_loc;


--alter�� ���
alter table dept_loc
add (dept_name varchar2(20));
alter table dept_loc
add (dept_name2 varchar2(20));
alter table dept_loc
add (dept_name3 varchar2(20));

--ũ�� ����
alter table dept_loc
modify (dept_name verchar2(30));

--����
alter table dept_loc
drop column dept_name;

desc dept_loc;

--�÷� ������ ����
--unused�� ����ϸ� ���� ��ó�� ���)
alter table dept_loc
set unused (dept_name);

alter table dept_loc
set unused (dept_name2);

alter table dept_loc
set unused (dept_name3);

--set unused ���� �� ���� ����
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

-- emp : employees�� ����
-- emp2 : �μ� 80����, ��� ����� �̸��� aaa, bbb


--Merge��
--emp�� emp2 ��ġ�� emp2�� ���� ���� insert
--emp, emp2 ���ʿ� ���� ������ ���� ���� ������ update(����)

merge into emp2 e2
using emp e
on(e2.employee_id = e.employee_id)
when matched then 
update set
    e2.first_name = e.first_name,
    e2.last_name = e.last_name --��� Į���� ���� �ۼ�
    
when not matched then
insert values(e.employee_id, e.first_name)

--Ŀ�� : ������ ���̽� ���� �Ϸ� = ���� ������ �ٸ� user���Ե� ����Ǵ� �� -> Ŀ���� �Ǹ� ��� �ȵ�
--sql �����ϴ� app�� ����
--ddl ���� �ϳ� ����
--dcl ���� �ϳ� ����

select * from emp2;
commit;--DB������ �� �� Ŀ���� �ؾ� �ڹ� ���α׷������� Ȯ�� �����ϴ�(insert, rollback�� �� Ŀ���صΰ� Ȯ���ϰ� ����)
update emp2 set first_name='ccc' where employee_id = 145;
savepoint a
delete emp2 where employee_id = 145;
savepoint b
delete emp2 where first_name-'qqq', where employee_id=145;
rollback to a --a������ ����ض�
rollback
