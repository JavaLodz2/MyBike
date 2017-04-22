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
<div class="container">
    <div class="row">
        <div class="col-md-offset-1 col-md-10">
            <div class="panel panel-primary">
                <form:form action="/rent/ok" method="post" commandName="bike">
                    <%-- Default panel contents --%>
                    <form:hidden path="bikeId"></form:hidden>
                    <div class="panel-heading">You are about to rent bike no.${bike.bikeId} - from station
                        on ${station.street} street
                    </div>
                    <div class="panel-body">
                        <h4>Are you sure?</h4>
                    </div>

                    <div class="form-group">

                        <button type="submit" value="" class="btn-group btn-group-lg btn-success">OK rent
                        </button>
                        <a href="/stationsList" class="btn-group btn-group-lg btn-success" role="button">Go back
                        </a>
                    </div>
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
<spring:url value="${contextPath}/resources/js/bootstrap.min.js" var="bootstrapJs"/>
<script src="${bootstrapJs}"></script>
</body>
</html>

