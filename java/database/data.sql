BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO groups (group_name) VALUES ('group1');

INSERT INTO lists (name) VALUES ('list1');

INSERT INTO retailers(name) VALUES ('retailer1');

INSERT INTO category(category_name) VALUES ('category1');

INSERT INTO items(name,description,category_id) VALUES ('item1','description1',1);


COMMIT TRANSACTION;
