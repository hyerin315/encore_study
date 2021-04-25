alter table bbs
add(refnum number(7) default 0);

delete from bbs
where indent > 0;