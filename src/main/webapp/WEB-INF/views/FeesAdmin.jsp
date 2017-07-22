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
        <div class="container"  ng-controller="AdminController
                as
                ctrl">

            <jsp:directive.include file="includes/DrizzlyBanner.jsp" />

            <!-- Main component for a primary marketing message or call to action -->
            <div class="formcontainer">
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <!--                    <input type="hidden" name="fpId" ng-model="ctrl.fees.fpId" />-->

                    <div class="row">
                        <div class="form-group col-md-12" ng-init="ctrl.fetchAllCategory()">
                            <label class="col-md-2 control-lable" for="file">Category</label>
                            <div class="col-md-7">
                                <select name='stCtId'
                                        ng-model="ctrl.categories.ctId" 
                                        ng-options="category.ctId as category.ctName for category in ctrl.categories" 
                                        ng-change="ctrl.fetchStudentsByCategory(ctrl.categories.ctId)"
                                        class="inputtext form-control select-sm" placeholder="Select your category." required>
                                </select>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stCtId.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stCtId.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                   
        </div>
    </body>


    <script src="<c:url value='/static/js/vendor/angular.js'/>"></script>
    <script src="<c:url value='/static/js/vendor/angular-tablesort.js'/>"></script>
    <script src="<c:url value='/static/js/vendor/ui-bootstrap-tpls-0.5.0.js' />"></script>
    <script src="<c:url value='/static/js/service/custom_filter.js' />"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/controller/student_controller.js' />"></script>
    <script src="<c:url value='/static/js/controller/admin_controller.js' />"></script>
    <script src="<c:url value='/static/js/service/admin_service.js' />"></script>

</html>
