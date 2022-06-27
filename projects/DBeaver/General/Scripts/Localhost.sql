drop table if exists users cascade;

create table if not exists users(
id serial primary key,
username varchar(30) unique not null check(length(username) > 2),
password varchar(30) not null
);

drop table if exists customers cascade;

create table if not exists customers(
customer_id serial primary key,
firstname varchar(30),
lastname varchar(30),
id serial references users(id)
);


drop table if exists employees cascade;

create table if not exists employees(
employee_id serial primary key,
e_name varchar(30) not null,
e_pass varchar(15) not null
);

insert into employees (e_name, e_pass)
values ('Jevon', '1234');

insert into employees (e_name, e_pass)
values ('Jelan', '1234');

insert into employees (e_name, e_pass)
values ('Jaleel', '1234');

drop table if exists Managers cascade;

create table if not exists managers(
manager_id serial primary key,
id serial references users(id),
employee_id serial references employees(employee_id)
);

drop table if exists items cascade;

create table if not exists items(
item_id serial primary key,
item_name varchar(30) unique not null,
item_description varchar(120),
item_state varchar(30) not null
);

drop table if exists offers cascade;

create table if not exists offers(
offer_id serial primary key,
item_id serial references items(item_id),
offer_amount integer,
offer_status varchar(15),
employee_id serial references employees(employee_id),
customer_id serial references customers(customer_id)
);

drop table if exists payments cascade;

create table if not exists payments(
payment_id serial primary key,
offer_id serial references offers(offer_id),
payment_amount integer,
payemnt_duration integer
);


alter table items
alter column item_name type text,
alter column item_description type text,
alter column item_state type text;

alter table items
alter column item_name type varchar(30),
alter column item_description type varchar(30),
alter column item_state type varchar(30);

insert into items (item_name, item_description, item_state)
values ('3700x', 'AMD 8 core CPU', '3 Available');

insert into items (item_name, item_description, item_state)
values ('RTX3070TI', 'Nvidia RTX Graphics card', '2 Available');

insert into items (item_name, item_description, item_state)
values ('ROG Crosshair VIboard', 'Asus  for AMD CPUs', '3 Available');

insert into items (item_name, item_description, item_state)
values ('Glacier D140 Distlate', 'Patercooling', '1 Available');

insert into items (item_name, item_description, item_state)
values ('ASUS TUF GT501', 'Mid-Tower Case', '2 Available');

update users 
set firstname = 'Dylan'
where username = 'Dmartin';

update users 
set lastname = 'Martin'
where username = 'Dmartin';

update users 
set firstname = 'Erik'
where username = 'Eferri';

update users 
set lastname = 'Ferri'
where username = 'Eferri';

update items 
set item_name = 'Ryzen 7 3700x'
where item_id = '1';

update items 
set item_description  = 'AMD 8 core CPU'
where item_id = '1';

update items 
set item_name = 'RTX 3070 Ti'
where item_id = '2';

update items 
set item_description  = 'Nvidia RTX Graphics card'
where item_id = '2';

update items 
set item_name = 'ROG X570 Mobo'
where item_id = '3';

update items 
set item_description  = 'Asus AM4 Motherboard'
where item_id = '3';

update items 
set item_name = 'Glacier D140'
where item_id = '4';

update items 
set item_description  = 'Phanteks Distro Plate'
where item_id = '4';

update items 
set item_name = 'Asus Tuf GT501'
where item_id = '5';

update items 
set item_description  = 'Mid-Tower Case'
where item_id = '5';







