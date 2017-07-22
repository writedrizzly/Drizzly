'use strict';

App.controller('EmployeeController', ['$scope', 'EmployeeService', function ($scope, EmployeeService) {
        var self = this;
        self.employee = {emId: null, emName: '', emJoinDate: '', emSalary: '', emReleivedDate: '', emAddress: '', emCity: '', emState: '', emPincode: '', emCountry: '', emMobile1: '', emMobile2: '', emEmail1: ''};
        self.employees = [];

        self.fetchAllEmployees = function () {
            EmployeeService.fetchAllEmployees()
                    .then(
                            function (data) {
                                self.employees = data;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Currencies');
                            }
                    );
        };


        self.fetchAllEmployees();

        self.createEmployee = function (employee) {
            EmployeeService.createEmployee(employee)
                    .then(
                            self.fetchAllEmployees,
                            function (errResponse) {
                                console.error('Error while creating Employee.');
                            }
                    );
        };

        self.updateEmployee = function (employee, id) {
            EmployeeService.updateEmployee(employee, id)
                    .then(
                            self.fetchAllEmployees,
                            function (errResponse) {
                                console.error('Error while updating Employee.');
                            }
                    );
        };

        self.deleteEmployee = function (id) {
            EmployeeService.deleteEmployee(id)
                    .then(
                            self.fetchAllEmployees,
                            function (errResponse) {
                                console.error('Error while deleting Employee.');
                            }
                    );
        };

        self.submit = function () {
            if (self.employee.emId == null) {
                console.log('Saving New Employee', self.employee);
                self.createEmployee(self.employee);
            } else {
                self.updateEmployee(self.employee, self.employee.emId);
                console.log('Employee updated with id ', self.employee.emId);
            }
            self.reset();
        };

        self.edit = function (id) {
            console.log('id to be edited', id);
            for (var i = 0; i < self.employees.length; i++) {
                if (self.employees[i].emId == id) {
                    self.employee = angular.copy(self.employees[i]);
                    break;
                }
            }
        };

        self.remove = function (id) {
            console.log('id to be deleted', id);
            for (var i = 0; i < self.employees.length; i++) {
                if (self.employees[i].emId == id) {
                    self.reset();
                    break;
                }
            }
            self.deleteEmployee(id);
        };

        self.deleteEmployee = function (id) {
            EmployeeService.deleteEmployee(id)
                    .then(
                            self.fetchAllEmployees,
                            function (errResponse) {
                                console.error('Error while deleting Employee.');
                            }
                    );
        };
        self.reset = function () {
            self.employee = {emid: null, emName: '', emAddress: '', emEmail1: ''};
            $scope.myForm.$setPristine(); //reset Form
        };

}]);
