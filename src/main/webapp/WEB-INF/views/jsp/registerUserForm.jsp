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
    <link rel="icon" href="../../favicon.ico">

    <title>MyBike - city bike rental system</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <spring:url value="/resources/core/css/sticky-footer-navbar.css" var="stickyCss"/>
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
                <h3 class="panel-title">>Register new user</h3>
            </div>
            <div class="panel-body">

                <form:form action="/registerUserForm" method="post" commandName="user">
                    <div class="form-group">
                        <form:label path="login">Login:</form:label>
                        <form:input class="form-control" id="login" path="login" type="text"/>
                        <form:errors path="login"/>
                    </div>

                    <div>
                        <form:label path="password">Password:</form:label>
                        <br>
                        <form:input class="form-control" id="password" path="password" type="text"/>
                        <form:errors path="password"/>
                    </div>

                    <div>
                        <form:label path="firstName">FirstName</form:label>
                        <br>
                        <form:input class="form-control" id="firstName" path="firstName" type="text"/>
                        <form:errors path="firstName"/>
                    </div>
                    <div>
                        <form:label path="lastName">LastName</form:label>
                        <br>
                        <form:input class="form-control" id="lastName" path="lastName" type="text"/>
                        <form:errors path="lastName"/>
                    </div>
                    <div>
                        <form:label path="contactNumber">ContactNumber</form:label>
                        <br>
                        <form:input class="form-control" id="contactNumber" path="contactNumber"
                                    type="text"/>
                        <form:errors path="contactNumber"/>
                    </div>
                    <form:hidden path="role" value="ROLE_USER"></form:hidden>
                    <br>
                    <input type="submit" class="btn btn-default" value="Sign Up">
                </form:form>

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
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
<script src="${bootstrapJs}"></script>
</body>
</html>


