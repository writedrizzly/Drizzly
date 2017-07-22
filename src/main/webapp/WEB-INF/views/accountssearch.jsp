<!DOCTYPE html>
<meta charset="utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>  
        <title>Drizzly Admin</title>  
        <meta http-equiv="content-type" content="text/html; charset=UTF8">
        <link rel="stylesheet" href="<c:url value='/static/css/vendor/bootstrap.min.css' />" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value='/static/css/vendor/bootstrap-theme.min.css' />" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value='/static/css/vendor/docs.min.css' />" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value='/static/css/app.css' />" rel="stylesheet">
        <script src="<c:url value='/static/js/vendor/charts/highcharts.js'/>"></script>
        <script src="<c:url value='/static/js/vendor/charts/exporting.js'/>"></script>
    </head>
    <jsp:directive.include file="includes/DrizzlyHeader.jsp" />
    <!--    <div class="container">-->
    <body ng-app="myApp" class="ng-cloak">
        <div class="container"  ng-controller="AccountController as ctrl">
            
            <jsp:directive.include file="includes/DrizzlyBanner.jsp" />

            <!-- Main component for a primary marketing message or call to action -->
            <div class="formcontainer">
                <form ng-submit="ctrl.find()" name="myForm" class="form-horizontal">
                    <input type="hidden" name="acId" ng-model="ctrl.account.acId" />
                    
                    <div class="row">
                        <div class="form-group col-md-12">
                            <div class="col-md-1">
                                <label for="file">From Date</label>
                            </div>
                            <div class="col-md-3">
                                <input type="text" datepicker-popup="dd/MM/yyyy" ng-model="ctrl.account.acFromDate"  name="acFromDate" class="inputtext form-control input-sm" placeholder="Select the Date" required ng-minlength="10"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.acFromDate.$error.required">This is a required field</span>
                                    <span ng-show="myForm.acFromDate.$invalid">This field is invalid </span>
                                </div>
                            </div>
                            <div class="col-md-1">
                                <label for="file">To Date</label>
                            </div>
                            <div class="col-md-3">
                                <input type="text" datepicker-popup="dd/MM/yyyy" ng-model="ctrl.account.acToDate"  name="acToDate" class="inputtext form-control input-sm" placeholder="Select the Date" required ng-minlength="10"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.acToDate.$error.required">This is a required field</span>
                                    <span ng-show="myForm.acToDate.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="form-group col-md-12" ng-init="ctrl.fetchAllEmployees()">
                            <div class="col-md-1">
                            <label for="file">Staff</label>
                            </div>
                            <div class="col-md-3">
                                <select name='acStaff'
                                        ng-model="ctrl.account.acStaff" 
                                        class="inputtext form-control select-sm" placeholder="Select Staff.">
                                    <option value="-1">All</option>
                                    <option value="{{employee.emId}}" ng-repeat="employee in ctrl.employees">
                                        {{employee.emName}}
                                    </option>
                                </select>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.acStaff.$error.required">This is a required field</span>
                                    <span ng-show="myForm.acStaff.$invalid">This field is invalid </span>
                                </div>
                            </div>
                            <div class="col-md-1">
                            <label for="Debit Category">Debit/Credit Category</label>
                            </div>
                            <div class="col-md-3">
                                <select ng-model="ctrl.account.acCategory" 
                                        name="acCategory" class="inputtext form-control select-sm" 
                                        placeholder="Enter your mode of payment." 
                                        ng-minlength="1">
                                    <option value="">All</option>
                                    <option value="1">Provisions</option>
                                    <option value="2">Advertisement</option>
                                    <option value="3">Rent</option>
                                    <option value="4">Study Materials</option>
                                    <option value="5">Loan</option>
                                    <option value="6">Fees</option>
                                    <option value="7">Given to management</option>
                                    <option value="8">Electrician & Plumber</option>
                                    <option value="9">Electric Bill</option>
                                    <option value="10">Mobile Bill</option>
                                    <option value="11">Salary</option>
                                    <option value="12">Received From Management</option>
                                </select>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.acCategory.$error.required">This is a required field</span>
                                    <span ng-show="myForm.acCategory.$invalid">This field is invalid </span>
                                </div>
                            </div>
                            <div class="form-actions floatRight">
                                <input type="submit"  value="Find" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                                <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                            </div>
                        </div>
                        
                    </div>
                </form>
            </div>
        
    <div id="containerchart" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

        <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">Credits and Debits Detail</span></div>
            <div class="tablecontainer">
                <table class="table table-hover" ts-wrapper>
                    <thead class="tableheder table-hover">
                        <tr>
                            <th ng-click="sort('acId')">
                            <span class="glyphicon sort-icon" ng-show="sortKey=='acId'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                            </th>
                            <th ng-click="sort('acCredit')">Credit
                            <span class="glyphicon sort-icon" ng-show="sortKey=='acCredit'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                            </th>
                            <th ng-click="sort('acDebit')">Debit
                            <span class="glyphicon sort-icon" ng-show="sortKey=='acDebit'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                            </th>
                            <th ng-click="sort('acCategory')">Category
                            <span class="glyphicon sort-icon" ng-show="sortKey=='acCategory'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                            </th>
                            <th ng-click="sort('acNote')">Note</th>
                            <th ng-click="sort('acDate')">Date
                            <span class="glyphicon sort-icon" ng-show="sortKey=='acDate'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                            </th>
                            <th ng-click="sort('acStaff')">Staff
                            <span class="glyphicon sort-icon" ng-show="sortKey=='acStaff'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
                            </th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <form class="form-inline">
                            <div class="form-group">
                                <label >Page Filter</label>
                                <input type="text" ng-model="search" class="form-control" placeholder="Search">
                            </div>
                        </form>
                    <tr  class="tableheder table-hover" ><td colspan="7" align="center"> School Account</td></tr>
                        <tr ng-repeat="accnt in ctrl.accounts | orderBy:sortKey:reverse | filter:search" ng-model="search" ts-repeat ts-hide-no-data>
                            <td><span></span></td>
                            <td><span ng-bind="accnt.acCredit"></span></td>
                            <td><span ng-bind="accnt.acDebit"></span></td>
                            <td><span ng-bind="accnt.acCategory"></span></td>
                            <td><span ng-bind="accnt.acNote"></span></td>
                            <td><span ng-bind="accnt.acDate"></span></td>
                            <td><span ng-bind="accnt.acStaff"></span></td>
                        </tr>
                        <tr class="tableheder table-hover">
                            <td class="info">Total</td>
                            <td class="info">{{ctrl.creditTotal}}</td>
                            <td class="info">{{ctrl.debitTotal}}</td>
                            <td class="success" colspan="2">Net Balance</td>
                            <td class="info" colspan="2">
                                <span ng-if="ctrl.creditTotal - ctrl.debitTotal > 0" style="background-color: #0C0">
                                    {{ctrl.creditTotal - ctrl.debitTotal}}
                                </span>
                                <span ng-if="ctrl.creditTotal - ctrl.debitTotal <= 0" style="background-color: #C00">
                                    {{ctrl.creditTotal - ctrl.debitTotal}}
                                </span>
                            </td>
                        </tr>
