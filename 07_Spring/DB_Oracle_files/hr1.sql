CREATE TABLE bbs ( 
  bbsno    NUMBER(7)       NOT NULL,   -- �� �Ϸ� ��ȣ, -9999999 ~ +9999999 
  wname   VARCHAR(20)    NOT NULL,   -- �۾��� 
  title        VARCHAR(100)  NOT NULL,   -- ����(*) 
  content   VARCHAR(4000) NOT NULL,  -- �� ���� 
  passwd   VARCHAR(15)     NOT NULL,  -- ��� ��ȣ 
  viewcnt   NUMBER(5)       DEFAULT 0,  -- ��ȸ��, �⺻�� ��� 
  wdate     DATE               NOT NULL,  -- ��� ��¥, sysdate 
  grpno     NUMBER(7)       DEFAULT 0, -- �θ�� ��ȣ 
  indent    NUMBER(2)       DEFAULT 0,  -- �亯����,�亯�� ����
  ansnum  NUMBER(5)       DEFAULT 0,  -- �亯 ���� 
  PRIMARY KEY (bbsno)  
); 
