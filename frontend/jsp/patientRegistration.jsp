<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/patientRegistration.css">
        <title>Patient Registration</title>
    </head>
    <body>
        <div class="background">
        <div class="wrapper">
            <header>
                <h1>Hospital Management System</h1><br>
            </header>
            <div class="head">
                <select class="patient">
                    <option>Patient</option>
                </select>
                <select class="pharma">
                    <option>Pharmacy</option>
                </select>
                <select class="diagn">
                    <option>Diagonostics</option>
                </select>
            </div>
        </div>
        <div class="center">
            <h2>Patient Registration</h2>
            <form method="post" action="PatientServlet">
            <input type="hidden" name="source" value="addPatient">
                <div class="inputBox">
                <label>Patient SSN ID:</label>
                <input class="patiendId" type="text" name="pid" ><br><br>
                <label>Patient Name:</label>
                <input class="name" type="text" name="name" ><br><br>
                <label>Patient Age:</label>
                <input class="age" type="text" name="age" ><br><br>
                <label>Date of Admission:</label>
                <input class="date" type="date" name="date"><br><br>
                <label>Type of bed:</label>
                <select class="bed" name="bed">
                    
                    <option value="General Ward">General Ward</option>
                    <option value="Semi Sharing">Semi Sharing</option>
                    <option value="Single Room">Single Room</option>
                </select><br><br>
                <label>Address:</label>
                <textarea class="address" name="address"></textarea><br><br>
                <label>City</label>
                <input class="city" type="text" name="city"><br><br>
                <label>State:</label>
                <input class="state" type="text" name="state"><br><br>
                <label>Status</label>
                <select class="status" name="status">
                    <option value="Active">Active</option>
                    <option value="Discharge">Discharged</option>
                </select><br><br>

                <input type="submit" name="submitBtn" value="Submit">
                <input type="reset" name="resetBtn" value="Reset">
                </div>
            </form>
        </div>
        </div>
    </body>
</html>