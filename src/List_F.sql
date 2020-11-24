create table List_F(

name varchar(50),
day_start date,
day_last date,
loc varchar(50), 
theme varchar(50),
num number,
n_num number,
reply varchar(1000),
money number
);

insert into List_F values('Welcome','2020-08-02','2020-08-04','아시아문화전당','플리마켓',5,1,'상품이 다양하면 좋겠어요',0);
insert into List_F values('Jazz Festival','2020-08-03','2020-08-08','CLA STUDIO','축제',30,1,'',0); 
insert into List_F values('과학스쿨','2020-08-09','2020-09-15','CLA STUDIO','축제',20,5,'',0);
insert into List_F values('광주빛고을 독서마라톤','2020-08-12','2020-08-20','하루에','축제',10,8,'',0); 
insert into List_F values('독립영화 클래식1','2020-08-15','2020-08-30','다온소셜트리 세미나실','축제',15,0,'',0); 
insert into List_F values('우제길 개인전','2020-08-20','2020-09-20','상무지구 랄라짐','축제',20,1,'',0); 
insert into List_F values('광주과학관 정월대보름 공개관측','2020-08-06','2020-08-11','천칭자리 공연장','축제',20,5,'',0); 
insert into List_F values('독립영화관 기획전','2020-08-25','2020-09-07','SIXBOX','축제',30,4,'',0); 
insert into List_F values('Welcome','2020-08-02','2020-08-04','아시아문화전당','플리마켓',5,1,'상품이 다양하면 좋겠어요',0);
insert into List_F values('Jazz Festival','2020-08-03','2020-08-08','CLA STUDIO','축제',30,1,'',0); 
insert into List_F values('과학스쿨','2020-08-09','2020-09-15','CLA STUDIO','축제',20,5,'',0);
insert into List_F values('광주빛고을 독서마라톤','2020-08-12','2020-08-20','하루에','축제',10,8,'',0); 
insert into List_F values('독립영화 클래식1','2020-08-15','2020-08-30','다온소셜트리 세미나실','축제',15,0,'',0); 

select * from List_F 
drop table List_F
