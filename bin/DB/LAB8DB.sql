--create database LAB8DB
--go
use LAB8DB
go

if OBJECT_ID('employee') is not null
drop table employee
go

if OBJECT_ID('detail') is not null
drop table detail
go

create table employee(
userId int not null,
name varchar(200) null
constraint pk_employee primary key (userId)
)
go

create table detail(
detailId int not null,
userId int not null,
addressName varchar (200),
phoneNumber int
constraint pk_detail primary key (detailId),
constraint fk_detail_employee foreign key (userId) references employee(userId)
)
go

insert into employee (userId,name) values (1,'Bang')
insert into employee (userId,name) values (2,'Pew')
insert into employee (userId,name) values (3,'Boom')
insert into employee (userId,name) values (4,'PiPi')

insert into detail (detailId,userId,addressName,phoneNumber) values (1,1,'Ha Noi',01664424111)
insert into detail (detailId,userId,addressName,phoneNumber) values (2,2,'Ha Noi',0964523339)
insert into detail (detailId,userId,addressName,phoneNumber) values (3,3,'Ha Noi',0365321689)
insert into detail (detailId,userId,addressName,phoneNumber) values (4,4,'Ha Noi',0828288888)

insert into detail (detailId,userId,addressName,phoneNumber) values (5,4,'Ha Noi',01664424111)
insert into detail (detailId,userId,addressName,phoneNumber) values (6,3,'Ha Noi',0964523339)
insert into detail (detailId,userId,addressName,phoneNumber) values (7,2,'Ha Noi',0365321689)
insert into detail (detailId,userId,addressName,phoneNumber) values (8,1,'Ha Noi',0828288888)



