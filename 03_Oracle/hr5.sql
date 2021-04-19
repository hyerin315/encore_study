--02/01
/* 
- 제약조건 : 데이터의 무결성을 위해 제약조건을 달아주는 것
not null : null 없게끔
unique : 중복 불가 (ex. 아이디 중복 불가) 
         Q.컬럼에 인덱스를 만드는 이유? 
         검색을 자주하는 컬럼 + 값이 잘 변경되지 않는 컬럼이라면 인덱스 사용(양이 적다면)
         남발하면 성능 하락, 행이 너무 많으면 안쓰는 게 나음
primary key : not null + unique
foreign key : 상세한 정보 참조를 위해 다른 테이블 참조하는 키 (참조키, 외래키)
check : 사용자 정의 키
*/

create table t1(
coll varchar2(10) primary key,
col2 varchar2(10) not null,
col3 varchar2(10) unique
);
/*
- 약식표현
create table t1(
coll varchar2(10) primary key,
col2 varchar2(10) not null,
col3 varchar2(10) reference departments(department_id)
                  + ex. 여기에 on delete cascade를 더하면 그 사용자가 탈퇴할때, 모든 게시글 삭제
);
*/

insert into t1 values(null, 'aaa', 'aaa');--에러 나는 이유 : col1 = primary key - 중복, null이면 에러
insert into t1 values('aaa', 'aaa', 'aaa');--정상적으로 삽입
insert into t1 values('aaa', 'aaa', 'aaa');--에러 : col1, col3 중복
insert into t1 (col1, col3) values('bbb', 'bbb');--에러 : col2가 null

/*
보통 서브쿼리 : 정렬할 필요 없음
top&분석 : 탑앤분석할 때는 정렬 필요

- check 제약조건
시시각각 바뀌는 컬럼에는 사용하면 안된다(rownum, nextval 등)
*/

--테이블 방식으로 check제약 조건
drop table t1;
create table t1(
col1 number,
col2 number,
constraint t1_col1_check check(col1>0),
constraint t1_col2_check check(col2>10)
);

insert into t1 values(-1, 12);
insert into t1 values(1, 5);
insert into t1 values(1, 12);--이 줄만 조건 만족으로 삽입됨

/*
- 제약조건 삭제
1. 생성, 삭제는 가능하지만 수정은 안됨
2. 연결되어 있는 제약조건을 삭제하고 싶으면 drop primary key cascade 추가

- 제약조건 비활성화
disable constraint ~~ (cascade는 붙여도 되고 안붙여도 되고)
*/


