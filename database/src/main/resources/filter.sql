CREATE TABLE type(
	id serial primary key,
	name text
);

CREATE TABLE product(
	id serial primary key,
	name text,
	type_id int references type(id),
	expired_date timestamp,
	price int,
	count int
);

insert into product (name, type_id, expired_date, price, count) values ('chedr', 1, '2020-08-31 06:30:00',200, 12);
insert into product (name, type_id, expired_date, price, count) values ('pork', 2, '2020-08-31 06:30:00', 100, 8);
insert into product (name, type_id, expired_date, price, count) values ('russian', 1, '2020-08-31 06:30:00',150, 5);
insert into product (name, type_id, expired_date, price, count) values ('belact', 3, '2020-08-31 06:30:00',120, 13);
insert into product (name, type_id, expired_date, price, count) values ('beef', 2, '2020-08-31 06:30:00', 130, 2);
insert into product (name, type_id, expired_date, price, count) values ('chiken', 2, '2020-08-31 06:30:00', 90, 6);
insert into product (name, type_id, expired_date, price, count) values ('amadeus', 1, '2020-08-31 06:30:00', 110, 8);
insert into product (name, type_id, expired_date, price, count) values ('blue', 1, '2020-08-31 06:30:00',190, 9);


select * from product as p where p.type_id = 1;
select * from product as p where p.name like 'beef';
select * from product as p
where p.expired_date between '2020-08-01 00:00:00' and '2020-08-31 23:59:59';
select * from product as p
where p.price = (Select max (price) from product);
select count(*) from product as p
where p.type_id = 1;
select * from product as p
where p.type_id = 1 or p.type_id = 3;
select * from product as p
where p.count < 10;
select u.name, c.name from product as u
inner join type as c on u.type_id = c.id;