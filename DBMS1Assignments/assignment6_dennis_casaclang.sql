/**
 ** Name: Dennis Casaclang
 ** Assignment: 6
 ** Date: April 13, 2021
 **/
 
 --Q1
 CREATE OR REPLACE VIEW Department_Locations AS
 SELECT l.city AS "Department_Locations" , l.location_id
 FROM locations l
 WHERE l.location_id IN
 (SELECT d.location_id
  FROM departments d
  WHERE d.location_id IS NOT NULL);
 
 SELECT *
 FROM Department_Locations;

 --Q2
 CREATE OR REPLACE VIEW Management_Employee_Counts AS
 SELECT e.first_name AS "First Name", e.last_name AS "Last Name", 
 (SELECT COUNT(*)
  FROM employees d
  WHERE d.manager_id = e.employee_id) AS "Employee Count"
 FROM employees e
 ORDER BY "Employee Count" DESC;
 
 SELECT *
 FROM Management_Employee_Counts;
 
 --Q3
 --user name: S305
 
 --BOB has given me UPDATE access to Pilot
 --BOB has given me INSERT access to Pilot
 --BOB has given everyone SELECT access to Mastertb
 SELECT  Owner, Grantor, Grantee, 
 Privilege, Table_Name
 FROM All_Tab_Privs_Recd
 WHERE Grantor = 'BOB';
 
 --Column names on Mastertb table, including data type details
 SELECT  Owner, Table_Name, 
        Column_Name, Data_Type, 
        Data_Precision AS "Digits in Num", 
        Data_Scale AS "Digits After Decimal", 
        Char_Length AS "CHAR/VARCHAR2 size", 
        Nullable, Column_ID
 FROM All_Tab_Cols 
 WHERE owner = 'BOB'
   AND Table_Name = 'MASTERTB'
 ORDER BY Table_Name, Column_ID;
 
 --Column names on Pilot table, including data type details
 SELECT  Owner, Table_Name, 
        Column_Name, Data_Type, 
        Data_Precision AS "Digits in Num", 
        Data_Scale AS "Digits After Decimal", 
        Char_Length AS "CHAR/VARCHAR2 size", 
        Nullable, Column_ID
 FROM All_Tab_Cols 
 WHERE owner = 'BOB'
   AND Table_Name = 'PILOT'
 ORDER BY Table_Name, Column_ID;
 
 --Show constraints in Mastertb table
 SELECT constraint_name, constraint_type,
       delete_rule, r_owner, r_constraint_Name,
       search_condition
 FROM All_Constraints
 WHERE owner = 'BOB' 
 AND Table_Name = 'MASTERTB';
 
 --Show constraints in Pilot table
 SELECT constraint_name, constraint_type,
       delete_rule, r_owner, r_constraint_Name,
       search_condition
 FROM All_Constraints
 WHERE owner = 'BOB' 
 AND Table_Name = 'PILOT';
 
 --Recreate Mastertb table
 DROP TABLE S305Mastertb;
 
 CREATE TABLE S305Mastertb
 (
    ID NUMBER(17) NOT NULL,
    STUDENT CHAR(50),
    CONSTRAINT MASTERPK
        PRIMARY KEY(ID)
 );
 
 --Recreate Pilot table
 DROP TABLE S305Pilot;
 
 CREATE TABLE S305Pilot
 (
    FNAME CHAR(20),
    LNAME CHAR(30),
    HIREDATE DATE,
    PID NUMBER(10) NOT NULL,
    SALARY NUMBER(10,2),
    MID NUMBER(17),
    CONSTRAINT PPK
        PRIMARY KEY(PID),
    CONSTRAINT PILOTFK
        FOREIGN KEY(MID)
        REFERENCES S305Mastertb
        ON DELETE CASCADE,
    CONSTRAINT CSL
        CHECK(SALARY < 750000)
 );
 