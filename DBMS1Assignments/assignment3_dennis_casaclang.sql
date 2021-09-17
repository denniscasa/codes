/**
** Name: Dennis Casaclang
** Assignment: 3
** Date: February 14, 2021
** Student Number: 0261315
**/

--Q1
DROP TABLE NBAPlayer;

CREATE TABLE NBAPlayer
(
    Jersey_ID NUMBER(2) NOT NULL,
    Player_Name VARCHAR2(50),
    Birthday DATE,
    CONSTRAINT NBAPlayerPK
       PRIMARY KEY(Jersey_ID)
);
CREATE TABLE Orders
(
    order_number VARCHAR2(6) NOT NULL,
    order_date DATE NOT NULL,
    customer_name VARCHAR2(50) NOT NULL,
    customer_address VARCHAR2(50) NOT NULL,
    city VARCHAR2(50) NOT NULL,
    province VARCHAR2(2) NOT NULL,
    postal_code VARCHAR2(6) NOT NULL,
    email VARCHAR2(50) NOT NULL,
    phone NUMBER(10) NOT NULL,
    item_description VARCHAR2(50) NOT NULL,
    quantity NUMBER(5,2) NOT NULL,
    unit_price NUMBER (5,2) NOT NULL,
    total_item_price NUMBER (5,2),
    subtotal NUMBER(5,2) NOT NULL,
    gst NUMBER(5,2) NOT NULL,
    pst NUMBER(5,2) NOT NULL,
    order_total NUMBER(5,2) NOT NULL,
    CONSTRAINT OrdersPK
        PRIMARY KEY(order_number)
);
INSERT INTO Orders (order_number, order_date, customer_name, customer_address, city, province, postal_code,
                    email, phone, item_description, quantity, unit_price, total_item_price,
                    subtotal, gst, pst, order_total)
VALUES ('CS3329', '06-20-2020', 'Gable Mechanics', '841 Burnell St', 'Winnipeg', 'MB', 'r3w0n3', 'gmec@gmail.ca', 2045051110, 'NB12 - Chrome Bumper', 
        1, 499.99, 499.99, 499.99, 25, 40, 564.99);
--Q2
INSERT INTO NBAPlayer (Jersey_ID, Player_Name, Birthday)
VALUES (23, 'Lebron James', '1984-12-30');
INSERT INTO NBAPlayer (Jersey_ID, Player_Name, Birthday)
VALUES (3, 'Anthony Davis', '1993-03-11');
INSERT INTO NBAPlayer (Jersey_ID, Player_Name, Birthday)
VALUES (30, 'Stephen Curry', '1988-03-14');

--This insert is missing the birthday of the NBA player named Kevin Durant.
INSERT INTO NBAPlayer (Jersey_ID, Player_Name)
VALUES (7, 'Kevin Durant');

SELECT *
FROM NBAPlayer;

--Q3
--Update the row where the Jersey ID is 30. Updates JerseyID to 15, PlayerName to Nikola Jokic, Birthdate to 1995-02-19.
UPDATE NBAPlayer
SET Jersey_ID = 15,
    Player_Name = 'Nikola Jokic',
    Birthday = '1995-02-19'
WHERE Jersey_ID = 30;

SELECT *
FROM NBAPlayer;

--Delete the NBA player with the Jersey ID of 3.
DELETE FROM NBAPlayer
WHERE Jersey_ID = 3;

SELECT *
FROM NBAPlayer;

--Q4 ERD File.

--Q5
DROP TABLE Plane_Route;
DROP TABLE Route;
DROP TABLE Plane;

CREATE TABLE Plane
(
    Plane_ID NUMBER(10) NOT NULL,
    Plane_Name VARCHAR2(100) NOT NULL,
    Fuel_Capacity NUMBER(8,2),
    CONSTRAINT PlanePK
       PRIMARY KEY(Plane_ID)
);

CREATE TABLE Route
(
    Route_ID NUMBER(6) NOT NULL,
    Route_Length NUMBER(2),
    Departure_City VARCHAR2(85) NOT NULL,
    Arrival_City VARCHAR2(85) NOT NULL,
    CONSTRAINT RoutePK
       PRIMARY KEY(Route_ID),
    CONSTRAINT Route_Length_Check
       CHECK (Route_Length < 20 AND Route_Length > 0)
);

CREATE TABLE Plane_Route
(
    Plane_Route_ID NUMBER (10) NOT NULL,
    Plane_ID NUMBER(10) NOT NULL,
    Route_ID NUMBER(6) NOT NULL,
    Arrival_Date DATE NOT NULL,
    Departure_Date DATE NOT NULL,
    CONSTRAINT PlaneRoutePK
       PRIMARY KEY(Plane_Route_ID),
    CONSTRAINT PlaneFK
       FOREIGN KEY(Plane_ID)
       REFERENCES Plane,
    CONSTRAINT RouteFK
       FOREIGN KEY(Route_ID)
       REFERENCES Route,
    CONSTRAINT Arrival_Date_Check
       CHECK (Arrival_Date > Departure_Date)
);

