<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>  
        <title>Drizzly Admin</title>  
        <link rel="stylesheet" href="<c:url value='/static/css/vendor/bootstrap.min.css' />" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value='/static/css/vendor/docs.min.css' />" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value='/static/css/app.css' />" rel="stylesheet">
    </head>
    <jsp:directive.include file="includes/DrizzlyHeader.jsp" />
    <body ng-app="myApp" class="ng-cloak">
        <div class="container" ng-controller="EmployeeController as ctrl">
            <jsp:directive.include file="includes/DrizzlyBanner.jsp" />
            <div class="formcontainer">
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.employee.emId" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.emName" name="emname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.emname.$error.required">This is a required field</span>
                                    <span ng-show="myForm.emname.$error.minlength">Minimum length required is 3</span>
                                    <span ng-show="myForm.emname.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Address</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.emAddress" class="form-control input-sm" placeholder="Enter your Address. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">City</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.emCity" class="form-control input-sm" placeholder="Enter your City. [This field is validation free]"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">PinCode</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.emPincode" name="emPincode" class="mobile form-control input-sm" placeholder="Enter your Pincode" required ng-minlength="6"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.emPincode.$error.required">This is a required field</span>
                                    <span ng-show="myForm.emPincode.$error.minlength">Minimum length required is 6</span>
                                    <span ng-show="myForm.emPincode.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Mobile</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.emMobile1" name="emmobile" class="mobile form-control input-sm" placeholder="Enter your mobile number" required ng-minlength="10"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.emmobile.$error.required">This is a required field</span>
                                    <span ng-show="myForm.emmobile.$error.minlength">Minimum length required is 10</span>
                                    <span ng-show="myForm.emmobile.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Email</label>
                            <div class="col-md-7">
                                <input type="email" ng-model="ctrl.employee.emEmail1" name="ememail" class="email form-control input-sm" placeholder="Enter your Email" required/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.ememail.$error.required">This is a required field</span>
                                    <span ng-show="myForm.ememail.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Joined Date</label>
                            <div class="col-md-7">
                                <input type="text" datepicker-popup="dd/MM/yyyy" ng-model="ctrl.employee.emJoinDate" name="emjoinDate" class="inputtext form-control input-sm" placeholder="Enter your joining Date dd/MM/yyyy" required ng-minlength="10"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.emjoinDate.$error.required">This is a required field</span>
                                    <span ng-show="myForm.emjoinDate.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.employee.emId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>

                </form>
            </div>

            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Employees </span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID.</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Email</th>
                                <th>Contact</th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="u in ctrl.employees">
                                <td><span ng-bind="u.emId"></span></td>
                                <td><span ng-bind="u.emName"></span></td>
                                <td><span ng-bind="u.emAddress"></span></td>
                                <td><span ng-bind="u.emEmail1"></span></td>
                                <td><span ng-bind="u.emMobile1"></span></td>
                                <td>
                                    <button type="button" ng-click="ctrl.edit(u.emId)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.emId)" class="btn btn-danger custom-width">Remove</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
</body>
        <script src="<c:url value='/static/js/vendor/angular.js'/>"></script>
        <script src="<c:url value='/static/js/vendor/angular-tablesort.js'/>"></script>
        <script src="<c:url value='/static/js/vendor/ui-bootstrap-tpls-0.5.0.js' />"></script>
        <script src="<c:url value='/static/js/app.js' />"></script>
        <script src="<c:url value='/static/js/service/custom_filter.js' />"></script>
        <script src="<c:url value='/static/js/service/employee_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/employee_controller.js' />"></script>
    
</html>
