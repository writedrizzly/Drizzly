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
        <div class="container"  ng-controller="StudentCFeesController
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

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Students Name</label>
                            <div class="col-md-7">
                                <select  ng-model="ctrl.fee.drMaStudent.stId" name="stId" 
                                         ng-options="student.stId as student.stName for student in ctrl.students" 
                                         ng-change="ctrl.findstudentsFeesByCategory(ctrl.fee.drMaStudent.stId, ctrl.categories.ctId)"
                                         class="inputtext form-control select-sm" 
                                         placeholder="Select the name of the Student." required>
                                </select>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stId.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stId.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Fees Mode</label>
                            <div class="col-md-7">
                                <div class = "input-group">

                                    <span class = "input-group-addon">
                                        <input type="radio" value="1" name="fpPaidMode" ng-model="ctrl.fee.fpPaidMode" placeholder="Select the payment mode." required > Year</input>
                                    </span>
                                    <span class = "input-group-addon">
                                        <input type="radio" value="2" name="fpPaidMode" ng-model="ctrl.fee.fpPaidMode" placeholder="Select the payment mode." required > Term</input>
                                    </span>
                                    <span class = "input-group-addon">
                                        <input type="radio" value="3" name="fpPaidMode" ng-model="ctrl.fee.fpPaidMode" placeholder="Select the payment mode." required > Month</input>
                                    </span>

                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.stName.$error.required">This is a required field</span>
                                        <span ng-show="myForm.stName.$invalid">This field is invalid </span>
                                    </div>
                                </div><!-- /input-group -->
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Amount to Pay</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.fee.fpPaidAmount" name="fpPaidAmount" class="inputtext form-control input-sm" placeholder="Enter the amount paid" required ng-minlength="3"/>                                    
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stName.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stName.$error.minlength">Minimum length required is 3</span>
                                    <span ng-show="myForm.stName.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Fees Paid Date</label>
                            <div class="col-md-7">
                                <input type="text" datepicker-popup="dd/MM/yyyy" ng-model="ctrl.fee.fpPaidDate" class="inputtext form-control input-sm" placeholder="Enter Fees Paid Date" required ng-minlength="10"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stName.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stName.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="form-group col-md-12" ng-init="ctrl.fetchAllEmployees()">
                            <label class="col-md-2 control-lable" for="file">Staff Name</label>
                            <div class="col-md-7">
                                <select  ng-model="ctrl.fee.fpPaidToStaff" 
                                         class="inputtext form-control select-sm" 
                                         placeholder="Select the name of the Staf..." required>
                                    <option value="{{employee.emId}}" ng-repeat="employee in ctrl.employees">
                                        {{employee.emName}}
                                    </option>
                                </select>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stId.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stId.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="Confirm" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                        </div>
                    </div>
                </form>
            </div>
            <div class="panel-heading">
                <div class="alert alert-success" ng-show="showSuccessAlert">
                    <button type="button" class="close" data-ng-click="switchBool('showSuccessAlert')"><strong>X close</strong></button> 
                <strong> <h3>Done! {{showSuccessTextAlert}}</h3></strong> 
                </div>
            </div>
            
            <div class="panel-heading">
                <div class="alert alert-danger" ng-show="showFailureAlert">
                <button type="button" class="close" data-ng-click="switchBool('showFailureAlert')">X close</button> 
                <strong> <h3>Done! {{showFailureTextAlert}}</h3></strong> 
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading"><span class="lead">Student Fee Information </span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                            <td>
                                <table class="table table-hover">
                                <thead class="tableheder table-hover">
                                <tr>
                                <th>Student ID</th>
                                <th>Name</th>
                                <th>Mobile</th>
                                <th>Paid Total</th>
                                <th>Balance to pay up to this month</th>
                                </tr>
                                </thead>
                            <tr>
                                <td><span ng-bind="ctrl.student.stId"></span></td> 
                                <td><span ng-bind="ctrl.student.stName"></span></td>
                                <td><span ng-bind="ctrl.student.stMobile1"></span></td> 
                                <td><span ng-bind="ctrl.student.stPaidTotal"></span></td>                                          
                                <td><span ng-bind="ctrl.student.stYetToPayTotal"></span></td> 
                            </tr>
                                </table>
                            </td></tr>
                        </tbody>
                    </table>
                </div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                                <td>
                                <table class="table table-hover">
                                    <thead class="tableheder table-hover">
                                    <th class="tableheder" colspan="2">Fees Paid details </th>
                                        <tr>
                                            <th>Date</th>
                                            <th>Amount</th>
                                        </tr>
                                    </thead>
                                    <tr ng-repeat="fees in ctrl.student.drTrFeesDues">
                                        <td><span>{{fees.fpPaidDate | date: "dd/MM/yyyy"}}</span></td>
                                        <td><span ng-bind="fees.fpPaidAmount"></span></td>
                                    </tr>
                                </table>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
        </div>
    </body>


    <script src="<c:url value='/static/js/vendor/angular.js'/>"></script>
    <script src="<c:url value='/static/js/vendor/angular-tablesort.js'/>"></script>
    <script src="<c:url value='/static/js/vendor/ui-bootstrap-tpls-0.5.0.js' />"></script>
    <script src="<c:url value='/static/js/service/custom_filter.js' />"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/controller/student_controller.js' />"></script>
    <script src="<c:url value='/static/js/service/student_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/studentfees_controller.js' />"></script>
    <script src="<c:url value='/static/js/service/studentfees_service.js' />"></script>

</html>
