-- ユーザー
drop table if exists users cascade;

create table users (
 id serial primary key
 , username varchar(100) not null
 , password text not null
 , role text not null
) ;


--ユーザー登録(pass:user)
insert into users(username, password, role) values('user', '$2a$10$WARwlwZL6Q.zKGj5XgfaHOhVAu6fYQbIbiuUms.KLf.zJtLvvaa8S', 'ROLE_USER');
--管理者登録(pass:admin)
insert into users(username, password, role) values('admin', '$2a$10$I7qghF06EmNYXlR76.TXKOKjhEBI2mA0NRlDOkVCTwf1XQRaHhmwu', 'ROLE_ADMIN');