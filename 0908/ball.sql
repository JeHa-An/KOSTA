CREATE TABLE team(
	num INT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(100) NOT NULL,
	LOCAL VARCHAR(100)
);

DROP TABLE player;
CREATE TABLE player(
	num INT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(100) NOT NULL,
	backnum INT,
	teamnum INT REFERENCES team(num)
);