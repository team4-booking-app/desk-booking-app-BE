--Swedbank demo database
--Person table
CREATE TABLE user (
                      USERID bigint PRIMARY KEY AUTO_INCREMENT,
                        first_name varchar(255) not null,
                        middle_name varchar(255),
                        last_name varchar(255) not null,
                        email varchar(255) not null,
                        phone varchar(255),
                        password varchar(255) not null
);
--Person data
insert into user (USERID, first_name, middle_name, last_name, email, phone, password) values (38202020577,'Testas', '',  'Testauskas', 'test@test.com', '+37060035645','haha' );
insert into user (USERID, first_name, middle_name, last_name, email, phone, password) values (38202020567,'Testas1', '',  'Testauskas1', 'test@test.com', '+37060035666','labas' );