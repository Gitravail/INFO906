<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 25/09/2020
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<h1>Progress</h1>
<form method="get">
    <div class="form-group">
        <label for="id">Package's ID</label>
        <input type="number" class="form-control" id="id" placeholder="Enter package ID">
    </div>
    <button type="submit" class="btn btn-primary">Display progress</button>
</form>
<div id="map" class="map"></div>
<script type="text/javascript">
    var map = new ol.Map({
        target: 'map',
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM()
            })
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([37.41, 8.82]),
            zoom: 4
        })
    });
</script>
<%@include file="footer.jsp"%>
