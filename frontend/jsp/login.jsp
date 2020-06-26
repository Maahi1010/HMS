<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <title>Login</title>
    </head>
    <body>
        <div class="background">
        <div class="wrapper">
            <header>
                <h1>Hospital Management System</h1>
            </header>
        </div>
        <div class="center">
            <h2>Login</h2>
            <form method="post" action="LoginServlet">
                <div class="inputBox">
                    <input type="text" name="username" autocomplete="off" required>
                    <label>User Name</label>
                </div>
                <div class="inputBox">
                    <input type="password" name="password" autocomplete="off" required>
                    <label>Password</label>
                </div>

                <input type="submit" name="" value="login">
            </form>


        </div>
        </div>
    </body>
</html>