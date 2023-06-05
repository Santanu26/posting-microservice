
create database if not exists post_db;
use post_db;
CREATE TABLE IF NOT EXISTS post (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  author_id BIGINT NOT NULL,
  text_of_post VARCHAR(255) NOT NULL,
  posted_at DATE NOT NULL
);
insert into post(author_id, text_of_post, posted_at) values (1,'Hi this post service', '2023-04-25');
insert into post(author_id, text_of_post, posted_at) values (2,'Hi this post service from user 2', '2023-04-25');