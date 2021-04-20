--02/01
/* 
- �������� : �������� ���Ἲ�� ���� ���������� �޾��ִ� ��
not null : null ���Բ�
unique : �ߺ� �Ұ� (ex. ���̵� �ߺ� �Ұ�) 
         Q.�÷��� �ε����� ����� ����? 
         �˻��� �����ϴ� �÷� + ���� �� ������� �ʴ� �÷��̶�� �ε��� ���(���� ���ٸ�)
         �����ϸ� ���� �϶�, ���� �ʹ� ������ �Ⱦ��� �� ����
primary key : not null + unique
foreign key : ���� ���� ������ ���� �ٸ� ���̺� �����ϴ� Ű (����Ű, �ܷ�Ű)
check : ����� ���� Ű
*/

create table t1(
coll varchar2(10) primary key,
col2 varchar2(10) not null,
col3 varchar2(10) unique
);
/*
- ���ǥ��
create table t1(
coll varchar2(10) primary key,
col2 varchar2(10) not null,
col3 varchar2(10) reference departments(department_id)
                  + ex. ���⿡ on delete cascade�� ���ϸ� �� ����ڰ� Ż���Ҷ�, ��� �Խñ� ����
);
*/

insert into t1 values(null, 'aaa', 'aaa');--���� ���� ���� : col1 = primary key - �ߺ�, null�̸� ����
insert into t1 values('aaa', 'aaa', 'aaa');--���������� ����
insert into t1 values('aaa', 'aaa', 'aaa');--���� : col1, col3 �ߺ�
insert into t1 (col1, col3) values('bbb', 'bbb');--���� : col2�� null

/*
���� �������� : ������ �ʿ� ����
top&�м� : ž�غм��� ���� ���� �ʿ�

- check ��������
�ýð��� �ٲ�� �÷����� ����ϸ� �ȵȴ�(rownum, nextval ��)
*/

--���̺� ������� check���� ����
drop table t1;
create table t1(
col1 number,
col2 number,
constraint t1_col1_check check(col1>0),
constraint t1_col2_check check(col2>10)
);

insert into t1 values(-1, 12);
insert into t1 values(1, 5);
insert into t1 values(1, 12);--�� �ٸ� ���� �������� ���Ե�

/*
- �������� ����
1. ����, ������ ���������� ������ �ȵ�
2. ����Ǿ� �ִ� ���������� �����ϰ� ������ drop primary key cascade �߰�

- �������� ��Ȱ��ȭ
disable constraint ~~ (cascade�� �ٿ��� �ǰ� �Ⱥٿ��� �ǰ�)
*/


