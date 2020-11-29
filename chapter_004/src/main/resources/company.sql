CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'Epam');
insert into company(id, name) values (2, 'SoftTeco');
insert into company(id, name) values (5, 'JazzTeam');
insert into company(id, name) values (7, 'BGSoft');
insert into company(id, name) values (8, 'Softeq Development');

insert into person(id, name, company_id) values (1, 'Nikita', 5);
insert into person(id, name, company_id) values (2, 'Andrey', 5);
insert into person(id, name, company_id) values (3, 'Vlad', 2);
insert into person(id, name, company_id) values (4, 'Sergey', 2);
insert into person(id, name, company_id) values (5, 'Dmitriy', 7);
insert into person(id, name, company_id) values (6, 'Edgar', 1);
insert into person(id, name, company_id) values (7, 'Ksenia', 8);
insert into person(id, name, company_id) values (8, 'Petr', null);
insert into person(id, name, company_id) values (9, 'Vladimir', null);
insert into person(id, name, company_id) values (10, 'Kirill', 5);

select p.name from person as p
full outer join company c on p.company_id = c.id
where company_id != 5 or company_id is null;

select p.name, c.name from person as p
left join company c on p.company_id = c.id
where c.name is not null;

select c.name, count(p.id) as num
from company c left join person p on c.id = p.company_id
group by c.id
order by num desc
limit 1;