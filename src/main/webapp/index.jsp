<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ensa Blog</title>
    <link href="<c:url value="/assets/style.css" />" rel="stylesheet">
  <body>
    <h2>ENSA BLOG</h2>
    <div class="container" id="container">
      <div class="form-container sign-up-container">
        <form action="signup.do" id="signupForm" method="POST" >
          <h1>Create Account</h1>

          <input type="text" placeholder="Username" name="username"/>
          <input type="email" placeholder="Email" name="email"/>
          <input type="password" placeholder="Password" name="password"/>
          <input type="password" placeholder="Confirm password" name="passwordConfirmation"/>
          
          <button>Sign Up</button>
        </form>
      </div>
      <div class="form-container sign-in-container">
        <form action="login.do" id="loginForm" method="POST">
          <h1>Log in</h1>
          <input type="text" placeholder="Username" name="username"/>
          <input type="password" placeholder="Password" name="password"/>
          <a href="#">Forgot your password?</a>
          <button>Log In</button>
        </form>
      </div>
      <div class="overlay-container">
        <div class="overlay">
          <div class="overlay-panel overlay-left">
            <h1>Welcome Back!</h1>
            <p>
              If you already have an account please login with your personal
              info
            </p>
            <button class="ghost" id="signIn">Log In</button>
          </div>
          <div class="overlay-panel overlay-right">
            <h1>Hello, Friend!</h1>
            <p>Enter your personal details and start journey with us</p>
            <button class="ghost" id="signUp">Sign Up</button>
          </div>
        </div>
      </div>
    </div>

    <footer>
      <p>Created with <i class="fa fa-heart"></i> by ENSAB Students</p>
    </footer>
    <script
      src="https://kit.fontawesome.com/08e63ab518.js"
      crossorigin="anonymous"
    ></script>
    <script src="./assets/login.js"></script>
  </body>
</html>
