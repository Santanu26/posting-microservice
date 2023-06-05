

create database if not exists user_db;
use user_db;
create table if not exists user (
    id bigint primary key auto_increment,
    username varchar(255) not null,
    amount varchar(255) not null,
    amount_of_posts varchar(255) not null
  );
insert into user(username, amount, amount_of_posts) values ('John Doe','100','0');
insert into user(username, amount, amount_of_posts) values ('santanu','1000','0');
insert into user(username, amount, amount_of_posts) values ('Lucas','1000','0');
insert into user(username, amount, amount_of_posts) values ('Mariuz','2321','0');
insert into user(username, amount, amount_of_posts) values ('Alax','1000','0');
insert into user(username, amount, amount_of_posts) values ('Nitu','2342','0');
insert into user(username, amount, amount_of_posts) values ('William','1234','0');


