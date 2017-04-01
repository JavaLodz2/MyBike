<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <form:form method="post" action="/return" commandName="station">
                    <div id="bikeList">
                        <c:forEach var="bike" items="${bikeList}">
                            <tr>
                                <td>Bike no ${bike.bikeId}</td>
                                <form:hidden path="bike.bikeId"/>
                                <td>{last rent on ....}</td>
                                <td>
                                    <select name="stations">
                                        <c:forEach var="station" items="${stations}">
                                            <option name="${station.stationId}" value="${station.street}" }>${station.street}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td>
                                    <button type="submit" value="" class="btn-group btn-group-lg btn-success">Return
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </div>
                </form:form>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>