<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${contextPath}/resources/favicon.ico">


    <title>MyBike - city bike rental system</title>

    <spring:url value="${contextPath}/resources/css/hello.css" var="coreCss"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <spring:url value="${contextPath}/resources/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <spring:url value="${contextPath}/resources/css/sticky-footer-navbar.css" var="stickyCss"/>
    <link href="${stickyCss}" rel="stylesheet"/>


</head>

<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <jsp:include page="include/myBikeHeader.jsp"/>
    </div>
</nav>

<!-- Begin page content -->
<c:url value="/login" var="loginUrl"/>

<c:if test="${error}">
    <div class="alert alert-danger fade in">
        <a class="close" data-dismiss="alert" href="#">&times;</a>
        <p>Username or password is incorrect</p>
    </div>
</c:if>

<c:if test="${logout}">
    <div class="alert alert-success fade in">
        <a class="close" data-dismiss="alert" href="#">&times;</a>
        <p>You've logged out</p>
    </div>
</c:if>

<div class="container">
    <div class="col-md-offset-3 col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Please log in</h3>
                <h4>For testing use : admin / admin</h4>
            </div>
            <div class="panel-body">
                <form name="form-signin" action="${loginUrl}" method="post">

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>

                    <div class="form-group">
                        <label for="login">Login</label>
                        <input type="text" class="form-control" id="login" name="login" placeholder="Login" required autofocus>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="Password" required>
                    </div>
                    <button type="submit" class="btn btn-default">Log in</button>
                    <a href="/registerUserForm" class="btn btn-default RIGHT-button">Registration form</a>
                </form>

            </div>
        </div>

    </div>
</div>

<footer class="footer">
    <jsp:include page="include/myBikeFooter.jsp"/>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<spring:url value="${contextPath}/resources/js/bootstrap.min.js" var="bootstrapJs"/>
<script src="${bootstrapJs}"></script>
</body>
</html>

