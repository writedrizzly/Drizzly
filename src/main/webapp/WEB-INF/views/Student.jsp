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
        <div class="container"  ng-controller="StudentController as ctrl">
            
           <jsp:directive.include file="includes/DrizzlyBanner.jsp" />

            <!-- Main component for a primary marketing message or call to action -->
            <div class="formcontainer">
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" name="stId" ng-model="ctrl.student.stId" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.student.stName" name="stName" class="inputtext form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>                                    
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stName.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stName.$error.minlength">Minimum length required is 3</span>
                                    <span ng-show="myForm.stName.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12" ng-init="ctrl.fetchAllCategory()">
                            <label class="col-md-2 control-lable" for="file">Category</label>
                            <div class="col-md-7">
                                <select name="stCtId"
                                        ng-model="ctrl.student.drMaCategory.ctId" 
                                        ng-options="category.ctId as category.ctName for category in ctrl.categories" 
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
                            <label class="col-md-2 control-lable" for="file">Joining Date</label>
                            <div class="col-md-7">
                                <input type="text" datepicker-popup="dd/MM/yyyy" ng-model="ctrl.student.stJoinedDate" class="inputtext form-control input-sm" placeholder="Enter your joining Date" required ng-minlength="10"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stName.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stName.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Fees Mode</label>
                            <div class="col-md-7">
                                <select ng-model="ctrl.student.stFeesMode" class="inputtext form-control select-sm" placeholder="Enter your mode of payment." required ng-minlength="1">
                                    <option value="">Select</option>
                                    <option value="1">Year</option>
                                    <option value="2">Term</option>
                                    <option value="3">Month</option>
                                </select>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stName.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stName.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Father's Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.student.stFatherName" name="stFatherName" class="inputtext form-control input-sm" placeholder="Enter your FatherName" required ng-minlength="3"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stFatherName.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stFatherName.$error.minlength">Minimum length required is 3</span>
                                    <span ng-show="myForm.stFatherName.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Mother's Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.student.stMotherName" name="stMotherName" class="inputtext form-control input-sm" placeholder="Enter your MotherName" required ng-minlength="3"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stMotherName.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stMotherName.$error.minlength">Minimum length required is 3</span>
                                    <span ng-show="myForm.stMotherName.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Mobile1</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.student.stMobile1" name="stMobile" class="inputtext form-control input-sm" placeholder="Enter your mobile number" required ng-minlength="10"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stMobile1.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stMobile1.$error.minlength">Minimum length required is 10</span>
                                    <span ng-show="myForm.stMobile1.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Mobile2</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.student.stMobile2" name="stMobile2" class="inputtext form-control input-sm" placeholder="Enter alternate mobile"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stMobile2.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stMobile2.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">EMail</label>
                            <div class="col-md-7">
                                <input type="email" ng-model="ctrl.student.stEmail1" name="stEmail" class="email form-control input-sm" placeholder="Enter email id" required/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stEmail1.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stEmail1.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="file">Address</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.student.stAddress" class="inputtext form-control input-sm" placeholder="Enter your Address" required ng-minlength="5"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.stMobile2.$error.required">This is a required field</span>
                                    <span ng-show="myForm.stMobile2.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>
                    </div>   

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.student.stId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                            <button type="button" ng-click="ctrl.fetchAll()" class="btn btn-success custom-width">Fetch All</button>
                        </div>
                    </div>

                </form>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading"><span class="lead">List of Students </span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <thead class="tableheder table-hover">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Contact1</th>
                                <th>Contact2</th>
                                <th>Email</th>
                                <th>Category</th>
                                <th>Mode of Payment</th>
                                <th>Relieving data</th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="u in ctrl.students">
                                <td><span ng-bind="u.stId"></span></td>
                                <td><span ng-bind="u.stName"></span></td>
                                <td><span ng-bind="u.stMobile1"></span></td>
                                <td><span ng-bind="u.stMobile2"></span></td>
                                <td><span ng-bind="u.stEmail1"></span></td>
                                <td><span ng-bind="u.stCategory.ctName"></span></td>
                                <td><span ng-bind="u.stFeesMode"></span></td>
                                <td><span>
                                        {{u.stRelievedDate | date: "dd/MM/yyyy"}}
                                    </span>
                                </td>
                                <td>
                                    <button type="button" ng-click="ctrl.edit(u.stId)" class="btn btn-success custom-width">Edit</button>  
                                    <button type="button" ng-click="ctrl.remove(u.stId)" class="btn btn-danger custom-width">Remove</button>
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

<!--    </div>-->
</html>
