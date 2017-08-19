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
    <!--    <div class="container">-->
    <body ng-app="myApp" class="ng-cloak">
        <div class="container"  ng-controller="AccountController as ctrl">
            
            <jsp:directive.include file="includes/DrizzlyBanner.jsp" />

            <!-- Main component for a primary marketing message or call to action -->
            <div class="formcontainer">
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" name="acId" ng-model="ctrl.account.acId" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="Credit">Credit</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.account.acCredit" name="acCredit" class="inputtext form-control input-sm" placeholder="0000.00" ng-minlength="3"/>                                    
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.acCredit.$error.required">Either Credit or debit is a required field</span>
                                    <span ng-show="myForm.acCredit.$error.minlength">Minimum length required is 2</span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="Debit">Debit</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.account.acDebit" name="acDebit" class="inputtext form-control input-sm" placeholder="0000.00" ng-minlength="3"/>                                    
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.acDebit.$error.required">Either Credit or debit is a required field</span>
                                    <span ng-show="myForm.acDebit.$error.minlength">Minimum length required is 2</span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="Debit Category">Debit/Credit Category</label>
                            <div class="col-md-7">
                                <select ng-model="ctrl.account.acCategory" 
                                        name="acCategory" class="inputtext form-control select-sm" 
                                        placeholder="Enter your mode of payment." 
                                        required  ng-minlength="1">
                                    <option value="">Select</option>
                                    <option value="1">Provisions</option>
                                    <option value="2">Advertisement</option>
                                    <option value="3">Rent</option>
                                    <option value="4">Study Materials</option>
                                    <option value="5">Loan</option>
                                    <option value="6">Fees</option>
                                    <option value="7">Management-Corporation Bank</option>
                                    <option value="8">Electrician & Plumber</option>
                                    <option value="9">Electric Bill</option>
                                    <option value="10">Mobile Bill</option>
                                    <option value="11">Salary</option>
                                    <option value="13">Management-Rajaguru</option>
                                    <option value="14">Management-Mullai</option>
                                    <!--<option value="12">Management</option>-->
                                </select>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.acCategory.$error.required">This is a required field</span>
                                    <span ng-show="myForm.acCategory.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12" ng-init="ctrl.fetchAllEmployees()">
                            <label class="col-md-2 control-lable" for="Staff Name">Staff Name</label>
                            <div class="col-md-7">
                                <select  name='acStaff'
                                         ng-model="ctrl.account.acStaff" 
                                         ng-options="employee.emId as employee.emName for employee in ctrl.employees" 
                                         class="inputtext form-control select-sm" 
                                         placeholder="Select the name of the Staff." required>
                                </select>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.acStaff.$error.required">This is a required field</span>
                                    <span ng-show="myForm.acStaff.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="Note">Note</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.account.acNote" name="acNote" class="inputtext form-control input-sm" placeholder="Enter your Note" required ng-minlength="5"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.acNote.$error.required">This is a required field</span>
                                    <span ng-show="myForm.acNote.$error.minlength">Minimum length required is 3</span>
                                    <span ng-show="myForm.acNote.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="Date">Date</label>
                            <div class="col-md-7">
                                <input type="text" datepicker-popup="dd/MM/yyyy" ng-model="ctrl.account.acDate"  name="acDate" class="inputtext form-control input-sm" placeholder="Select the Date" required ng-minlength="10"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.acDate.$error.required">This is a required field</span>
                                    <span ng-show="myForm.acDate.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.account.acId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>

                </form>
            </div>
            <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">Credits and Debits Detail</span></div>
            <div class="tablecontainer">
                <table class="table table-hover" ts-wrapper>
                    <thead class="tableheder table-hover">
                        <tr>
                            <th ts-criteria="Id">Id</th>
                            <th ts-criteria="Cerdit">Credit</th>
                            <th ts-criteria="Debit">Debit</th>
                            <th ts-criteria="Category">Category</th>
                            <th ts-criteria="Note">Note</th>
                            <th ts-criteria="Date">Date</th>
                            <th ts-criteria="Staff">Staff</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="accnt in ctrl.accounts" ts-repeat ts-hide-no-data>
                            <td><span ng-bind="accnt.acId"></span></td>
                            <td><span ng-bind="accnt.acCredit"></span></td>
                            <td><span ng-bind="accnt.acDebit"></span></td>
                            <td><span ng-bind="accnt.acCategory"></span></td>
                            <td><span ng-bind="accnt.acNote"></span></td>
                            <td><span ng-bind="accnt.acDate"></span></td>
                            <td><span ng-bind="accnt.acStaff"></span></td>
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
<script src="<c:url value='/static/js/controller/account_controller.js' />"></script>
<script src="<c:url value='/static/js/service/account_service.js' />"></script>
<script src="<c:url value='/static/js/controller/employee_controller.js' />"></script>
<script src="<c:url value='/static/js/service/employee_service.js' />"></script>
</html>
