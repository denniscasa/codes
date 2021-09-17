/***********************************************************
 * Purpose: Generate the report when option 1 is selected
 * Author: Dennis Casaclang
 * Date: 9/12/2021
 ***********************************************************/
CONN T205/portland7@DBMSDBII
SET ECHO OFF
SET FEEDBACK OFF
SET VERIFY OFF
SET PAGESIZE 30
SET LINESIZE 120
COLUMN FirstName FORMAT A15 HEADING 'First Name'
COLUMN LastName FORMAT A15 HEADING 'Last Name'
COLUMN Name FORMAT A55 HEADING 'Movie Name'
COLUMN AgreeDate FORMAT A12 HEADING 'Date'
COLUMN RentAmount FORMAT $90.00 HEADING 'Paid'
COLUMN AgreeID HEADING 'Agreement'
BREAK ON AgreeID ON FirstName ON LastName ON REPORT SKIP 1
COMPUTE SUM LABEL 'Total' OF RentAmount ON REPORT

ACCEPT CustID CHAR FORMAT 'A3' PROMPT 'Customer ID: '
CLEAR SCREEN
TTITLE CENTER 'Movie Rental Details for Client     ' CustID -
  RIGHT FORMAT 9 'Page: ' SQL.PNO SKIP 2
BTITLE LEFT 'Run By: ' SQL.USER
SPOOL C:\DBMSDBII\A1\Reports\Casaclang_DennisInitial.txt
SELECT RentalAgreement.AgreementID AgreeID, TRIM(FName)FirstName, LName LastName, - 
  TO_CHAR(RentalAgreement.AgreementDate, 'YYYY-MM-DD') AgreeDate, Name, MovieRented.RentalAmount RentAmount
FROM Movie JOIN MovieRented
  ON Movie.MovieID = MovieRented.MovieID JOIN RentalAgreement
  ON MovieRented.AgreementID = RentalAgreement.AgreementID JOIN Customer
  ON RentalAgreement.CustID = Customer.CustID
WHERE Customer.CustID = '&CustID'
ORDER BY AgreeDate;
SPOOL OFF
EXIT;