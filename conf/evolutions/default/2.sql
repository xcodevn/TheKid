# -- Sample dataset

# --- !Ups
insert into user (id, email, password, fullname) values 
( 1, 'xcodevn@gmail.com', '$2a$10$EPDK0lG6B2T2Iw1MqybhO.gp9XNqOxQVrht3UHXmQGK5cazWpXRoS', 'Nguyễn Tấn Thông');

insert into user (id, email, password, fullname) values 
	( 2, 'tuidayne1991@gmail.com', '6367c48dd193d56ea7b0baad25b19455e529f5ee', 'Cao Tấn Thành');

insert into user (id, email, password, fullname) values 
( 3, 'dottngan1991@gmail.com', '6367c48dd193d56ea7b0baad25b19455e529f5ee', 'Đỗ Thị Tuyết Ngân');

# --- !Downs
delete from user;
