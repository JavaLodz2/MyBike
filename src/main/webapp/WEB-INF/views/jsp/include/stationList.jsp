<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h1>Main stations</h1>
</div>

<div class="row">
    <div class="col-md-offset-1 col-md-10">
        <div class="panel panel-default">
            <%-- Default panel contents --%>
            <div class="panel-heading">City stations list</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <p>{Here will be map ;)}</p>
                    </div>
                </div>
            </div>

            <%-- Table --%>
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
                            <td scope="row">
                                    <%-- Station info --%>
                                <a href="/station/${station.stationId}" class="btn btn-primary btn-sm" role="button">
                                    View
                                </a>
                            </td>
                            <td>${station.street}</td>
                            <td>${station.bikeList.size()}</td>

                        </tr>
                    </c:forEach>
                </div>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>