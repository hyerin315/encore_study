INSERT INTO bbs(bbsno, wname, title, content, passwd, wdate,grpno)  
VALUES((SELECT NVL(MAX(bbsno), 0) + 1 as bbsno FROM bbs), 
'왕눈이', '제목', '내용', '123', sysdate,
(SELECT NVL(MAX(grpno), 0) + 1  FROM bbs)
);
 
select * from bbs;

SELECT bbsno, grpno, indent, ansnum, rownum
FROM bbs  
ORDER BY grpno DESC, ansnum ASC; 

SELECT bbsno, wname, title, viewcnt, wdate, grpno, 
indent, ansnum, rownum as r /* rownum은 앞에껀 읽어오지만 중간 것부턴 못읽음 */
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
)where r >= 3 and r <= 5; /* rownum을 r이라는 값으로 바꿈 */
