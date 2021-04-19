--02/02
--PLSQL
set serveroutput on

declare -- ���� ���� : ���� �̸� + Ÿ��
   vename employees.last_name%type;
   vempno employees.employee_id%type;
   vjob_id employees.job_id%type;
   vdeptname departments.department_name%type;
begin --���࿡ ���õ� �κ�
   select employee_id, last_name, job_id, department_name
   into vempno, vename, vjob_id, vdeptname
   from employees e, departments d
   where e.department_id=d.department_id
   and employee_id=145;
   -- PLSQL���� �����ϴ� ȭ�� ��� �Լ�
   DBMS_OUTPUT.PUT_LINE('emp no:' ||  vempno);
   DBMS_OUTPUT.PUT_LINE('name:' ||  vename);
   DBMS_OUTPUT.PUT_LINE('job:' ||  vjob_id);
   DBMS_OUTPUT.PUT_LINE('department:' ||  vdeptname);
end;
/ --���ν����� ��


declare
   vsalary employees.salary%type;
   vcomm employees.commission_pct%type;
   vann number(15,2);
   venum employees.employee_id%type;
begin
   venum := 145;
   select salary, commission_pct 
   into vsalary, vcomm
   from employees
   where employee_id=venum;
   if(vcomm is null)
   then vann:=vsalary*12;
   else
   vann:=vsalary*12+(vsalary*12*vcomm);
   end if;
   DBMS_OUTPUT.PUT_LINE('�� ��:'||vann);
   end;
   /
   
declare
        vename employees.last_name%type;
        venum employees.employee_id%type;
    begin
        venum:=100;
        loop
            select last_name into vename from employees 
            where employee_id=venum;
            if(vename is not null)
                then DBMS_OUTPUT.PUT_LINE(vename);
            end if;
            venum:=venum+1;
            if(venum>200)
                then exit;
            end if;
        end loop;
        
    end;
    /

declare
        vemp employees%rowtype;
        venum employees.employee_id%type;
    begin
            select * into vemp from employees 
            where employee_id=&venum;
            
            DBMS_OUTPUT.PUT_LINE(vemp.employee_id || ' / ' || 
            vemp.last_name || ' / ' ||vemp.job_id);    
            
    end;
    /   
    
declare
        dan number(1);
        x number:=1;
    begin
        dan:=&dan;        
        for x in 1..9 loop
            DBMS_OUTPUT.PUT_LINE(dan || ' * ' || x || ' = ' || dan*x);
        end loop; 
    end;
    /    

declare
    type ename_arr is table of employees.last_name%type
    index by binary_integer;
    type job_arr is table of employees.job_id%type
    index by binary_integer; --�ε��� Ÿ�� ���� : �츮�� ���� �ε����� ����Ÿ������ �ϰڴ�
    
    names ename_arr; --������ ���� Ÿ������ ���� ���� (�ڹٿ� �����)
    jobs job_arr;
    
    i binary_integer:=0; --����
    
begin
    for k in(select last_name, job_id from employees) loop
        i:=i+1;
        names(i):=k.last_name;
        jobs(i):=k.job_id;
    end loop;
    
    for j in 1..i loop
        DBMS_OUTPUT.PUT_LINE(names(j) || ' / ' || jobs(j));
    end loop;
end;
/

