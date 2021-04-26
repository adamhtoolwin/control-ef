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

<style>
    .transcript-border {
        border-style: solid;
        border-width: 3px !important;
        border-radius: 20px;
        border-color: blue;
    }
</style>

  <nav:navbar>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <iframe width="780" height="550" src="https://www.youtube.com/embed/${video.id}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
                </iframe>
            </div>
            <div class="col-sm transcript-border">
                <h4>Transcript</h4>
            </div>
        </div>

        <br><hr>
        <h2><c:out value="${video.title}"/></h2>
        <h5><c:out value="${video.lecturer}"/></h5>
        <p>

          Tags:
          <div class="row">
            
              <c:forEach items="${tags}" var="tag">
                <div class="col-sm transcript-border">
                    <c:out value="${tag.name}"/>
                </div>
              </c:forEach>
          </div>
        </p>
    </div>
    
  </nav:navbar>

</html>