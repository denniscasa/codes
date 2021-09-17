@ECHO OFF
REM *******************************************************************************
REM * Purpose: Run a .bat file that implements a menu so users can request reports
REM * Author: Dennis Casaclang
REM * Date: 9/12/2021
REM *******************************************************************************/
:StartOfProgram
CLS
ECHO.
ECHO Dennis Casaclang Movie Rentals
ECHO.
ECHO 1. Generate Report
ECHO 2. Exit
ECHO.
SET UserInput=
SET /P UserInput=Enter your choice: 
ECHO.
IF "%UserInput%"=="1" (
   MKDIR C:\DBMSDBII\A1\Reports
   SQLPLUS /nolog @Assign1.sql
   GOTO EndIfStatement
) 
IF "%UserInput%"=="2" (
   EXIT
) 
IF "%UserInput%"=="" (
   ECHO Error - No choice entered. Please choose a valid option.
) ELSE (
   ECHO Error - Invalid choice entered. Please choose a valid option.
)
ECHO.
:EndIfStatement
PAUSE
GOTO StartOfProgram