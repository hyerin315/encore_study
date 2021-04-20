--02/02
--복합뷰랑 단일뷰를 나눌 필요는 없음 : 뷰는 그냥 읽기만 하자 (뷰를 통해서 insert를 할 필요가 없음)

--서브쿼리 = 인라인 뷰

--Top-N 분석
select rownum as rank, last_name, salary
from (select last_name, salary from employees
      order by salary DESC)
where ROWNUM <= 3;

