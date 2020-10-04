<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 24/09/2020
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<h1>
    ${ id } ${ timestamp } ${ coordinate }
</h1>

<form method="post">
    <div class="form-group">
        <label for="weight">Weight</label>
        <input type="number" step="0.001" class="form-control" id="weight" name="weight" placeholder="Enter package weight">
    </div>
    <div class="form-group">
        <label for="value">Value</label>
        <input type="number" step="0.01" class="form-control" id="value" name="value" placeholder="Enter package value">
    </div>
    <div class="form-group">
        <label for="origin">Origin</label>
        <div id="origin" class="form-group row">
            <label for="originName" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input type="string" class="form-control" id="originName" name="originName" placeholder="Enter origin name">
            </div>
        </div>
        <div class="form-group row">
            <label for="originLat" class="col-sm-2 col-form-label">Latitude</label>
            <div class="col-sm-10">
                <input type="string" class="form-control" id="originLat" name="originLat" placeholder="Enter origin latitude">
            </div>
        </div>
        <div class="form-group row">
            <label for="originLong" class="col-sm-2 col-form-label">Longitude</label>
            <div class="col-sm-10">
                <input type="string" class="form-control" id="originLong" name="originLong" placeholder="Enter origin longitude">
            </div>
        </div>
    </div>
    <div class="form-group">
        <label for="destination">Destination</label>
        <div id="destination" class="form-group row">
            <label for="destinationName" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input type="string" class="form-control" id="destinationName" name="destinationName" placeholder="Enter destination name">
            </div>
        </div>
        <div class="form-group row">
            <label for="destinationLat" class="col-sm-2 col-form-label">Latitude</label>
            <div class="col-sm-10">
                <input type="string" class="form-control" id="destinationLat" name="destinationLat" placeholder="Enter destination latitude">
            </div>
        </div>
        <div class="form-group row">
            <label for="destinationLong" class="col-sm-2 col-form-label">Longitude</label>
            <div class="col-sm-10">
                <input type="string" class="form-control" id="destinationLong" name="destinationLong" placeholder="Enter destination longitude">
            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<%@include file="footer.jsp"%>
