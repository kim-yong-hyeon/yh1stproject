// 회원가입 테이블 생성

create table membership(
id varchar2(30), 
pw varchar2(30), 
sex varchar2(30), 
email varchar2(30), 
agegroup varchar2(30));


select * from membership;

// 데이터 추가
insert into membership values ('yh','1234', '남', 'dydgus1325@naver.com', '20대')
