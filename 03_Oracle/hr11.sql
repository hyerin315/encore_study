--02/03
--트리거 : 어떤 동작을 할 때, 그 작업이 일어나기 전이나 후에 공통적으로 처리되어야하는 문장들을 구현하기 위해 사용
--        ex.새로운 사원이 들어와서 insert할때 마다 (검색과 상관없이) 같이 작업을 하고자 하는 걸 프로그래밍 하는 것
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
- 삽입
insert into emp values(306, 'aaa', 'bbb', 'emaila', '111.222.3333', 
sysdate, 'MK_MAN', 13000, null, 100, 20);
- 수정
update emp set salary=15000 where employee_id=306;
- 삭제
delete emp where employee_id=306; --삭제되었지만 기록은 남아있음


--------------------
--이클립스 멤버 추가 확인
select * from member;
