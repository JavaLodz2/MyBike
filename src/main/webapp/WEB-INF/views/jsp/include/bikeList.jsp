<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h1>Main stations</h1>
</div>

<div class="row">
    <div class="col-md-offset-1 col-md-10">
        <div class="panel panel-default">
            <%-- Default panel contents --%>
            <div class="panel-heading">Station no.${station.stationId} - ${station.street} street - avaible bikes</div>
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
                    <th>Bike number</th>
                    <th>Last rent on</th>
                </tr>
                </thead>
                <tbody>
                <div id="bikeList">
                    <c:forEach var="bike" items="${bikeList}">
                        <tr>
                            <td scope="row">
                                    <%-- Station info --%>
                                <a href="/rent/${bike.bikeId}" class="btn btn-primary btn-sm" role="button">
                                    Rent
                                </a>
                            </td>
                            <td>Bike no ${bike.bikeId}</td>
                            <td>{last rent on ....}</td>

                        </tr>
                    </c:forEach>
                </div>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>