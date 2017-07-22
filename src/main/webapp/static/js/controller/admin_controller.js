'use strict';

App.controller('AdminController', ['$scope', 'AdminService', function ($scope, AdminService) {
        var self = this;
        self.fee = {feId: null, feAmountTerm: null , feAmountYear: null, feAmountMonth: null, feRegistration: null, year:null, drMaCategory: {ctId : null, ctName:''} };
        self.fees = [];

        self.fetchAllFees = function () {
            AdminService.fetchAllFees()
            .then(
                    function (data) {
                        self.fees = data;
                    },
                    function (errResponse) {
                        console.error('Error while fetching Currencies');
                    }
            );
        };

         self.fetchAllCategory= function(){
            console.log("find all students category  ");
            AdminService.fetchAllCategory()
                    .then(
                            function (data) {
                                self.categories = data;
                            },
                            function (errResponse) {
                                console.error('Error while fetching All student Category');
                            }
                    );  
        };
        self.fetchAllFees();

        self.createFee = function (fee) {
            AdminService.createFee(fee)
                    .then(
                            self.fetchAllFees,
                            function (errResponse) {
                                console.error('Error while creating Fee.');
                            }
                    );
        };

        self.updateFee = function (fee, id) {
            AdminService.updateFee(fee, id)
                    .then(
                            self.fetchAllFees,
                            function (errResponse) {
                                console.error('Error while updating Fee.');
                            }
                    );
        };

        self.deleteFee = function (id) {
            AdminService.deleteFee(id)
                    .then(
                            self.fetchAllFees,
                            function (errResponse) {
                                console.error('Error while deleting Fee.');
                            }
                    );
        };

        self.submit = function () {
            if (self.fee.emId == null) {
                console.log('Saving New Fee', self.fee);
                self.createFee(self.fee);
            } else {
                self.updateFee(self.fee, self.fee.emId);
                console.log('Fee updated with id ', self.fee.emId);
            }
            self.reset();
        };

        self.edit = function (id) {
            console.log('id to be edited', id);
            for (var i = 0; i < self.fees.length; i++) {
                if (self.fees[i].emId == id) {
                    self.fee = angular.copy(self.fees[i]);
                    break;
                }
            }
        };

        self.remove = function (id) {
            console.log('id to be deleted', id);
            for (var i = 0; i < self.fees.length; i++) {
                if (self.fees[i].emId == id) {
                    self.reset();
                    break;
                }
            }
            self.deleteFee(id);
        };

        self.deleteFee = function (id) {
            AdminService.deleteFee(id)
                    .then(
                            self.fetchAllFees,
                            function (errResponse) {
                                console.error('Error while deleting Fee.');
                            }
                    );
        };
        self.reset = function () {
            self.fee = {emid: null, emName: '', emAddress: '', emEmail1: ''};
            $scope.myForm.$setPristine(); //reset Form
        };

}]);
