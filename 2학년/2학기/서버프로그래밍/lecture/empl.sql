/* 인코딩--> 1. SQL 스크립트 저장 후 2. 메모장으로 열어 UTF-8로 저장 */
/* 3. 워드패드로 열어 텍스트로 저장 */
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
values(15, '음두헌', '서울 종로구', '12345678');

insert into employee
values(70, '강남희', '서울 중계동', '34323424');

insert into employee
values(34, '정원호', '경기도 분당', '43423434');

insert into employee
values(77, '임양미', '서울 도봉구', '98766789');

insert into employee
values(79, '박태정', '경기도 일산', '43215678');

insert into employee
values(88, '송현주', '서울 대치동', '55343434');


insert into job
values(25, '비서', 't5', '인사부');

insert into job
values(26, '비서', 't6', '경리부');

insert into job
values(5, '매장주임', 'fm3', '영업부');

insert into job
values(1, '사장', 'k1', '임원');

insert into job
values(10, '부장', 'p1', '인사부');

insert into job
values(11, '과장', 'g1', '인사부');

insert into job
values(6, '부장', 'p2', '영업부');

insert into job
values(24, '사원', 't7', '경리부');

insert into job
values(30, '차장', 's8', '영업부');

insert into job
values(29, '과장', 't1', '영업부');


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
