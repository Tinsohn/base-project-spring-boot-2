INSERT INTO roles(description, name) VALUES ('Admin role', 'ADMIN');
INSERT INTO roles(description, name) VALUES ('User role', 'USER');

-- passwords => 'admin'
INSERT INTO app_users(username, password, email) values ('ADMIN', '$2a$10$hjdjJ/M3YF.6h7fIo8PJUOjy34yMt1rF.Y3rhwAt9zJ909vXdCCu.', 'user1@admin.com');
INSERT INTO users_roles(user_id, role_id) values (1, 1);
INSERT INTO users_roles(user_id, role_id) values (1, 2);

INSERT INTO app_users(username, password, email) values ('user_test', '$2a$10$hjdjJ/M3YF.6h7fIo8PJUOjy34yMt1rF.Y3rhwAt9zJ909vXdCCu.', 'user2@user.com');
INSERT INTO users_roles(user_id, role_id) values (2, 2);