/**
** Name: Dennis Casaclang
** Assignment: 1
** Date: January 14th, 2021
** Student Number: 0261315
**/

--Q1
SELECT Country_Name
FROM Countries
WHERE Country_ID = 'AR' 
AND Region_ID = 2;

--Q2
SELECT Country_Name
FROM Countries
WHERE Country_Name LIKE '% %';

--Q3
SELECT City, State_Province, Country_ID
FROM Locations
WHERE Country_ID IN ('CA', 'US', 'MX')
ORDER BY Country_ID;

--Q4
SELECT Job_ID
FROM Jobs
WHERE Job_ID LIKE 'AD_____';

--Q5
SELECT Location_ID, Department_Name
FROM Departments
ORDER BY Location_ID DESC, Department_Name;

--Q6
SELECT Employee_ID, First_Name, Last_Name, Hire_Date
FROM Employees
WHERE Hire_Date BETWEEN '2008-01-01' AND '2008-12-31'
ORDER BY Hire_Date;

--Q7
SELECT Employee_ID, First_Name, Last_Name
FROM Employees
WHERE Last_Name LIKE 'C%'
ORDER BY First_Name;

--Q8
SELECT Department_Name
FROM Departments
WHERE Manager_ID IS NULL 
AND Department_Name LIKE '%Sales%'
ORDER BY Department_Name DESC;

--Q9
SELECT Employee_ID, Start_Date, Job_ID
FROM Job_History
WHERE Start_Date < '2000-01-01' 
OR Job_ID IN ('MK_REP', 'SA_REP')
ORDER BY Start_Date;

--Q10
SELECT Job_Title, Max_Salary, Max_Salary * 1.25 AS "New_Max_Salary"
FROM Jobs
WHERE Max_Salary * 1.25 < 10000
ORDER BY "New_Max_Salary";
