select max(bbsno) from bbs;

CREATE SEQUENCE  seq_bbs
    START WITH 31
    INCREMENT BY 1;

INSERT INTO member2(id, passwd, mname, tel, email, zipcode,  
address1,address2, job, mdate, fname, grade) 
VALUES('admin', '1234', '������', '02-123-1234', 'admin@mail.com',  
'123-123','����� ���ʱ�', '�����͹̳�' ,'A01', sysdate, 'member.jpg', 'A'); 

CREATE TABLE member2 ( 
    id            VARCHAR(10)   NOT NULL, -- ���̵�, �ߺ� �ȵ�, ���ڵ带 �����ϴ� �÷�  
    passwd     VARCHAR(20)   NOT NULL, -- �н�����, ������ ���� 
    mname     VARCHAR(20)   NOT NULL, -- ����, �ѱ� 10�� ���� ���� 
    tel           VARCHAR(14)    NULL, -- ��ȭ��ȣ 
    email        VARCHAR(50)   NOT NULL UNIQUE, -- ���ڿ��� �ּ�, �ߺ� �ȵ� 
    zipcode     VARCHAR(7)     NULL, -- �����ȣ, 101-101 
    address1    VARCHAR(150)  NULL, -- �ּ� 1 
    address2    VARCHAR(50)   NULL, -- �ּ� 2 
    job            VARCHAR(20)  NOT NULL, -- ���� 
    mdate        DATE             NOT NULL, -- ������     
    fname        VARCHAR(50)  DEFAULT 'member.jpg', -- ȸ�� ����
    grade         CHAR(1)         DEFAULT 'H', -- �Ϲ�ȸ��: H, ����: Y, �մ�:Z 
    PRIMARY KEY (id)               -- �ѹ� ��ϵ� id�� �ߺ� �ȵ� 
);


--create 
INSERT INTO member2(id, passwd, mname, tel, email, zipcode,  
address1,address2, job, mdate, fname, grade) 
VALUES('user1', '1234', '������1', '123-1234', 'email1@mail.com',  
'123-123','��õ��', '������' ,'A01', sysdate, 'man.jpg', 'H');