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

insert into List_F values('Welcome','2020-08-02','2020-08-04','�ƽþƹ�ȭ����','�ø�����',5,1,'��ǰ�� �پ��ϸ� ���ھ��',0);
insert into List_F values('Jazz Festival','2020-08-03','2020-08-08','CLA STUDIO','����',30,1,'',0); 
insert into List_F values('���н���','2020-08-09','2020-09-15','CLA STUDIO','����',20,5,'',0);
insert into List_F values('���ֺ����� ����������','2020-08-12','2020-08-20','�Ϸ翡','����',10,8,'',0); 
insert into List_F values('������ȭ Ŭ����1','2020-08-15','2020-08-30','�ٿ¼Ҽ�Ʈ�� ���̳���','����',15,0,'',0); 
insert into List_F values('������ ������','2020-08-20','2020-09-20','������ ������','����',20,1,'',0); 
insert into List_F values('���ְ��а� �����뺸�� ��������','2020-08-06','2020-08-11','õĪ�ڸ� ������','����',20,5,'',0); 
insert into List_F values('������ȭ�� ��ȹ��','2020-08-25','2020-09-07','SIXBOX','����',30,4,'',0); 
insert into List_F values('Welcome','2020-08-02','2020-08-04','�ƽþƹ�ȭ����','�ø�����',5,1,'��ǰ�� �پ��ϸ� ���ھ��',0);
insert into List_F values('Jazz Festival','2020-08-03','2020-08-08','CLA STUDIO','����',30,1,'',0); 
insert into List_F values('���н���','2020-08-09','2020-09-15','CLA STUDIO','����',20,5,'',0);
insert into List_F values('���ֺ����� ����������','2020-08-12','2020-08-20','�Ϸ翡','����',10,8,'',0); 
insert into List_F values('������ȭ Ŭ����1','2020-08-15','2020-08-30','�ٿ¼Ҽ�Ʈ�� ���̳���','����',15,0,'',0); 

select * from List_F 
drop table List_F
