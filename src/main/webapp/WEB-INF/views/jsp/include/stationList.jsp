<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h1>Main stations</h1>
</div>
<table class="table table-hover">
    <thead>

    <tr>
        <th>#</th>
        <th>Station address</th>
        <th>Number of bikes avaible</th>
    </tr>
    </thead>
    <tbody>
    <div id="studentList">
        <c:forEach var="station" items="${stationList}">
            <tr>
                <th scope="row">
                        <%-- Station info --%>
                        <a href="/station/${station.stationId}" class="btn btn-primary btn-sm" role="button">
                            <span class="glyphicon glyphicon-play" aria-hidden="true"></span>
                        </a>
                </th>
                <td>${station.street}</td>
                <td>${station.bikeList.size()}</td>

            </tr>
        </c:forEach>
    </div>
    </tbody>
</table>

</body>