<!--                        <ul ng-if="ctrl.pager.pages.length" class="pagination">
                            <li ng-class="{disabled:ctrl.pager.currentPage === 1}">
                                <a ng-click="ctrl.setPage(1)">First</a>
                            </li>
                            <li ng-class="{disabled:ctrl.pager.currentPage === 1}">
                                <a ng-click="ctrl.setPage(ctrl.pager.currentPage - 1)">Previous</a>
                            </li>
                            <li ng-repeat="page in ctrl.pager.pages" ng-class="{active:ctrl.pager.currentPage === page}">
                                <a ng-click="ctrl.setPage(page)">{{page}}</a>
                            </li>                
                            <li ng-class="{disabled:ctrl.pager.currentPage === ctrl.pager.totalPages}">
                                <a ng-click="ctrl.setPage(ctrl.pager.currentPage + 1)">Next</a>
                            </li>
                            <li ng-class="{disabled:ctrl.pager.currentPage === ctrl.pager.totalPages}">
                                <a ng-click="ctrl.setPage(ctrl.pager.totalPages)">Last</a>
                            </li>
                        </ul>-->
                        <tr class="tableheder table-hover"><td colspan="7" align="center"> Management Account</td></tr>
                        <tr ng-repeat="mgmntAccnt in ctrl.mgmntAccount | orderBy:sortKey:reverse | filter:search" ng-model="search" ts-repeat ts-hide-no-data>
                            <td><span></span></td>
                            <td><span ng-bind="mgmntAccnt.acCredit"></span></td>
                            <td><span ng-bind="mgmntAccnt.acDebit"></span></td>
                            <td><span ng-bind="mgmntAccnt.acCategory"></span></td>
                            <td><span ng-bind="mgmntAccnt.acNote"></span></td>
                            <td><span ng-bind="mgmntAccnt.acDate"></span></td>
                            <td><span ng-bind="mgmntAccnt.acStaff"></span></td>
                        </tr>
                        <tr class="tableheder table-hover">
                            <td class="info">Total</td>
                            <td class="info">{{ctrl.mgmntCreditTotal}}</td>
                            <td class="info">{{ctrl.mgmntDebitTotal}}</td>
                            <td class="success" colspan="2">Net Balance</td>
                            <td class="info" colspan="2">
                                <span ng-if="ctrl.mgmntCreditTotal - ctrl.mgmntDebitTotal > 0" style="background-color: #0C0">
                                    {{ctrl.mgmntCreditTotal - ctrl.mgmntDebitTotal}}
                                </span>
                                <span ng-if="ctrl.mgmntCreditTotal - ctrl.mgmntDebitTotal <= 0" style="background-color: #C00">
                                    {{ctrl.mgmntCreditTotal - ctrl.mgmntDebitTotal}}
                                </span>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <dir-pagination-controls
                    max-size="5"
                    direction-links="true"
                    boundary-links="true" >
                </dir-pagination-controls>
            </div>
        </div>
        </div>
    
        </div>
    </body>

<script src="<c:url value='/static/js/service/custom_filter.js' />"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/controller/account_controller.js' />"></script>
<script src="<c:url value='/static/js/service/account_service.js' />"></script>
</html>
