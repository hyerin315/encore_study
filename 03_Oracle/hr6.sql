--02/01
--�ڹ��� vo������ sql ���̺��� ��
/*
- �Խ��� ����
1. �� �ۼ�(�α��� ����)
2. �� ��Ϻ���
3. �� �󼼳��뺸��
4. �� ����
5. �� ����
6. �� ��ȣ�� �˻�
7. ���ۼ��ڷ� �˻�
8. �� �������� �˻�

- ȸ��
1. ȸ������
2. �α���
3. �� ���� ����
4. �α׾ƿ�
5. Ż��
*/

--ȸ�� ���̺� : member
create table member(
id varchar2(20) primary key, --�ʼ�, ��ǥ��
pwd varchar2(20) not null, --�ʼ�
name varchar2(20) not null, --�ʼ�
email varchar2(20) not null --�ʼ�
);

--�Խ��� ���̺� : board
create table board(
num number primary key, --��ǥ��, �ڵ�����(������)
writer varchar2(20) references member(id), --ȸ�� id ����(�� �� id ���� �Ұ���)
w_date date,
title varchar2(50) not null, --�ʼ�
content varchar2(100) not null
);

-- 1) ȸ����
--3�� ȸ������
insert into member values('aaa', '111', 'aaa', 'aaa@email.com');
insert into member values('bbb', '111', 'bbb', 'bbb@email.com');
insert into member values('ccc', '111', 'ccc', 'ccc@email.com');

/*
- �α���
id�� �˻�
1. �˻���� ����(���� id)
2. �˻���� ����(�Է¹��� pwd�� pwd Į���� ���� ������ ���Ͽ� ������ �α��� ����, �ƴϸ� �߸��� pwd)
--> �Է�, �α��� ����/���д� �ڹٿ��� ó��
*/
select * from member where id='aaa';
select * from member where id='bbb';
select * from member where id='ccc';

--�� ���� ����(�α��� ���� : �� - ���������� Ȯ�� / pc �� - static ������ �α��� id ����)
select * from member where id='aaa';

--�� ���� ����(�α��� ����) : pwd�� ����
update member set pwd='new_pwd' where id='aaa';

--�α׾ƿ� : ���ǿ��� ó��, db�� �� �� ����

--Ż�� : db���� ����
delete from member where id='aaa';

--2)�Խ�����
--�۾��� : ����, ���� �Է¹޾� insert,
--        ��¥, �� ��ȣ�� �ڵ�����
--        (sequence : �ڵ����� ��ȣ �����Ͽ� ��ȯ(ex. 1,2,3...) / MySQL������ ���̺� �����Ҷ� auto ���,
--        ���� ��¥ : sysdate)
insert into board values(seq_board.nextval, 'aaa', sysdate, 'title1', 'content1');
insert into board values(seq_board.nextval, 'aaa', sysdate, 'title2', 'content2');
insert into board values(seq_board.nextval, 'aaa', sysdate, 'title3', 'content3');
insert into board values(seq_board.nextval, 'bbb', sysdate, 'title4', 'content4');

--�� ��ȣ �ڵ����� (sequence: �ڵ����� ��ȣ �����Ͽ� ��ȯ. 1, 2, 3)
create sequence seq_board;
select seq_board.nextval from dual; -- ���� ���� ����
select seq_board.currval from dual; --���� ������ �� �˻�

--�� ��� : �� ��ü�˻�
select * from board; --��ȣ�� 2,3�� ������ �Ʊ� 1���� ���� �� ���� �� ����Ǿ��� ����

--�� �󼼳��� ����
select * from board where num = 4;

--�� ���� : num, title, content�� �� ���� �Է¹޾� ����, �α����� ����� �۸� ���� ����(�ڽ��� ���� �۸� ���� ����)
update board set title = 'new_title', content = 'new content', w_date = sysdate where num = 3;

--�� ���� : num �� ����, �α����� ����� �۸� ���� ����
delete from board where num = 4;

--�� �ۼ��ڷ� �˻�
select * from board where writer = 'aaa';

--�� �������� �˻�
select * from board where title like '%new%';
select * from board where title like '%tit%';

--aaa Ż��
delete from member where id = 'aaa'; -- �������� ���� : aaa�� �� �ۼ��� �� �����ϱ� ������
delete from member where id = 'ccc'; -- ���� ���� : ���� �ϳ��� �ȽἭ �����ϴ� ���� �����Ƿ� ������
select * from member;
--��� 1. ��� �Խñ� ����� ����
delete board where writer = 'aaa'; -- aaa�� �� �� ��� ����, member ���̺� aaa�� �����ϴ� ��� �� ����
delete from member where id = 'aaa'; 
--��� 2. ȸ�� ������ ��� ����
drop table board; 
create table board(
num number primary key, --��ǥ��, �ڵ�����(������)
writer varchar2(20) references member(id) on delete cascade, --ȸ�� id ����(id ������ ��� ����)
w_date date,
title varchar2(50) not null,
content varchar2(100) not null
);

--��� 2. ���� �� �Ǵ� �� Ȯ��
--bbb ȸ������
insert into member values('bbb', '111', 'nameb', 'bbb@email.com');
--bbb �� �ۼ�
insert into board values(seq_board.nextval, 'bbb', sysdate, 'title4', 'content4');
select * from board; --��Ϻ���

delete member where id = 'bbb'; --���� ����(ȸ�� ������ ��� ����)
select * from member; --��� Ȯ��







