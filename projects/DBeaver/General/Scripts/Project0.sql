-- this is a comment
/*
multiline
comment
naming convention in SQL is snake_case 
*/

--create database mydb;

create schema task_manager;
drop schema task_manager;

/*
Users
id			SERIAL
email		VARCHAR
password	VARCHAR
*/
drop table if exists users;
create table if not exists users(
id serial primary key,
username varchar(30) unique not null check(length(username) > 2),
password varchar(30) not null
--manager_id references users(id)
);

insert into users (username, password) values ('hcocking0', 'Gox1eyM1ph');
insert into users (username, password) values ('dvalenta1', 'GcYCYy4Q');
insert into users (username, password) values ('msargerson2', 'rN3ef1EzL');
insert into users (username, password) values ('jmoorey3', 'FZfFjGnS2L8N');
insert into users (username, password) values ('bfrancomb4', 'LpMu6k1');
insert into users (username, password) values ('jkahen5', 'GNgoHXs');
insert into users (username, password) values ('rblackster6', '4ZAhhFGDUQal');
insert into users (username, password) values ('ebyng7', 'Q2ujnRtXlAe7');
insert into users (username, password) values ('tbirkenshaw8', 'thIcitV');
insert into users (username, password) values ('jabele9', 'KcKuPU0lb');

/*
Tasks
id					SERIAL
description			TEXT
due_date			DATE
status				VARCHAR
user_assigned_id	INTEGER				 (FK)
*/
drop table if exists tasks;
create table tasks (
id serial primary key,
description text,
due_date date default current_date,
status varchar(15) default 'new', -- whenever a record is created, value should be "new"
user_assigned_id integer references users(id)
);

insert into tasks (description, user_assigned_id) values ('Networked encompassing complexity', 1);
insert into tasks (description, user_assigned_id) values ('Phased 4th generation internet solution', 2);
insert into tasks (description, user_assigned_id) values ('Down-sized zero administration standardization', 3);
insert into tasks (description, user_assigned_id) values ('Object-based multimedia core', 1);
insert into tasks (description, user_assigned_id) values ('Realigned didactic time-frame', 2);
insert into tasks (description, user_assigned_id) values ('Seamless fresh-thinking contingency', 3);
insert into tasks (description, user_assigned_id) values ('Front-line composite info-mediaries', 4);
insert into tasks (description, user_assigned_id) values ('Cross-group user-facing internet solution', 5);
insert into tasks (description, user_assigned_id) values ('Programmable intangible parallelism', 6);
insert into tasks (description, user_assigned_id) values ('Function-based even-keeled instruction set', 7);

-- many-to-one/one-to-many
drop table if exists teams cascade;
create table teams(
id serial primary key,
name varchar(20)
);

drop table if exists players;
create table players(
id serial primary key,
name varchar(20),
team_id integer references teams(id)
);

-- many-to-many
drop table if exists people cascade;
create table people(
id serial primary key,
name varchar(30)
);

drop table if exists friends;
create table friends(
	friend1_id integer references people(id),
	friend2_id integer references people(id),
	primary key (friend1_id, friend2_id)
);

-- insert 
insert into people (name) values ('Nikita');

insert into people (name) values ('Zaki'), ('Erik');

-- mockaroo data:
insert into people (name) values ('Blesbok');
insert into people (name) values ('Least chipmunk');
insert into people (name) values ('Lapwing, southern');
insert into people (name) values ('Pied cormorant');
insert into people (name) values ('Lizard, giant girdled');
insert into people (name) values ('Goose, andean');
insert into people (name) values ('Cockatoo, red-breasted');
insert into people (name) values ('Western patch-nosed snake');
insert into people (name) values ('Masked booby');
insert into people (name) values ('Jungle kangaroo');

-- friendships
insert into friends(friend1_id, friend2_id) values(1,3), (1,5);



-----------------Assignment-----------------



drop table if exists people1 cascade;

create table if not exists people1 (
People_id serial primary key,
Name varchar(30),
DOB date
);

drop table if exists Sales_Office1 cascade;

create table if not exists Sales_Office1 (
SO_id serial primary key,
SO_name varchar(30),
SO_street varchar(30),
SO_city varchar(30),
SO_state varchar(30),
SO_zip integer
);

drop table if exists Salestaff1 cascade;

