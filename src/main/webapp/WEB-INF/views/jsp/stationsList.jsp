<%--
  Created by IntelliJ IDEA.
  trgtrgtrg
  User: patry
  Date: 16.03.2017
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<html>
<head>
    <title>Stations list</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
    <script src="${bootstrapJs}"></script>
</head>
<body>
<header>

  <%--  <table>
        <div style="align-content: center">
            <tr>
                <td style="width: 80px; padding: 10px">
                    <h3><a href="/studentForm"> Add student</a>
                    </h3>
                </td>
                <td style="width: 80px;  padding: 10px">
                    <h3><a href="/studentsList">All students</a>
                    </h3>
                </td>
            </tr>
        </div>
    </table>--%>
</header>

<%--<form action="/studentsList" method="get" commandName="student">--%>

<%--form:label path="firstName">Search by title:</form:label>
    <form:input id="firstName" path="firstName" type="text"/>
    <input type="submit" value="Find">
</form>--%>

<div class="container">
    <%--<table style="width: 50%; border: thick solid black" ; cellpadding="5" ; cellspacing="5">--%>
    <table class="table table-hover">
        <tbody>
        <thead>

        <div class="input-group">
            <form:form action="/studentsList" method="post">
                <input name="name" id="name" type="text" class="form-control" size="40"
                       placeholder="Search by student's name..."/>
                <button type="submit" class="btn btn-success">Filter</button>
            </form:form>
        </div>
        </thead>

        <%--<table class="table">--%>
        <%--<thead class="thead-inverse">--%>
        <tr style="width: auto; text-align:center; background-color: black; color: white">
            <%--<tr>--%>
            <th><h2>ID</h2></th>
            <th style="text-align: center"><h2>Login</h2></th>
            <th><h2>Address</h2></th>
            <td><h2>Latitude</h2></td>
            <th><h2>Longitude</h2></th>
        </tr>
        <%--</thead>--%>

        <c:forEach items="${studentsList}" var="item">
            <tr>
                <td style="width: auto; text-align:center; border: 1px solid #000">
                    <h3><a href="/studentDetails/${item.id}"> ${item.id}</a>
                    </h3>
                </td>
                <td style="width: auto; text-align:center; border: 1px solid #000">
                    <h3><a href="/studentDetails/${item.login}"> ${item.login}</a>
                    </h3>
                </td>
                <td style="width: auto; text-align:center; border: 1px solid #000">
                    <h3>${item.firstName}
                    </h3>
                </td>
                <td style="width: auto; text-align:center; border: 1px solid #000">
                    <h3>${item.lastName}
                    </h3>
                </td>
                <td style="width: auto; text-align:center; border: 1px solid #000">
                    <h3>${item.indexNumber}
                    </h3>
                </td>
                <td style="width: auto; text-align:center; border: 1px solid #000">
                    <h3><a class="btn btn-danger btn-sm" href="/remove/${item.id}">X</a>
                    </h3>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
