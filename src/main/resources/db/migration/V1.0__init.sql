CREATE TABLE IF NOT EXISTS Users (
                       user_id SERIAL,
                       first_name TEXT NOT NULL,
                       last_name TEXT NOT NULL,
                       email TEXT UNIQUE NOT NULL,
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