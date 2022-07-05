alter database postgres set search_path to 'Project1';

drop table if exists ers_user_roles;

create table if not exists ers_user_roles(
ers_user_role_id serial primary key,
user_role varchar(10)
);

select last_value from ers_user_roles_ers_user_role_id_seq;

drop table if exists ers_users;

create table if not exists ers_users(
ers_user_id serial primary key,
ers_username varchar(20) unique not null,
ers_password varchar(15) not null,
ers_firstname varchar(30),
ers_lastname varchar(30),
ers_email varchar(100),
user_role_id integer references ers_user_roles(ers_user_role_id)
);

drop table if exists ers_reimbursement_status;

create table if not exists ers_reimbursement_status(
reimb_status_id serial primary key,
reimb_status varchar(10)
);

drop table if exists ers_reimbursement_type;

create table if not exists ers_reimbursement_type(
reimb_type_id serial primary key,
reimb_type varchar(10)
);

drop table if exists ers_reimbersement;

create table if not exists ers_reimbersement(
reimb_id serial primary key,
reimb_amount integer,
reimb_submitted timestamp,
reimb_resolved timestamp,
reimb_description varchar(250),
reimb_author integer references ers_users(ers_user_id),
reimb_resolver integer references ers_users(ers_user_id),
reimb_status_id integer references ers_reimbursement_status(reimb_status_id),
reimb_type_id integer references ers_reimbursement_type(reimb_type_id)
);