--Planes Testing

--2 valid Plane inserts
INSERT INTO Plane (Plane_ID, Plane_Name, Fuel_Capacity)
VALUES (1, 'Boeing 747', 299999.99);
INSERT INTO Plane (Plane_ID, Plane_Name, Fuel_Capacity)
VALUES (2, 'Boeing 737', 199999.99);

--Testing NOT NULL Constraint for Primary Key Plain_ID.
INSERT INTO Plane (Plane_ID, Plane_Name, Fuel_Capacity)
VALUES (NULL, 'Boeing 757', 199999.99);

--Testing PLANE PK Constraint for Plain_ID.
INSERT INTO Plane (Plane_ID, Plane_Name, Fuel_Capacity)
VALUES (1, 'Boeing 757', 199999.99);

--Testing NOT NULL Constraint for Plane_Name.
INSERT INTO Plane (Plane_ID, Plane_Name, Fuel_Capacity)
VALUES (3, NULL, 199999.99);

--Routes Testing

--2 Valid Route Inserts
INSERT INTO Route(Route_ID, Route_Length, Departure_City, Arrival_City)
VALUES(1, 15, 'Toronto', 'Barcelona');
INSERT INTO Route(Route_ID, Route_Length, Departure_City, Arrival_City)
VALUES(2, 3, 'Winnipeg', 'Calgary');

--Testing NOT NULL Constraint for Primary Key Route_ID.
INSERT INTO Route(Route_ID, Route_Length, Departure_City, Arrival_City)
VALUES(NULL, 8, 'Beijing', 'Moscow');

--Testing ROUTE PK Constraint for Route_ID.
INSERT INTO Route(Route_ID, Route_Length, Departure_City, Arrival_City)
VALUES(2, 8, 'Beijing', 'Moscow');

--Testing NOT NULL Constraint for Departure City.
INSERT INTO Route(Route_ID, Route_Length, Departure_City, Arrival_City)
VALUES(3, 8, NULL, 'Moscow');

--Testing NOT NULL Constraint for Arrival City.
INSERT INTO Route(Route_ID, Route_Length, Departure_City, Arrival_City)
VALUES(3, 8, 'Beijing', NULL);

--Testing ROUTE_LENGTH_CHECK Constraint for Route Length. Route length must be a positive number less than 20 hours.
INSERT INTO Route(Route_ID, Route_Length, Departure_City, Arrival_City)
VALUES(3, 24, 'Beijing', 'Moscow');

--Testing ROUTE_LENGTH_CHECK Constraint for Route Length. Route length must be a positive number greater than 0.
INSERT INTO Route(Route_ID, Route_Length, Departure_City, Arrival_City)
VALUES(3, -4, 'Beijing', 'Moscow');

--Planes_Routes Testing

--2 Valid Plane_Route Inserts
INSERT INTO Plane_Route(Plane_Route_ID, Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(1, '2021-02-21', '2021-02-22', 1, 1);
INSERT INTO Plane_Route(Plane_Route_ID,Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(2, '2021-02-25', '2021-02-26', 2, 2);

--Testing NOT NULL Constraint for Primary Key Plane_Route_ID.
INSERT INTO Plane_Route(Plane_Route_ID, Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(NULL, '2021-02-25', '2021-02-26', 2, 1);

--Testing NOT NULL Constraint for Foreign Key Plane_ID
INSERT INTO Plane_Route(Plane_Route_ID, Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(3, '2021-02-25', '2021-02-26', NULL, 2);

--Testing NOT NULL Constraint for Foreign Key Route_ID
INSERT INTO Plane_Route(Plane_Route_ID, Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(3, '2021-02-25', '2021-02-26', 2, NULL);

--Testing NOT NULL Constraint for Departure Date
INSERT INTO Plane_Route(Plane_Route_ID, Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(3, NULL, '2021-02-26', 1, 2);

--Testing NOT NULL Constraint for Arrival Date
INSERT INTO Plane_Route(Plane_Route_ID, Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(3, '2021-02-25', NULL, 2, 1);

--Testing PLANE ROUTE PK Constraint for Plane_Route_ID.
INSERT INTO Plane_Route(Plane_Route_ID, Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(2, '2021-02-25', '2021-02-26', 1, 2);

--Testing PLANE FK Constraint for Foreign Key Plane_ID.
INSERT INTO Plane_Route(Plane_Route_ID, Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(3, '2021-02-25', '2021-02-26', 3, 2);

--Testing ROUTE FK Constraint for Foreign Key Route_ID.
INSERT INTO Plane_Route(Plane_Route_ID, Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(3, '2021-02-25', '2021-02-26', 2, 3);

--Testing ARRIVAL_DATE_CHECK Constraint for Arrival Date. Arrival date cannot happen before departure date.
INSERT INTO Plane_Route(Plane_Route_ID, Departure_Date, Arrival_Date, Plane_ID, Route_ID)
VALUES(3, '2021-02-27', '2021-02-26', 2, 1);
