BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE lists(
    list_id SERIAL,
    owner_id INTEGER NOT NULL,
    name varchar(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    retailer_id INTEGER NOT NULL,
    CONSTRAINT PK_list PRIMARY KEY (list_id),
    CONSTRAINT FK_list_user FOREIGN KEY (owner_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT FK_list_retailer FOREIGN KEY (retailer_id) REFERENCES retailers(retailer_id) ON DELETE CASCADE
);

CREATE TABLE items(
    item_id SERIAL,
    name varchar(50) NOT NULL,
    description varchar(50) NOT NULL,
    CONSTRAINT PK_item PRIMARY KEY (item_id),
);

CREATE TABLE retailers(
    retailer_id SERIAL,
    name varchar(50) NOT NULL,
    CONSTRAINT PK_retailer PRIMARY KEY (retailer_id)
);

CREATE TABLE list_items(
    list_id INTEGER NOT NULL,
    item_id INTEGER NOT NULL,
    CONSTRAINT PK_list_item PRIMARY KEY (list_id, item_id),
    CONSTRAINT FK_list_item_list FOREIGN KEY (list_id) REFERENCES lists(list_id) ON DELETE CASCADE,
    CONSTRAINT FK_list_item_item FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE
);

CREATE TABLE user_list(
    user_id INTEGER NOT NULL,
    list_id INTEGER NOT NULL,
    CONSTRAINT PK_user_list PRIMARY KEY (user_id, list_id),
    CONSTRAINT FK_user_list_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT FK_user_list_list FOREIGN KEY (list_id) REFERENCES lists(list_id) ON DELETE CASCADE
);

COMMIT TRANSACTION;
