create database htqltuyensinh;

use htqltuyensinh;

create table admins (
	id bigint primary key auto_increment not null,
    code char(12) not null,
    name varchar(50) not null,
    birthday date not null,
    username varchar(50) not null,
    password varchar(50) not null,
    gender bit not null,
    phone char(11) not null,
    address varchar(250) not null,
    email varchar(100) not null,
    role bit not null,
    status bit not null
);

create table provinces (
	id bigint primary key auto_increment not null,
    code char(3) not null,
    name varchar(50) not null
);

create table schools (
	id bigint primary key auto_increment not null,
    code char(4) not null,
    name varchar(50) not null,
    provinces_id bigint not null
);

create table login_time (
	id bigint primary key auto_increment not null,
    admins_id bigint not null,
    start timestamp not null,
    end timestamp not null,
    total_time float not null
);

create table status (
	id bigint primary key auto_increment not null,
    code char(4) not null,
    name varchar(50) not null
);

create table courses (
	id bigint primary key auto_increment not null,
    code varchar(10) not null,
    name varchar(50) not null
);

create table users (
	id bigint primary key auto_increment not null,
    name varchar(100) not null,
    birthday date not null,
    job varchar(250) not null,
    provinces_id bigint not null,
    schools_id bigint not null,
    email varchar(100) null,
    phone char(11) null,
    father_phone char(11) null,
    mother_phone char(11) null,
    zalo char(11) null,
    facebook varchar(255) null,
    gather_description varchar(250) not null,
    status bit not null
);

create table graduate_result (
	id bigint primary key auto_increment not null,
    name varchar(100)
);

create table subjects (
	id bigint primary key auto_increment not null,
    code varchar(50) not null,
    name varchar(100) not null
);

create table favorite_subjects (
	id bigint primary key auto_increment not null,
    users_id bigint not null,
    subjects_id bigint not null,
    description varchar(250)
);

create table application_form (
	id bigint primary key auto_increment not null,
    courses_id bigint not null,
    notification_channel varchar(50),
    users_id bigint not null,
    graduate_result_id bigint not null,
    subjects_id bigint not null
);

create table files (
	id bigint primary key auto_increment not null,
    application_form_id bigint not null,
    file varchar(250) not null
);

create table notes (
	id bigint primary key auto_increment not null,
    admins_id bigint not null,
    description varchar(250) not null,
    time datetime not null,
    status bit not null
);

create table change_logs (
	id bigint primary key auto_increment not null,
    time datetime not null,
    admins_id bigint not null,
    description varchar(255)
);

create table assigns (
	id bigint primary key auto_increment not null,
    code varchar(10) not null,
    admins_id bigint not null,
    time datetime not null,
    quantity int,
    call_status int
);

create table assign_details (
	id bigint primary key auto_increment not null,
    assigns_id bigint not null,
    users_id bigint not null
);

create table calls (
	id bigint primary key auto_increment not null,
    users_id bigint not null,
    admins_id bigint not null,
    status_id bigint not null,
    status_detail varchar(250),
    times int not null,
    result varchar(250)
);
alter table schools add constraint fk_schools_provinces foreign key (provinces_id) references provinces(id);
alter table login_time add constraint fk_login_time_admins foreign key (admins_id) references admins(id);
alter table users add constraint fk_users_provinces foreign key (provinces_id) references provinces(id);
alter table users add constraint fk_users_schools foreign key (schools_id) references schools(id);
alter table favorite_subjects add constraint fk_favorite_subjects_users foreign key (users_id) references users(id);
alter table favorite_subjects add constraint fk_favorite_subjects_subjects foreign key (subjects_id) references subjects(id);
alter table application_form add constraint fk_application_form_courses foreign key (courses_id) references courses(id);
alter table application_form add constraint fk_application_form_users foreign key (users_id) references users(id);
alter table application_form add constraint fk_application_form_graduate_result foreign key (graduate_result_id) references graduate_result(id);
alter table application_form add constraint fk_application_form_subjects foreign key (subjects_id) references subjects(id);
alter table files add constraint fk_files_application_form foreign key (application_form_id) references application_form(id);
alter table notes add constraint fk_notes_admins foreign key (admins_id) references admins(id);
alter table change_logs add constraint fk_change_logs_admins foreign key (admins_id) references admins(id);
alter table assigns add constraint fk_assigns_admins foreign key (admins_id) references admins(id);
alter table assign_details add constraint fk_assign_details_users foreign key (users_id) references users(id);
alter table calls add constraint fk_calls_users foreign key (users_id) references users(id);
alter table calls add constraint fk_calls_admins foreign key (admins_id) references admins(id);
alter table calls add constraint fk_calls_status foreign key (status_id) references status(id);

