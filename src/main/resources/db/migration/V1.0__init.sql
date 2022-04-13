DROP TABLE IF EXISTS Users, Rooms, Desk, Reservations;

CREATE TABLE IF NOT EXISTS Users (
                       user_id SERIAL,
                       first_name TEXT NOT NULL,
                       last_name TEXT NOT NULL,
                       email TEXT NOT NULL,
                       password TEXT NOT NULL,
                       role TEXT DEFAULT 'user'
);

CREATE TABLE IF NOT EXISTS Rooms (
                       room_id SERIAL,
                       room_name TEXT,
);

CREATE TABLE IF NOT EXISTS Desk (
                       desk_id SERIAL,
                       room_name TEXT,
                       FOREIGN KEY(room_number) REFERENCES Rooms (room_name)
);

CREATE TABLE IF NOT EXISTS Reservations (
                       reservation_id SERIAL,
                       user_email TEXT,
                       desk_number INT,
                       reservation_start TIMESTAMP,
                       reservation_end TIMESTAMP,
                       FOREIGN KEY(user_email) REFERENCES Users (email),
                       FOREIGN KEY(desk_number) REFERENCES Desk (desk_id)
);

INSERT INTO Users(first_name, last_name, email, password) VALUES('Karolis','KK','kk@kk','Kk1');
INSERT INTO Users(first_name, last_name, email, password) VALUES('Mantas','MM','mm@mm','Mm1');
INSERT INTO Users(first_name, last_name, email, password) VALUES('Justinas','JJ','jj@jj','Jj1');

INSERT INTO Rooms(room_name) VALUES('Pirmas');
INSERT INTO Rooms(room_name) VALUES('Antras');

INSERT INTO Desk(room_name) VALUES('Antras');
INSERT INTO Desk(room_name) VALUES('Pirmas');
INSERT INTO Desk(room_name) VALUES('Pirmas');
INSERT INTO Desk(room_name) VALUES('Antras');
INSERT INTO Desk(room_name) VALUES('Antras');

INSERT INTO Reservations(user_email, desk_number, reservation_start, reservation_end) VALUES('mm@mm', 1, 2022-04-15 15:00:00, 2022-04-15 18:00:00);
INSERT INTO Reservations(user_email, desk_number, reservation_start, reservation_end) VALUES('kk@kk', 2, 2022-04-13 10:00:00, 2022-04-13 14:00:00);
INSERT INTO Reservations(user_email, desk_number, reservation_start, reservation_end) VALUES('jj@jj', 3, 2022-04-16 9:00:00, 2022-04-16 12:00:00);
INSERT INTO Reservations(user_email, desk_number, reservation_start, reservation_end) VALUES('kk@kk', 4, 2022-04-15 15:00:00, 2022-04-15 18:00:00);