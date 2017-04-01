<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h1>Main stations</h1>
</div>

<div class="row">
    <div class="col-md-offset-1 col-md-10">
        <div class="panel panel-default">
            <div class="panel-heading">Bikes of ${user.firstName} ${user.lastName}</div>
            <%-- Table --%>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Bike number</th>
                    <th>Rent on</th>
                    <th>#</th>
                </tr>
                </thead>
                <tbody>
                <form method="get" href="/return/${bike.bikeId}">
                    <div id="bikeList">
                        <c:forEach var="bike" items="${bikeList}">
                            <tr>
                                <td>Bike no ${bike.bikeId}</td>
                                <td>{last rent on ....}</td>
                                <td>
                                    <select name="stations">
                                    <c:forEach var="station" items="${stations}">
                                        <option value="${station.street}"}>${station.street}</option>
                                    </c:forEach>
                                </select>
                                </td>
                                <td>
                                    <input type="submit" class="btn btn-error btn-sm">
                                        Return
                                    </input>
                                </td>

                            </tr>
                        </c:forEach>
                    </div>
                </form>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>