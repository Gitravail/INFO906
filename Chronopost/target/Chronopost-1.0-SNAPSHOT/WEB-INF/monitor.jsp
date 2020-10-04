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
        <label for="id">Package's ID</label>
        <input type="number" class="form-control" id="id" name="id" placeholder="Enter package ID">
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
    </tr>
    </thead>
    <tbody>

        <c:forEach var="colis" items="${package.packageStatusList}" varStatus="status" >
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

<form method="post">
    <div class="form-group">
        <label for="name">Name</label>
        <input type="string" class="form-control" id="name" name="name" placeholder="Enter step name">
    </div>
    <div class="form-group">
        <label for="lat">Latitude</label>
        <input type="number" step="0.01" class="form-control" id="lat" name="lat" placeholder="Enter package value">
    </div>
    <div class="form-group">
        <label for="long">Longitude</label>
        <input type="string" class="form-control" id="long" name="long" placeholder="Enter package value">
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
