<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="nav" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html>
<html>
<head>
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> -->
  <meta charset="ISO-8859-1">
  <title>Control-ef</title>
</head>

<nav:navbar>
    <div class="container">
    <br>
    <h1>Users</h1>
    <hr>
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>ID #</th>
                <th>Username</th>
                <th>Email</th>
                <th>Active</th>
                <th>Role</th>
            </tr>
        </thead>
        
        <tbody><c:out value="${user.id}"/></tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <th scope="row"><c:out value="${user.id}"/></th></th>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.active}"/></td>
                    <td>
                        <c:forEach items="${user.roles}" var="role">
                            <p><c:out value="${role.name}"/></p>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
  
</nav:navbar>

</html>