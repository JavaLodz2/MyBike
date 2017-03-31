<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
            aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="/">MyBike</a>
</div>
<div bookId="navbar" class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
        <li <c:if test="${menu eq 0}"> class="active" </c:if>><a href="/">Start</a></li>
        <li <c:if test="${menu eq 1}"> class="active" </c:if>><a href="/stationsList">Stations list</a></li>
        <li <c:if test="${menu eq 3}"> class="active" </c:if>><a href="/">Return bike</a></li>
        <li <c:if test="${menu eq 4}"> class="active" </c:if>><a href="/">Contact</a></li>
        <li <c:if test="${menu eq 5}"> class="active" </c:if>><a href="/">Login</a></li>
    </ul>
</div><!--/.nav-collapse -->