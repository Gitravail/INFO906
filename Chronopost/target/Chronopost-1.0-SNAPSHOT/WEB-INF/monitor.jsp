<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 25/09/2020
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<h1>Monitor</h1>

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
    <button type="submit" class="btn btn-primary">Monitor package</button>
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
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>

        <c:forEach var="packageStatus" items="${package.packageStatusList}" varStatus="status" >
        <tr>
            <th>${packageStatus.location}</th>
            <td>${packageStatus.coordinate.latitude}</td>
            <td>${packageStatus.coordinate.longitude}</td>
            <td>${packageStatus.date}</td>
            <td>${packageStatus.state}</td>
            <td>
                <form method="get" action="EditPackageStatusServlet">
                    <input type="number" hidden class="form-control" id="hiddenPackageID" name="packageId" value="${package.id}">
                    <input type="number" hidden class="form-control" id="hiddenID" name="packageStatusId" value="${packageStatus.id}">
                    <button type="submit" class="btn btn-primary">
                        Edit
                    </button>
                </form>

            </td>
        </tr>
        </c:forEach>

    </tbody>
</table>

<form method="post">
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" required id="name" name="name" placeholder="Enter step name">
    </div>
    <div class="form-group">
        <label for="lat">Latitude</label>
        <input type="text" class="form-control" required id="lat" name="lat" placeholder="Enter package value">
    </div>
    <div class="form-group">
        <label for="long">Longitude</label>
        <input type="text" class="form-control" required id="long" name="long" placeholder="Enter package value">
    </div>
    <div class="form-group">
        <label for="state">State</label>
        <select class="form-control" id="state" name="state">
            <option>REGISTRATION</option>
            <option>PENDING</option>
            <option>TRANSITING</option>
            <option>BLOCKED</option>
            <option>DELIVERED</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
</c:if>


<%@include file="footer.jsp"%>
