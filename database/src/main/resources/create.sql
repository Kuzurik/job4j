CREATE DATABASE java_course;

create table role(
	id int primary key,
	name varchar(20)
);

create table users(
	id int primary key,
	login varchar(20),
	pass varchar(20),
	role_id int references role(id)
);

create table rules(
	id int primary key,
	name varchar(20)
);

create table rules_and_role(
	id int primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table category(
	id int primary key,
	name varchar(20)
);

create table state(
	id int primary key,
	name varchar(20)
);

create table items(
	id int primary key,
	name varchar(20),
	users_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table attaches(
	id int primary key,
	name varchar(50),
	item_id int references items(id)
);

create table comments(
	id int primary key,
	text text,
	item_id int references items(id)
);

insert into role (id, name) values (1, 'role1'), (2, 'role2'), (3, 'role3');
insert into users (id, login, pass, role_id) values
    (1, 'user1@mail.com', 'kjtm4442', 1),
    (2, 'user2@mail.com', 'mk4ccn6jwe', 2),
    (3, 'user3@mail.com', 'kuzurik', 3);
insert into rules (id, name) values (1, 'rule1'), (2, 'rule2');
insert into rules_and_role (id, role_id, rules_id) values (1, 1, 1), (2, 3, 2);
insert into category (id, name) values (1, 'category1'), (2, 'category2'), (3, 'category3');
insert into state (id, name) values (1, 'stateLow'), (2, 'stateNormal'), (3, 'stateHigh');
insert into items (id, name, users_id, category_id, state_id) values
    (1, 'item1', 1, 2, 3),
    (2, 'item2', 3, 3, 2);
insert into attaches (id, name, item_id) values (1, 'att1', 1), (2, 'att2', 2);
insert into comments (id, text, item_id) values (1, 'commentText1', 1),(2, 'commentText2', 2);