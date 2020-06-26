create table user_login(username varchar2(20) not null, password varchar(20) not null);

insert into USER_LOGIN values ('admin', 'admin');
insert into USER_LOGIN values ('hr', 'hr');
insert into USER_LOGIN values ('admin123', 'admin123');


select 1 from user_login where username='hr' and password='hr';
