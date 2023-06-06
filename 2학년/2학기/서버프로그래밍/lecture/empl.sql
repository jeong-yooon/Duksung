/* ���ڵ�--> 1. SQL ��ũ��Ʈ ���� �� 2. �޸������� ���� UTF-8�� ���� */
/* 3. �����е�� ���� �ؽ�Ʈ�� ���� */
drop database if exists empldb;
create database empldb;
use empldb;
drop table if exists employee;
create table employee
(emplid integer unsigned not null primary key,
 name char(10) not null,
 address varchar(50),
 ssn char(13) not null
);

drop table if exists job;
create table job
(jobid integer unsigned not null primary key,
 jobtitle varchar(20) not null,
 skillcode char(5),
 dept varchar(20) not null
);

drop table if exists assignment;
create table assignment
(emplid integer unsigned not null,
 jobid integer unsigned not null,
 startdate date not null,
 termdate date,
 
 primary key(emplid, jobid)
);

insert into employee
values(15, '������', '���� ���α�', '12345678');

insert into employee
values(70, '������', '���� �߰赿', '34323424');

insert into employee
values(34, '����ȣ', '��⵵ �д�', '43423434');

insert into employee
values(77, '�Ӿ��', '���� ������', '98766789');

insert into employee
values(79, '������', '��⵵ �ϻ�', '43215678');

insert into employee
values(88, '������', '���� ��ġ��', '55343434');


insert into job
values(25, '��', 't5', '�λ��');

insert into job
values(26, '��', 't6', '�渮��');

insert into job
values(5, '��������', 'fm3', '������');

insert into job
values(1, '����', 'k1', '�ӿ�');

insert into job
values(10, '����', 'p1', '�λ��');

insert into job
values(11, '����', 'g1', '�λ��');

insert into job
values(6, '����', 'p2', '������');

insert into job
values(24, '���', 't7', '�渮��');

insert into job
values(30, '����', 's8', '������');

insert into job
values(29, '����', 't1', '������');


insert into assignment
values(34, 25, '1999-03-01', '2001-04-30');

insert into assignment
values(70, 5, '2002-10-01', '2008-04-30');

insert into assignment
values(70, 6, '2008-05-01', null);

insert into assignment
values(34, 26, '2001-05-01', '2005-06-30');

insert into assignment
values(34, 24, '2005-07-01', null);

insert into assignment
values(15, 1, '2001-05-01', null);

insert into assignment
values(77, 25, '2001-05-01', '2003-12-31');

insert into assignment
values(77, 11, '2004-01-01', '2008-12-31');

insert into assignment
values(77, 10, '2009-01-01', null);

insert into assignment
values(79, 24, '2012-03-01', '2013-02-28');

insert into assignment
values(79, 30, '2013-03-01', null);

insert into assignment
values(88, 29, '2015-01-01', null);
