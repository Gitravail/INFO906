<%--@elvariable id="package" type="fr.usmb.m2isc.chronopost.jpa.Package"--%>
<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 25/09/2020
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<h1>Monitor</h1>
${package.packageStatusList[0].coordinate}
<form method="post">
    <div class="form-group">
        <label for="id">Package's ID</label>
        <input type="number" class="form-control" name="id" id="id" placeholder="Enter package ID">
    </div>
    <button type="submit" class="btn btn-primary">Monitor package</button>
</form>
<%@include file="footer.jsp"%>
