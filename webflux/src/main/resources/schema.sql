DROP TABLE IF EXISTS users;
CREATE TABLE users(
	id serial primary key, 
	name VARCHAR(255),
	surname VARCHAR(255),
	username VARCHAR(255),
	email VARCHAR(255),
	password VARCHAR(255)
	)