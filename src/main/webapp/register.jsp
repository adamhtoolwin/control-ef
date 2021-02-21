<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="nav" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Control-ef</title>
</head>

<style>
    .login-form {
        width: 340px;
        margin: 50px auto;
          font-size: 15px;
    }
    .login-form form {
        margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
    .error {
        color: #ff0000;
        font-weight: bold;
    }
</style>

<nav:navbar>
  <div class="container">
    <div class="login-form">
        <form:form method="POST" modelAttribute="user">
		<spring:bind path="username">
			<div class="form-group">
				<form:input type="text" path="username" class="form-control"
					placeholder="Username" autofocus="true"></form:input>
				<form:errors path="username" class="error"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="password">
			<div class="form-group">
				<form:input type="password" path="password" class="form-control"
					placeholder="Password"></form:input>
				<form:errors path="password" class="error"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="passwordConfirmation">
			<div class="form-group">
				<form:input type="password" path="passwordConfirmation"
					class="form-control" placeholder="Confirm your password"></form:input>
				<form:errors path="passwordConfirmation" class="error"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="email">
			<div class="form-group">
				<form:input type="text" path="email" class="form-control"
					placeholder="Email" autofocus="true"></form:input>
				<form:errors path="email" class="error"></form:errors>
			</div>
		</spring:bind>

        <br>
		<Input type="submit" class="btn btn-primary btn-block" name="submit" value="Register">
		</td>
	</form:form>
    </div>
  </div>
  
</nav:navbar>

</html>