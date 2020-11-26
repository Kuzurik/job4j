CREATE TABLE item(
   id serial primary key not null,
   name varchar(200),
   description varchar(200),
   time TIMESTAMP
);