<%--
  Created by IntelliJ IDEA.
  User: raphael
  Date: 24/09/2020
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<h1>Homepage</h1>
<br />
<!-- Random name display -->
<h3>
    Hello ${ !empty name ? name : names[rnd]} !
</h3>
<%@include file="footer.jsp"%>
