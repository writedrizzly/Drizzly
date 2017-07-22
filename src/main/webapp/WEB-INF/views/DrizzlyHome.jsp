<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>  
        <title>Drizzly Admin</title>  
        <link rel="stylesheet" href="<c:url value='/static/css/vendor/bootstrap.min.css' />" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value='/static/css/vendor/docs.min.css' />" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value='/static/css/app.css' />" rel="stylesheet">
    </head>

    <jsp:directive.include file="includes/DrizzlyHeader.jsp" />
    
    <body ng-app="myApp" class="ng-cloak">
        
        <div class="container">
            <jsp:directive.include file="includes/DrizzlyBanner.jsp" />
            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div id="navbar" class="navbar-collapse collapse banner-color-blue">
                        <ul class="nav navbar-nav">
                            <li><a href="/DrizzlyAdmin/employees"><span class="lead"><img alt="" src="<c:url value='/static/img/emp.jpg' />" class="avatar avatar-100 photo" height="70" width="100"></span><h3>Employee</h3></a></li>
                        </ul>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse banner-color-green">
                        <ul class="nav navbar-nav">
                            <li><a href="/DrizzlyAdmin/studentSearch"><span class="lead"><img alt="" src="<c:url value='/static/img/std.jpg' />" class="avatar avatar-100 photo" height="70" width="100"></span><h3>Student</h3></a></li>
                        </ul>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse banner-color-blue">
                        <ul class="nav navbar-nav">
                            <li><a href="/DrizzlyAdmin/accounts/accountssearch"><span class="lead"><img alt="" src="<c:url value='/static/img/acc.jpg' />" class="avatar avatar-100 photo" height="70" width="100"></span><h3>Accounts</h3></a></li>
                        </ul>
                    </div>
                </div><!--/.container-fluid -->
            </nav>
        </div>
    </body>

    <jsp:directive.include file="includes/DrizzlyFooter.jsp" />

    <script src="<c:url value='/static/js/vendor/angular.js'/>"></script>
    <script src="<c:url value='/static/js/vendor/angular-tablesort.js'/>"></script>
    <script src="<c:url value='/static/js/vendor/ui-bootstrap-tpls-0.5.0.js' />"></script>
    <script src="<c:url value='/static/js/service/custom_filter.js' />"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>

</html>
