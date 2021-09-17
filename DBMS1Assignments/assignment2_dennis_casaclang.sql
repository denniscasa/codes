/**
** Name: Dennis Casaclang
** Assignment: 2
** Date: January 31, 2021
** Student Number: 0261315
**/

--Q1
SELECT Employee_ID, First_Name, Last_Name, Job_Title, Max_Salary
FROM Employees JOIN Jobs
  ON Employees.Job_ID = Jobs.Job_ID
ORDER BY Max_Salary DESC;

--Q2
SELECT First_Name, Last_Name, Employees.Job_ID, 
End_Date, Max_Salary
FROM Employees JOIN Jobs
  ON Jobs.Job_ID = Employees.Job_ID JOIN Job_History
  ON Job_History.Job_ID = Employees.Job_ID
WHERE Employees.Employee_ID IN (176, 200, 101, 102)
ORDER BY Last_Name DESC, End_Date;

--Q3
SELECT Employees.Employee_ID, Country_Name
FROM Employees JOIN Departments
  ON Employees.Department_ID = Departments.Department_ID JOIN Locations
  ON Departments.Location_ID = Locations.Location_ID JOIN Countries
  ON Locations.Country_ID = Countries.Country_ID;
  
--Q4
SELECT Department_Name, City, Country_Name, Region_Name
FROM Departments JOIN Locations
  ON Departments.Location_ID = Locations.Location_ID JOIN Countries
  ON Locations.Country_ID = Countries.Country_ID JOIN Regions
  ON Countries.Region_ID = Regions.Region_ID
WHERE Regions.Region_Name = 'Europe';

--Q5
SELECT Departments.Location_ID, City
FROM Departments RIGHT OUTER JOIN Locations
  ON Departments.Location_ID = Locations.Location_ID JOIN Countries
  ON Locations.Country_ID = Countries.Country_ID
WHERE Department_Name IS NULL
AND Country_Name <> 'Mexico';

--Q6
SELECT Country_ID
FROM Locations
WHERE Location_ID IS NULL
UNION
SELECT Country_ID
FROM Countries
WHERE Region_ID = 1;

--Q7
SELECT Departments.Manager_ID, First_Name, Last_Name, 
Department_Name, City
FROM Employees JOIN Departments
  ON Employees.Employee_ID = Departments.Manager_ID JOIN Locations
  ON Departments.Location_ID = Locations.Location_ID
WHERE City = 'Seattle';

--Q8
SELECT Department_Name, First_Name, Last_Name, 
Job_Title, Salary
FROM Employees RIGHT OUTER JOIN Departments
  ON Departments.Manager_ID = Employees.Employee_ID JOIN Jobs
  ON Employees.Job_ID = Jobs.Job_ID;
  
--Q9
SELECT First_Name
FROM Employees
INTERSECT
SELECT Last_Name
FROM Employees;

--Q10
SELECT Country_Name, City
FROM Locations  FULL OUTER JOIN Countries
 ON Locations.Country_ID = Countries.Country_ID
WHERE City IS NULL
OR Country_Name IS NULL;
