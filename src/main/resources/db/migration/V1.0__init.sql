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
                       room_name TEXT UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Desk (
                       desk_id SERIAL UNIQUE,
                       room_name TEXT REFERENCES Rooms (room_name)
);

CREATE TABLE IF NOT EXISTS Reservations (
                       reservation_id SERIAL,
                       user_email TEXT REFERENCES Users (email),
                       desk_number INT REFERENCES Desk (desk_id),
                       reservation_start TIMESTAMP NOT NULL,
                       reservation_end TIMESTAMP NOT NULL
);

--======================================

INSERT INTO Users(first_name, last_name, email, password) VALUES ('tadas','yes','belekoks@gmail','geraspass1');
INSERT INTO Rooms(room_name) VALUES ('room1');
INSERT INTO Rooms(room_name) VALUES ('room2');

INSERT INTO Desk(room_name) VALUES ('room1');
INSERT INTO Desk(room_name) VALUES ('room1');
INSERT INTO Desk(room_name) VALUES ('room2');

INSERT INTO Reservations(user_email, desk_number, reservation_start, reservation_end) VALUES ('belekoks@gmail', 2, '2020-10-10 15:00:00', '2020-10-10 16:00:00');