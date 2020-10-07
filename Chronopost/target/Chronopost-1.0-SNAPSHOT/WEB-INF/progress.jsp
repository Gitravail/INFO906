<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 25/09/2020
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>

<h1>Progress</h1>
<form method="post">
    <div class="form-group">
        <label for="id">Package ID</label>
        <select class="form-control" id="id" name="id">
            <c:forEach var="id" items="${ids}">
                <c:choose>
                    <c:when test="${package.id == id}">
                        <option selected="selected">${id}</option>
                    </c:when>
                    <c:otherwise>
                        <option>${id}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Display progress</button>
</form>
<c:if test="${package.id != null}">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Latitude</th>
            <th scope="col">Longitude</th>
            <th scope="col">Date</th>
            <th scope="col">State</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="colis" items="${package.packageStatusList}" varStatus="status">
            <tr>
                <th>${colis.location}</th>
                <td>${colis.coordinate.latitude}</td>
                <td>${colis.coordinate.longitude}</td>
                <td>${colis.date}</td>
                <td>${colis.state}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</c:if>

<%@include file="footer.jsp" %>
