INSERT INTO roles(description, name) VALUES ('Admin role', 'ADMIN');
INSERT INTO roles(description, name) VALUES ('User role', 'USER');

-- password => 'Admin.1234'
INSERT INTO app_users(username, password, email) values ('ADMIN', '$2a$10$9vV8AjQUrGwotVl3Y8NllOX.4rP90UOfE750uU6ecBelb2s2733K2', 'user1@admin.com');
INSERT INTO users_roles(user_id, role_id) values (1, 1);
INSERT INTO users_roles(user_id, role_id) values (1, 2);

-- password => 'User.1234'
INSERT INTO app_users(username, password, email) values ('user_test', '$2a$10$P9KRyWdDL3XhYf/Rgb6Cx.DA0W.r.nir4yCvwnbXx6Z6iNBXmdD5a', 'user2@user.com');
INSERT INTO users_roles(user_id, role_id) values (2, 2);