<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    div.scroll {
        margin:4px, 4px;
        padding:4px;
        width: 500px;
        height: 550px;
        overflow-x: hidden;
        overflow-y: auto;
        text-align:justify;
    }
</style>

  <nav:navbar>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <iframe width="780" height="550" src="https://www.youtube.com/embed/${video.id}?start=${start}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
                </iframe>
            </div>
            <div class="col-sm transcript-border scroll">
                <h4>Transcript</h4>
                <c:forEach items="${video.transcripts}" var="transcript">
                  <p>
                    <c:set var="minutes" value="${(transcript.startTime / 1000) / 60}" />
                    <c:set var="seconds" value="${(transcript.startTime / 1000) % 60}" />

                    <c:set var="totalSeconds" value="${(transcript.startTime / 1000)}" />
                    <fmt:parseNumber value="${totalSeconds}" var="parsed" type="number" integerOnly="true"/>
                    
                    <a href="/video/${video.id}?start=${parsed}">
                      <fmt:parseNumber value="${minutes}" type="number" integerOnly="true"/>:
                      <fmt:formatNumber value="${seconds}" minFractionDigits="0" maxFractionDigits="0"/>
                    </a>
                    <c:out value="${transcript.content}"/>
                  </p>
                </c:forEach>
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