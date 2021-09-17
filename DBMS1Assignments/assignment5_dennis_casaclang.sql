/**
 ** Name: Dennis Casaclang
 ** Assignment: 5
 ** Date: March 25th, 2021
 **/
    
--Q1
SELECT (First_Name || ' ' || Last_Name|| ' can be contacted at ' || Phone_Number) AS "Employee number"
FROM Employees
WHERE INSTR(Phone_Number, '515', 1, 1) > 0;

--Q2
SELECT AVG(Max_Salary) - AVG(Min_Salary) AS "Diff. max and min salary"
FROM Jobs;

--Q3
SELECT REPLACE(City, ' ', ''), Postal_Code
FROM Locations
WHERE LENGTH(Postal_Code) = 5;

--Q4
SELECT (SUBSTR(Region_Name, 1, 3) || SUBSTR(Country_Name, -4, 4)) AS "New Country Name"
FROM Regions JOIN Countries
  ON Regions.Region_ID = Countries.Region_ID
ORDER BY (Region_Name || Country_Name);

--Q5
SELECT Job_Title
FROM Jobs JOIN Employees
  ON Jobs.Job_ID = Employees.Job_ID
GROUP BY Job_Title
HAVING COUNT(Job_Title) = 1
ORDER BY Job_Title;

--Q6
SELECT Jobs.Job_ID, COUNT(*) AS "# of Employees", 
       LPAD(AVG(Employees.Salary), 8, '.') AS "Average Pay", 
       MAX(Employees.Hire_Date) AS "Last Hired"
FROM Employees JOIN Jobs
  ON Employees.Job_ID = Jobs.Job_ID
GROUP BY Jobs.Job_ID
ORDER BY COUNT(*) DESC, AVG(Employees.Salary) DESC;

--Q7
SELECT COUNT(*) AS "Employee Count", Departments.Department_ID, Departments.Department_Name
FROM Departments JOIN Employees
  ON Departments.Department_ID = Employees.Department_ID JOIN Jobs
  ON Employees.Job_ID = Jobs.Job_ID
WHERE Jobs.Job_ID IN ('IT_PROG', 'SA_REP')
GROUP BY Jobs.Job_ID, Departments.Department_ID, Departments.Department_Name
HAVING COUNT(*) >= 3;
