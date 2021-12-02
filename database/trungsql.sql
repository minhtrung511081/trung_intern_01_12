create database springboot;
use springboot;
describe student;
drop table  khoa;
select * from student;
select * from college;
describe college;
insert into college(name,code) value ("Công nghệ thông tin và truyền thông", "cntt&tt");


insert into role(code,name) values('ADMIN','Quản trị');
insert into role(code,name) values('USER','Người dùng');

insert into account(username,password,fullname,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','trương tùng lâm',1);
insert into account(username,password,fullname,status)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn A',1);
insert into account(username,password,fullname,status)
values('nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn B',1);
insert into account(username,password,fullname,status) 
values('trung','$2a$10$Fng8hWvsBJuO9Uh35aDEHeLkF7Olnj7lImnJs0LXQgfYBz6f1RAMy','võ minh trung',1);
insert into account(username,password,fullname,status) 
values('user','$2a$10$9Ca2x6SbK4PyPp9wCIUO/e6Q5F17FRLD0kdmTv8RDrGqT7VF2xlyq','i am user',1);
INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,2);
INSERT INTO user_role(userid,roleid) VALUES (3,2);
INSERT INTO user_role(userid,roleid) VALUES (4,1);
INSERT INTO user_role(userid,roleid) VALUES (5,2);
select * from account where username='admin';
select * from role;
select * from user_role;
select * from account;