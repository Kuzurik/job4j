CREATE TABLE body (
id serial primary key,
name varchar(20)
);

CREATE TABLE engine (
id serial primary key,
name varchar(20)
);

CREATE TABLE transmission (
id serial primary key,
name varchar(20)
);

CREATE TABLE car (
id serial primary key,
name varchar(20),
body_id int references body(id),
engine_id int references engine(id),
transmission_id int references transmission(id)
);

insert into body (name) values ('sedan');
insert into body (name) values ('hatchback');
insert into body (name) values ('pickup');
insert into body (name) values ('minivan');
insert into body (name) values ('SUV');

insert into engine (name) values ('diesel');
insert into engine (name) values ('petrol');
insert into engine (name) values ('gas');
insert into engine (name) values ('electric');

insert into transmission (name) values ('manual');
insert into transmission (name) values ('auto');
insert into transmission (name) values ('robot');
insert into transmission (name) values ('variable');

insert into car (name, body_id, engine_id, transmission_id) values ('audi a8', 1, 1, 3);
insert into car (name, body_id, engine_id, transmission_id) values ('passat b3', 2, 2, 1);
insert into car (name, body_id, engine_id, transmission_id) values ('grand cherokee', 3, 2, 2);
insert into car (name, body_id, engine_id, transmission_id) values ('mazda mvp', 4, 3, 3);
insert into car (name, body_id, engine_id, transmission_id) values ('mazda 6', 1, 2, 2);
insert into car (name, body_id, engine_id, transmission_id) values ('tundra', 3, 1, 1);

select c.name, b.name, e.name, t.name from car as c
left outer join body as b on c.body_id = b.id
left outer join engine as e on c.engine_id = e.id
left outer join transmission as t on c.transmission_id = t.id;

select b.name from car as c
right outer join body as b on c.body_id = b.id where c.id is null;

select e.name from car as c
right outer join engine as e on c.engine_id = e.id where c.id is null;

select t.name from transmission as t
left outer join car as c on c.transmission_id = t.id where c.id is null;