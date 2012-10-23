CREATE TABLE citizen (
	id 				SERIAL 			PRIMARY KEY,
	te 				VARCHAR(20) 	UNIQUE,
	name 			VARCHAR(120),
	email 			VARCHAR(50),
	active 			INTEGER,
	passwd 			VARCHAR(32)
);

CREATE TABLE project (
	id 				SERIAL 			PRIMARY KEY,
	citizen_id 		INTEGER 		REFERENCES citizen(id),
	title 			VARCHAR(200),
	abstract 		TEXT,
	wording 		TEXT
);

CREATE TABLE vote (
	id 				SERIAL 			PRIMARY KEY,
	name 			TEXT 			UNIQUE
);

CREATE TABLE argument (
	id 				SERIAL 			PRIMARY KEY,
	vote_id			INTEGER 		REFERENCES vote(id),
	wording 		TEXT
);

CREATE TABLE change (
	id				SERIAL			PRIMARY KEY,
	project_id		INTEGER			REFERENCES project(id),
	new_project_id	INTEGER			REFERENCES project(id),
);