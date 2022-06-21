--this is a comment

/*This is a 
multiline comment
*/

--create database mydb;

--create schema task_manager;
--drop schema task_manager;

/*
users		VARCHAR
id			SERIAL
email		VARCHAR
password	VARCHAR
*/

drop table if exists users;

create table if not exists users(
id serial primary key,
username varchar(30) unique not null check(length(username) > 2),
password varchar(30) not null
);

drop table if exists tasks;

create table if not exists tasks (
id serial primary key,
description text,
due_date date default current_date,
status varchar(15) default 'new', --whenever a record is created, value should
user_assigned_id integer references users(id)
);

/*alter table tasks (
description text,
due_date date,
status, varchar(15),
user_assigned integer
)*/

--many-to-one/one-to-many
create table teams (
id serial primary key,
name varchar(20)
);

create table players (
id serial primary key,
name varchar(20),
team_id integer references teams(id)
);

-- many to many

create table people(
id serial primary key,
name varchar(30)
);

create table friends(
friend1_id integer references people(id),
friend2_id integer references people(id),
primary key (friend1_id, friend2_id)
);

--insert
insert into people (name) values ('nikita');
insert into people (name) values ('zaki'), ('Erik');

insert into people (name) values ('Snake, eastern indigo');
insert into people (name) values ('Australian brush turkey');
insert into people (name) values ('Red-cheeked cordon bleu');
insert into people (name) values ('Mudskipper (unidentified)');
insert into people (name) values ('Sportive lemur');
insert into people (name) values ('Grey lourie');
insert into people (name) values ('Colobus, white-mantled');
insert into people (name) values ('Western lowland gorilla');
insert into people (name) values ('Stork, marabou');
insert into people (name) values ('Frilled lizard');

-- friendships

insert into friends(friend1_id, friend2_id) values(1,3), (1,5); 

update people set name = 'Bryan'; --no where clause? This will make everyone's name bryan in people
update people set name = 'Hatim' where id = 2;

--delete 
delete from people where name = 'zaki';
delete from people; -- this will delete all records in people



-----------------Assignment-----------------


drop table if exists Salestaff;

create table if not exists Salestaff (
Employee_id serial primary Key,
Sales_Person varchar(30),
Sales_Office integer references Sales_Office(id),
SO_street varchar(30),
SO_city varchar(30),
SO_state varchar(30),
SO_zip integer,
Age integer,
DoB date
);

drop table if exists Customers;

create table if not exists Customers(
Customer_id serial primary key,
Customer_Name varchar(30),
Sales_Person_id integer references Salestaff(Employee_id)
);

drop table if exists people;

create table if not exists people(
People_id serial primary key,
Name varchar(30),
age integer,
DOB date,
Customer boolean,
Employee boolean,
);