--02/01
--테이블 생성 이후에 제약조건 추가/삭제
create table t2(
col1 number,
col2 number,
col3 number
);

alter table t2
add primary key(col1); --제약조건 추가  SYS_C007054

alter table t2
modify col2 not null; -- not null 제약조건 추가  SYS_C007055

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
자바 jdbc 작업 순서
1. 빌드패스에 드라이버 등록(...External jar)
2. DB 커넥션 수립(DB에 로그인) -> 커넥션 객체 반환
3. SQL 실행 -> Statement, PreparedStatement 객체 생성 (두 개의 역할 똑같음)
   * Statement, PreparedStatement : 자바에서 SQL문을 인식 및 실행
4. 만약 검색이라면 ResultSet(검색 결과 담는 클래스) 객체 생성
   ResultSet(검색 결과 담는 클래스) 객체 생성
   ResultSet 객체에서 한 줄씩 읽어서 그 줄의 컬럼값들을 꺼내서 사용
5. 커넥션 객체 연결 끊음
*/

