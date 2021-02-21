insert into video (title,keyword,upload,uploader) values ('Top 10 NXT','WWE','2021-02-12','Smith');
insert into video (title,keyword,upload,uploader) values ('The Holy Travel','Travel','2019-12-12','Natasha');
insert into video (title,keyword,upload,uploader) values ('The Beautiful','Story','2020-12-12','Shin Thant');
insert into video (title,keyword,upload,uploader) values ('OST Tamil','Music','2020-10-10','Graham');

-- Roles --
insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_USER');

-- admin user --
insert into user (username, password, active, email) values ('admin', '$2a$10$otMn8Xre2SYZm.cZwa4q8e7hq3Y7/gkGoD9FOMvVmRvPr75p3POLm', true, 'admin@ait.asia');
insert into user_roles (users_id, roles_id) values (1, 1);

-- normal user -- 
insert into user (username, password, active, email) values ('john', '$2a$10$otMn8Xre2SYZm.cZwa4q8e7hq3Y7/gkGoD9FOMvVmRvPr75p3POLm', true, 'user@ait.asia');
insert into user_roles (users_id, roles_id) values (2, 2);
