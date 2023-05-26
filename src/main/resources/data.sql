INSERT INTO roles(description, name) VALUES ('Admin role', 'ADMIN');
INSERT INTO roles(description, name) VALUES ('User role', 'USER');

-- password => 'Admin.1234'
INSERT INTO app_users(id, username, password, email) values ('306b9319d8884e2cbcb79e2b8c27a273', 'ADMIN', '$2a$10$9vV8AjQUrGwotVl3Y8NllOX.4rP90UOfE750uU6ecBelb2s2733K2', 'user1@admin.com');
INSERT INTO users_roles(user_id, role_id) values ('306b9319d8884e2cbcb79e2b8c27a273', 1);
INSERT INTO users_roles(user_id, role_id) values ('306b9319d8884e2cbcb79e2b8c27a273', 2);

-- password => 'User.1234'
INSERT INTO app_users(id, username, password, email) values ('51332fbc0d9a4d9daa2a7f2dacc8fe65', 'user_test', '$2a$10$P9KRyWdDL3XhYf/Rgb6Cx.DA0W.r.nir4yCvwnbXx6Z6iNBXmdD5a', 'user2@user.com');
INSERT INTO users_roles(user_id, role_id) values ('51332fbc0d9a4d9daa2a7f2dacc8fe65', 2);