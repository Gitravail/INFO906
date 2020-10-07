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
                <option>${id}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Monitor package</button>
</form>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">
                <p>Change values you want to update</p>


                <form method="post">
                    <div class="form-group">
                        <label for="changeName">Name</label>
                        <input type="text" class="form-control" id="changeName" name="changeName" placeholder="Enter step name">
                    </div>
                    <div class="form-group">
                        <label for="changeLat">Latitude</label>
                        <input type="text" class="form-control" id="changeLat" name="changeLat" placeholder="Enter package value">
                    </div>
                    <div class="form-group">
                        <label for="changeLong">Longitude</label>
                        <input type="text" class="form-control" id="changeLong" name="changeLong" placeholder="Enter package value">
                    </div>
                    <div class="form-group">
                        <label for="changeDate">Date</label>
                        <input type="text" class="form-control" id="changeDate" name="changeDate" placeholder="Enter date">
                    </div>
                    <div class="form-group">
                        <label for="changeState">State</label>
                        <select class="form-control" id="changeState" name="changeState">
                            <option>REGISTRATION</option>
                            <option>PENDING</option>
                            <option>TRANSITING</option>
                            <option>BLOCKED</option>
                            <option>DELIVERED</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Update</button>
                </form>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

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

        <c:forEach var="colis" items="${package.packageStatusList}" varStatus="status" >
        <tr>
            <th>${colis.location}</th>
            <td>${colis.coordinate.latitude}</td>
            <td>${colis.coordinate.longitude}</td>
            <td>${colis.date}</td>
            <td>${colis.state}</td>
            <td>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    Edit
                </button>
            </td>
        </tr>
        </c:forEach>

    </tbody>
</table>

<form method="post">
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="Enter step name">
    </div>
    <div class="form-group">
        <label for="lat">Latitude</label>
        <input type="text" class="form-control" id="lat" name="lat" placeholder="Enter package value">
    </div>
    <div class="form-group">
        <label for="long">Longitude</label>
        <input type="text" class="form-control" id="long" name="long" placeholder="Enter package value">
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
