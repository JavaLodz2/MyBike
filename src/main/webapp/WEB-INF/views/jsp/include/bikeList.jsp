<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h1>Available bikes on station: "${stationStandingOn}"</h1>
</div>
<table class="table table-hover">

    <thead>

    <tr>
        <th>#</th>
        <th>Borrowed by</th>
    </tr>
    </thead>
    <tbody>
    <div id="studentList">
        <c:forEach var="bike" items="${bikeList}">
            <tr>
                <td>${bike.bikeId}</td>
                <td>${bike.userBorrowed}</td>
            </tr>
        </c:forEach>
    </div>
    </tbody>
</table>

</body>