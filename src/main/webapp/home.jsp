<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Control-ef</title>
</head>

<style>
    table, th, td {
  border: 1px solid black;
}
</style>

<body>
    <h1>Upload video</h1>
    <hr>

    <form action="videos/upload" method="POST">
      Title: <input type="text" name="title"><br>
      <input type="submit">
    </form>

    <br>
    
    <h1>Upload video using cors</h1>
    <hr>
    <form action="videos/cor-upload" method="POST">
      Title: <input type="text" name="title"><br>
      <input type="submit">
    </form>

</body>
</html>