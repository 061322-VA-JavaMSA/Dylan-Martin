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
values ('Jalen', '1234');

insert into employees (e_name, e_pass)
values ('Jaleel', '1234');

update users
set e_name = 'Jevon'
where employee_id = 1;

update users
set e_name = 'Jalen'
where employee_id = 2;

update users
set e_name = 'Jaleel'
where employee_id = 3;

alter table employees (e_name)
values ('Jevon'),
values ('Jalen'),
values ('Jaleel');

drop table if exists Managers cascade;

create table if not exists managers(
manager_id serial primary key
);

drop table if exists items cascade;

create table if not exists items(
item_id serial primary key,
item_name varchar(30) unique not null,
item_description varchar(120),
item_availability varchar(30) not null
);

drop table if exists offers cascade;

create table if not exists offers(
offer_id serial primary key,
requested_item_id integer references items(item_id),
offer_amount integer,
offer_status varchar(15),
customer_id integer references customers(customer_id)
);

update offers set offer_amount = ?, offer_status = ? where offer_id = ?;

drop table if exists ownedItems;

create table if not exists ownedItems(
owned_id serial primary key,
payed varchar (10),
o_id integer references offers(offer_id),
oi_id integer references items(item_id)
);



alter table offers
rename customer_id to cust_id;

update offers set offer_status = 'pending';

update items set item_availability = '1' where item_id  = '1';
update items set item_availability = '1' where item_id = '2';
update items set item_availability = '1' where item_id = '3';
update items set item_availability = '1' where item_id = '4';
update items set item_availability = '1' where item_id = '5';
update items set item_availability = '1' where item_id = '6';
update items set item_availability = '1' where item_id = '7';

alter table offers
alter column employee_id type integer,
alter column customer_id type integer;

alter table offers
alter column requested_item_id type integer;

alter table offers
rename item_id to requested_item_id;

select o.offer_id, o.offer_amount, o.offer_status, o.requested_item_id, i.item_name from offers o join items i on o.requested_item_id = i.item_id where requested_item_id = 4;
select o.offer_id, o.offer_amount, o.offer_status, o.requested_item_id, i.item_name from offers o join items i on o.requested_item_id = i.item_id where requested_item_id = 1;

drop table if exists payments cascade;

create table if not exists payments(
payment_id serial primary key,
payemnt_duration integer,
offer_id integer references offers(offer_id),
customer_id integer references customers(customer_id)
);

alter table items
alter column item_name type text,
alter column item_description type text,
alter column item_state type text;

alter table items 
rename column item_state
to item_availability;

update items set item_availability = '0' where item_id  = ?;

alter table items
alter column item_availability type integer using item_availability::integer;

insert into items (item_name, item_description, item_availability)
values ('3700x', 'AMD 8 core CPU', '3 Available');

insert into items (item_name, item_description, item_availability)
values ('RTX3070TI', 'Nvidia RTX Graphics card', '2 Available');

insert into items (item_name, item_description, item_availability)
values ('ROG Crosshair VIboard', 'Asus  for AMD CPUs', '3 Available');

insert into items (item_name, item_description, item_availability)
values ('Glacier D140 Distlate', 'Patercooling', '1 Available');

insert into items (item_name, item_description, item_availability)
values ('ASUS TUF GT501', 'Mid-Tower Case', '2 Available');

insert into items (item_name, item_description, item_availability)
values ('Samsung 980 Pro', '2TB NVME SSD', '1');

insert into items (item_name, item_description, item_availability)
values ('A12x25 Fan', 'Noctua case fan', '1');

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
set item_availability = '1'
where item_id = '1';

update items
set item_availability = '1'
where item_id = '2';

update items
set item_availability = '1'
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
set item_availability = '1'
where item_id = '4';

update items 
set item_name = 'Asus Tuf GT501'
where item_id = '5';

update items 
set item_description  = 'Mid-Tower Case'
where item_id = '5';

update items
set item_availability = '1'
where item_id = '5';


select o.offer_id, o.offer_amount, o.offer_status, o.item_id, i.item_name from offers o join items i on o.item_id = i.item_id where item_id = 1;

SELECT C.customer_id, C.firstname, C.lastname, O.offer_id, O.offer_amount, O.offer_status, I.item_name, I.item_description FROM offers O 
JOIN customers C on C.customer_id = O.cust_id
JOIN items I ON I.item_id = O.requested_item_id
WHERE 1=1 AND O.offer_status = 'accepted' AND C.customer_id = 1;


