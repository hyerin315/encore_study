INSERT INTO bbs(bbsno, wname, title, content, passwd, wdate,grpno)  
VALUES((SELECT NVL(MAX(bbsno), 0) + 1 as bbsno FROM bbs), 
'�մ���', '����', '����', '123', sysdate,
(SELECT NVL(MAX(grpno), 0) + 1  FROM bbs)
);
 
select * from bbs;

SELECT bbsno, grpno, indent, ansnum, rownum
FROM bbs  
ORDER BY grpno DESC, ansnum ASC; 

SELECT bbsno, wname, title, viewcnt, wdate, grpno, 
indent, ansnum, rownum as r /* rownum�� �տ��� �о������ �߰� �ͺ��� ������ */
FROM ( 
      SELECT bbsno, wname, title, viewcnt, wdate, grpno,
      indent, ansnum
      FROM bbs  
      ORDER BY grpno DESC, ansnum ASC 
)
where rownum >= 6 and rownum <= 10;

SELECT bbsno, wname, title, viewcnt, wdate, grpno, 
indent, ansnum,  r 
From(
    SELECT bbsno, wname, title, viewcnt, wdate, grpno, 
    indent, ansnum, rownum as r
    FROM ( 
         SELECT bbsno, wname, title, viewcnt, wdate, grpno,
         indent, ansnum
         FROM bbs  
         ORDER BY grpno DESC, ansnum ASC
    ) 
)where r >= 3 and r <= 5; /* rownum�� r�̶�� ������ �ٲ� */
