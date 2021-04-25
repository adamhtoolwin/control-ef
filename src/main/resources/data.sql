-- Roles --
insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_USER');

-- admin user --
insert into user_account (username, password, active, email) values ('admin', '$2a$10$otMn8Xre2SYZm.cZwa4q8e7hq3Y7/gkGoD9FOMvVmRvPr75p3POLm', true, 'admin@ait.asia');
insert into user_account_roles (users_id, roles_id) values (1, 1);

-- normal user -- 
insert into user_account (username, password, active, email) values ('john', '$2a$10$otMn8Xre2SYZm.cZwa4q8e7hq3Y7/gkGoD9FOMvVmRvPr75p3POLm', true, 'user@ait.asia');
insert into user_account_roles (users_id, roles_id) values (2, 2);

insert into video (id, lecturer, title, keyword, upload_date, user_id) values ('ArPaAX_PhIs', 'Andrew Ng', 'Convolutional Neural Networks', 'Machine Learning', '2019-12-12', 1);
insert into video (id, lecturer, title, keyword, upload_date, user_id) values ('XuD4C8vJzEQ', 'Matthew N. Dailey', 'Edge Detection Examples', 'Computer Vision', '2020-12-12', 1);
insert into video (id, lecturer, title, keyword, upload_date, user_id) values ('am36dePheDc', 'Chaklam Silpasuwanchai', 'OST Tamil', 'Music', '2020-10-10', 1);

insert into transcript (start_time, end_time, content, video_id) values (15965, 18190, 'In Vision systems D, this', 'am36dePheDc');
insert into transcript (start_time, end_time, content, video_id) values (18000, 20000, 'Machine learning ipsum', 'ArPaAX_PhIs');
insert into transcript (start_time, end_time, content, video_id) values (21000, 25000, 'loren machine learning ipsum', 'ArPaAX_PhIs');
insert into transcript (start_time, end_time, content, video_id) values (26000, 29000, 'Loren machine learning', 'XuD4C8vJzEQ');
insert into transcript (start_time, end_time, content, video_id) values (30000, 40000, 'Computer vision learning', 'XuD4C8vJzEQ');

