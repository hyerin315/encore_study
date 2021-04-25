select * from bbs;

alter table bbs
add( filename varchar(50),
     filesize number(7) default 0);