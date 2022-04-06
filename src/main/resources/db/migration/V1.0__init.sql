--Swedbank demo database
--Person table
CREATE TABLE user (
                      USERID bigint PRIMARY KEY AUTO_INCREMENT,
                        first_name varchar(255) not null,
                        last_name varchar(255) not null,
                        email varchar(255) not null,
                        password varchar(255) not null
);
