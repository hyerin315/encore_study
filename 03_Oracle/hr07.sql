--02/01
--���̺� ���� ���Ŀ� �������� �߰�/����
create table t2(
col1 number,
col2 number,
col3 number
);

alter table t2
add primary key(col1); --�������� �߰�  SYS_C007054

alter table t2
modify col2 not null; -- not null �������� �߰�  SYS_C007055

alter table t2
drop CONSTRAINT SYS_C007054;

alter table t2
drop CONSTRAINT SYS_C007055;

select * from member;
select * from board;
select *from t2


drop table board;
create table board(
num number primary key,
writer varchar2(20) references member(id) on delete cascade,
w_date date,
title varchar2(50) not null,
content varchar2(100) not null
);

delete member where id = 'ccc';


-------------------------------------------------------------------------------
/*
�ڹ� jdbc �۾� ����
1. �����н��� ����̹� ���(...External jar)
2. DB Ŀ�ؼ� ����(DB�� �α���) -> Ŀ�ؼ� ��ü ��ȯ
3. SQL ���� -> Statement, PreparedStatement ��ü ���� (�� ���� ���� �Ȱ���)
   * Statement, PreparedStatement : �ڹٿ��� SQL���� �ν� �� ����
4. ���� �˻��̶�� ResultSet(�˻� ��� ��� Ŭ����) ��ü ����
   ResultSet(�˻� ��� ��� Ŭ����) ��ü ����
   ResultSet ��ü���� �� �پ� �о �� ���� �÷������� ������ ���
5. Ŀ�ؼ� ��ü ���� ����
*/

