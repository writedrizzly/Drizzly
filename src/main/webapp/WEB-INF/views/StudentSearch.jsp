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

<!--                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="Confirm" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                        </div>
                    </div>-->
                </form>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading"><span class="lead">Student Fee Information </span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <tbody ng-repeat="stdn in ctrl.students">
                            <tr ng-if="stdn.stId === ctrl.fee.drMaStudent.stId">
                                <td>
                                    <table class="table table-hover">
                                        <tr> 
                                            <th  class="tableheder">Student ID</th><td><span ng-bind="ctrl.student.stId"></span></td> 
                                            <th  class="tableheder">Name</th><td><span ng-bind="ctrl.student.stName"></span></td>
                                            <th  class="tableheder">Mobile</th><td><span ng-bind="ctrl.student.stMobile1"></span></td> 
                                        </tr>
                                        <tr> 
                                            <th class="tableheder">This Month Fees</th><td><span ng-bind="ctrl.student.stThisMonthFees"></span></td> 
                                            <th class="tableheder">This Term Fees</th><td><span ng-bind="ctrl.student.stThisTearmFees"></span></td> 
                                            <th class="tableheder">This Year Fees</th><td><span ng-bind="ctrl.student.stThisYearFees"></span></td> 
                                            <th class="tableheder">This Year Registration Fees</th><td><span ng-bind="ctrl.student.stThisYearRegistration"></span></td> 
                                        </tr>
                                        <tr> 
                                            <th class="tableheder">Paid Total</th><td><span ng-bind="ctrl.student.stPaidTotal"></span></td>                                          
                                            <th class="tableheder">Balance to pay up to this month</th><td><span> {{ctrl.student.stYetToPayTotal}}</span></td> 
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <tbody ng-repeat="stdn in ctrl.students">
                            <tr ng-if="stdn.stId === ctrl.fee.drMaStudent.stId">
                                <td>
                                <table class="table table-hover">
                                    <thead class="tableheder table-hover">
                                    <th class="tableheder" colspan="2">Fees Paid details </th>
                                        <tr>
                                            <th>Date</th>
                                            <th>Amount</th>
                                        </tr>
                                    </thead>
                                    <tr ng-repeat="fees in stdn.drTrFeesDues">
                                        <td><span>{{fees.fpPaidDate| date: "dd/MM/yyyy"}}</span></td>
                                        <td><span ng-bind="fees.fpPaidAmount"></span></td>
                                    </tr>
                                </table>
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
    <script src="<c:url value='/static/js/service/custom_filter.js' />"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/controller/student_controller.js' />"></script>
    <script src="<c:url value='/static/js/service/student_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/studentfees_controller.js' />"></script>
    <script src="<c:url value='/static/js/service/studentfees_service.js' />"></script>

</html>