create table if not exists Salestaff1 (
Employee_id serial primary Key,
People_id serial references people1(People_id),
SO_id serial references Sales_Office1(SO_id)
);

drop table if exists Customers1 cascade;

create table if not exists Customers1 (
Customer_id serial primary key,
Customer_Name varchar(30),
Sales_Person_id serial references Salestaff1(Employee_id)
);




-------Day 2-------------------



-- select 
select * from users; -- * indicates all of the fields/columns
select id, username from users;

select * from tasks where user_assigned_id = 1; -- where can filter by a condition 
select * from tasks where status = 'new';
select * from tasks where due_date != current_date;
select * from tasks where due_date > current_date;

-- statement to retrieve information for login?
/*
user gives uname = 'kev', pw = 'pass'
*/
select * from users where username = 'jmoorey3';

select * from tasks where due_date = current_date order by id asc;
select * from tasks where due_date = current_date order by id desc limit 5;
select * from tasks where due_date = current_date order by id asc limit 5 offset 5; -- pagination
select * from users where id = 3;

-- Scalar vs Aggregate function
select upper(username) from users; -- record based
select count(*) from tasks;
select user_assigned_id, count(user_assigned_id)
from tasks 
group by user_assigned_id
having count(user_assigned_id) = 2; -- group by allows us to group data by a condition for aggregate functions

select t.id, t.description, t.due_date, t.status, u.id as user_id, u.username 
from tasks t
join users u
on t.user_assigned_id = u.id;


select * from users where id = 1;
select * from users;
select * from users where username  = 'jmoorey3';
insert into users (username, password) values('kev','pass');


----------Day 4-------------

--Scalar

select username from users;
select upper(username) from users;
select length(username) from users;

--Aggregate

select * from users;
select count(*) from users;

-- Count number of tasks per user
-- Count number of new tasks

select * from tasks;
select count(*) from tasks where user_assigned_id = 1;
select count(*) from tasks where user_assigned_id = 2;
select user_assigned_id, count(user_assigned_id) from tasks t group by user_assigned_id;

select user_assigned_id, count(*) 
from tasks t 
-- where clause has to be before aggregation
group by user_assigned_id
having count(*) > 1;

select status, count(status) from tasks group by status; 

-- This bit is extra
explain verbose select * from tasks t join users u on u.id = t.user_assigned_id;



-------------Project0 Scripts--------------------


drop table if exists users;

create table if not exists users(
id serial primary key,
firstname varchar(30),
lastname varchar(30),
username varchar(30) unique not null check(length(username) > 2),
password varchar(30) not null
);



drop table if exists items;

create table if not exists items(
item_id serial primary key,
item_name varchar(30) unique not null,
item_description varchar(120),
item_state varchar(30) not null
);


drop table if exists offers;

create table if not exists offers(
offer_id serial primary key,
offer_ammount integer,
offer_status varchar(15)
);

drop table if exists payments;

create table if not exists payments(
payment_id serial primary key,
payment_amount integer,
payemnt_duration integer
);

drop table if exists customers;

create table if not exists customers(
customer_id serial primary key,
id serial references users(id),
item_id serial references items(item_id),
offer_id serial references offers(offer_id),
payment_id serial references payments(payment_id)
);

drop table if exists employees;

create table if not exists employees(
employee_id serial primary key,
id serial references users(id),
item_id serial references items(item_id),
offer_id serial references offers(offer_id)
);
drop table if exists Managers;

create table if not exists managers(
manager_id serial primary key,
id serial references users(id),
employee_id serial references employees(employee_id)
);

alter table items
alter column item_name type text,
alter column item_description type text,
alter column item_state type text;

insert into items (item_name, item_description, item_state)
values ('3700x', 'AMD 8 core CPU', '3 Available');

insert into items (item_name, item_description, item_state)
values ('RTX3070TI', 'Nvidia RTX Graphics card', '2 Available');

insert into items (item_name, item_description, item_state)
values ('ROG Crosshair VIII X570 Motherboard', 'Asus X570 motherboard for AMD CPUs', '3 Available');

insert into items (item_name, item_description, item_state)
values ('Glacier D140 Distrobution Plate', 'Phanteks distrobution plate for watercooling', '1 Available');

insert into items (item_name, item_description, item_state)
values ('ASUS TUF GT501', 'Mid-Tower Case', '2 Available');

