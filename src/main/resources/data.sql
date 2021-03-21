-- Roles --
insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_USER');

-- admin user --
insert into user_account (username, password, active, email) values ('admin', '$2a$10$otMn8Xre2SYZm.cZwa4q8e7hq3Y7/gkGoD9FOMvVmRvPr75p3POLm', true, 'admin@ait.asia');
insert into user_account_roles (users_id, roles_id) values (1, 1);

-- normal user -- 
insert into user_account (username, password, active, email) values ('john', '$2a$10$otMn8Xre2SYZm.cZwa4q8e7hq3Y7/gkGoD9FOMvVmRvPr75p3POLm', true, 'user@ait.asia');
insert into user_account_roles (users_id, roles_id) values (2, 2);

insert into video (lecturer, title, keyword, upload_date, link, user_id) values ('Andrew Ng', 'Convolutional Neural Networks', 'Machine Learning', '2019-12-12', 'ArPaAX_PhIs', 1);
insert into video (lecturer, title, keyword, upload_date, link, user_id) values ('Matthew N. Dailey', 'The Beautiful', 'Story', '2020-12-12', 'XuD4C8vJzEQ', 1);
insert into video (lecturer, title, keyword, upload_date, link, user_id) values ('Chaklam Silpasuwanchai', 'OST Tamil', 'Music', '2020-10-10', 'ArPaAX_PhIs', 1);

