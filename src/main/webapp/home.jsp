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

  <!-- <style>
    
    .navbar-custom {
      background-color: #1236d4;
    }
    /* change the brand and text color */
    .navbar-custom .navbar-brand,
    .navbar-custom .navbar-text {
        color: rgba(255,255,255,.8);
    }
    /* change the link color */
    .navbar-custom .navbar-nav .nav-link {
        color: rgba(255,255,255,.5);
    }
    /* change the color of active or hovered links */
    .navbar-custom .nav-item.active .nav-link,
    .navbar-custom .nav-item:hover .nav-link {
        color: #ffffff;
    }

  </style> -->
</head>

  <nav:navbar>
    <div class="container">
      
      <div class="container">
        <br>
        <c:forEach items="${videos}" var="video">
          <div class="row">
            <div class="col-md-auto">
              <a href="/video/${video.id}"><img width="200" src="https://img.youtube.com/vi/${video.id}/1.jpg"></a>
            </div>
            <div class="col-sm">
                <a href="/video/${video.id}"><h3><c:out value="${video.title}"/></h3></a>
                <p>By <c:out value="${video.lecturer}"/></p>
            </div>
          </div>
          <br>
        </c:forEach>
      </div>
    
  </nav:navbar>

</html>