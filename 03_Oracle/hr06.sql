--02/01
--자바의 vo역할을 sql 테이블이 함
/*
- 게시판 생성
1. 글 작성(로그인 상태)
2. 글 목록보기
3. 글 상세내용보기
4. 글 수정
5. 글 삭제
6. 글 번호로 검색
7. 글작성자로 검색
8. 글 제목으로 검색

- 회원
1. 회원가입
2. 로그인
3. 내 정보 수정
4. 로그아웃
5. 탈퇴
*/

--회원 테이블 : member
create table member(
id varchar2(20) primary key, --필수, 대표값
pwd varchar2(20) not null, --필수
name varchar2(20) not null, --필수
email varchar2(20) not null --필수
);

--게시판 테이블 : board
create table board(
num number primary key, --대표값, 자동생성(시퀀스)
writer varchar2(20) references member(id), --회원 id 참조(글 쓴 id 삭제 불가능)
w_date date,
title varchar2(50) not null, --필수
content varchar2(100) not null
);

-- 1) 회원쪽
--3명 회원가입
insert into member values('aaa', '111', 'aaa', 'aaa@email.com');
insert into member values('bbb', '111', 'bbb', 'bbb@email.com');
insert into member values('ccc', '111', 'ccc', 'ccc@email.com');

/*
- 로그인
id로 검색
1. 검색결과 없음(없는 id)
2. 검색결과 있음(입력받은 pwd와 pwd 칼럼의 값과 같은지 비교하여 같으면 로그인 성공, 아니면 잘못된 pwd)
--> 입력, 로그인 성공/실패는 자바에서 처리
*/
select * from member where id='aaa';
select * from member where id='bbb';
select * from member where id='ccc';

--내 정보 보기(로그인 상태 : 웹 - 세션정보로 확인 / pc 앱 - static 변수에 로그인 id 저장)
select * from member where id='aaa';

--내 정보 수정(로그인 상태) : pwd만 수정
update member set pwd='new_pwd' where id='aaa';

--로그아웃 : 세션에서 처리, db는 할 게 없음

--탈퇴 : db에서 삭제
delete from member where id='aaa';

--2)게시판쪽
--글쓰기 : 제목, 내용 입력받아 insert,
--        날짜, 글 번호는 자동생성
--        (sequence : 자동으로 번호 생성하여 반환(ex. 1,2,3...) / MySQL에서는 테이블 생성할때 auto 사용,
--        현재 날짜 : sysdate)
insert into board values(seq_board.nextval, 'aaa', sysdate, 'title1', 'content1');
insert into board values(seq_board.nextval, 'aaa', sysdate, 'title2', 'content2');
insert into board values(seq_board.nextval, 'aaa', sysdate, 'title3', 'content3');
insert into board values(seq_board.nextval, 'bbb', sysdate, 'title4', 'content4');

--글 번호 자동생성 (sequence: 자동으로 번호 생성하여 반환. 1, 2, 3)
create sequence seq_board;
select seq_board.nextval from dual; -- 다음 숫자 생성
select seq_board.currval from dual; --현재 시퀀스 값 검색

--글 목록 : 글 전체검색
select * from board; --번호가 2,3인 이유는 아까 1번을 샘플 런 했을 때 실행되었기 때문

--글 상세내용 보기
select * from board where num = 4;

--글 수정 : num, title, content의 새 내용 입력받아 수정, 로그인한 사람의 글만 수정 가능(자신의 계정 글만 수정 가능)
update board set title = 'new_title', content = 'new content', w_date = sysdate where num = 3;

--글 삭제 : num 글 삭제, 로그인한 사람의 글만 삭제 가능
delete from board where num = 4;

--글 작성자로 검색
select * from board where writer = 'aaa';

--글 제목으로 검색
select * from board where title like '%new%';
select * from board where title like '%tit%';

--aaa 탈퇴
delete from member where id = 'aaa'; -- 오류나는 이유 : aaa를 글 작성할 때 참조하기 때문에
delete from member where id = 'ccc'; -- 삭제 가능 : 글을 하나도 안써서 참조하는 줄이 없으므로 삭제됨
select * from member;
--방법 1. 모든 게시글 지우고 삭제
delete board where writer = 'aaa'; -- aaa가 쓴 글 모두 삭제, member 테이블에 aaa를 참조하는 모든 줄 삭제
delete from member where id = 'aaa'; 
--방법 2. 회원 삭제시 모두 삭제
drop table board; 
create table board(
num number primary key, --대표값, 자동생성(시퀀스)
writer varchar2(20) references member(id) on delete cascade, --회원 id 참조(id 삭제시 모두 삭제)
w_date date,
title varchar2(50) not null,
content varchar2(100) not null
);

--방법 2. 실행 잘 되는 지 확인
--bbb 회원가입
insert into member values('bbb', '111', 'nameb', 'bbb@email.com');
--bbb 글 작성
insert into board values(seq_board.nextval, 'bbb', sysdate, 'title4', 'content4');
select * from board; --목록보기

delete member where id = 'bbb'; --삭제 가능(회원 삭제시 모두 삭제)
select * from member; --멤버 확인







