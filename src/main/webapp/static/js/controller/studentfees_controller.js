'use strict';

App.controller('StudentCFeesController', ['$scope', 'StudentsFeesService', function ($scope, StudentsFeesService) {
        var self = this;
        //self.student = {stId: null, drTrFeesDues: [{fpId: null, fpStId: null, fpAmountPaid: 0, fpPaidDate: '', fpMonth: '', fpTerm: '', fpYearly: ''}], drMaCategory: {ctId: null, ctName: ''}, stName: null, stJoinedDate: '', stFeesMode: '', stFatherName: '', stMotherName: '', stRelievedDate: null, stAddress: '', stCity: '', stState: '', stPincode: '', stCountry: '', stMobile1: null, stMobile2: '', stEmail1: '',stPaidTotal:'',stYetToPayTotal:'',stThisTearmFees:'',stThisMonthFees:'',stThisYearFees:''};

        //self.fee = {fpId: null, fpStId: null, fpPaidAmount: '', fpPaidDate: '', fpPaidMode: '', drMaStudent: {stId: null,drTrFeesDues:[{fpId:null,fpStId:null,fpAmountPAid:0,fpPaidDate:'',fpMonth:'',fpTerm:'',fpYearly:''}],drMaCategory:{ctId:null,ctName:''}, stName: '', stJoinedDate: '', stFeesMode: '', stFatherName: '', stMotherName: '', stRelievedDate: '', stAddress: '', stCity: '', stState: '', stPincode: '', stCountry: '', stMobile1: '', stMobile2: '', stEmail1: ''}};
        self.fee = {fpId: null, fpPaidAmount: '', fpPaidDate: '', fpPaidMode: '', fpPaidToStaff : null,drMaStudent: {stId: null,stCtId:null, stName: '', stJoinedDate: '', stFeesMode: '', stFatherName: '', stMotherName: '', stRelievedDate: '', stAddress: '', stCity: '', stState: '', stPincode: '', stCountry: '', stMobile1: '', stMobile2: '', stEmail1: ''}};
        self.category = {id: null, name: ''};
        self.fees = [];
        self.students = [];
        self.categories = [];
        self.employee = {emId: null, emName: '', emJoinDate: '', emSalary: '', emReleivedDate: '', emAddress: '', emCity: '', emState: '', emPincode: '', emCountry: '', emMobile1: '', emMobile2: '', emEmail1: ''};
        self.employees = [];
        
        self.fetchStudentsByCategory = function (categoryId) {
            console.log("find Students belong the categoryId  " + categoryId);
            StudentsFeesService.fetchStudentsByCategory(categoryId)
                    .then(
                            function (data) {
                                self.students = data;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Currencies');
                            }
                    );
        };
        self.fetchAllCategory= function(){
            console.log("find all students category  ");
            StudentsFeesService.fetchAllCategory()
                    .then(
                            function (data) {
                                self.categories = data;
                            },
                            function (errResponse) {
                                console.error('Error while fetching All student Category');
                            }
                    );  
        };
        // switch flag
        $scope.switchBool = function (value) {
            $scope[value] = !$scope[value];
        };
        self.payStudentFees = function (fee) {
            console.log("payStudentFees");
            StudentsFeesService.payStudentFees(fee)
                    .then(
                            //self.findStudent(fee.drMaStudent.stId,null,null,null,null),
                            function (data) {
                                console.log("payment success");
                                //self.categories = data;
                                self.findstudentsFeesByCategory(fee.drMaStudent.stId,self.categories.ctId);
                                //self.fetchStudentsByCategory(self.categories.ctId);
                                $scope.showSuccessTextAlert = "Fees Payment SUCCESS";
                                $scope.showSuccessAlert = true;

                                // switch flag
                                switchBool(value);
                            },
                            function (errResponse) {
                                console.error('Error while fetching payStudentFees');
                                $scope.showFailureTextAlert = "Error in Fees Payment";
                                $scope.showFailureAlert = true;

                                // switch flag
                                switchBool(value);
                            }
                    );
        };
        
        self.findStudent = function (id,name,mobile,emil,category) {
            console.log("findStudent  :: "+mobile);
            console.log("findStudent id  :: "+id);
            console.log("findStudent category :: "+category);
            StudentsFeesService.findStudentsFees(id,name,mobile,emil,category)
                    .then(
                            function (data) {
                                self.students = data;
                            },
                            function (errResponse) {
                                console.error('Error while fetching findStudent');
                            }
                    );
        };

        self.findstudentsFeesByCategory = function (id,category) {
            console.log("findStudent id  :: "+id);
            console.log("findStudent category :: "+category);
            StudentsFeesService.findstudentsFeesByCategory(id,category)
                    .then(
                            function (data) {
                                self.student = data;
                                console.log("findStudent stThisMonthFees :: "+self.student.stThisMonthFees);
                                //switchBool('showSuccessAlert');
                            },
                            function (errResponse) {
                                self.student = {};
                                console.error('Error while fetching findstudentsFeesByCategory');
                            }
                    );
        };
        
        self.submit = function () {
            self.payStudentFees(self.fee);
            self.reset();
        };

        self.reset = function () {
            self.fee = {fpId: null, fpPaidAmount: '', fpPaidMode: '', fpPaidDate: ''};
            self.category = {id: null, name: ''};
            $scope.myForm.$setPristine(); //reset Form
        };
        
        self.fetchAllEmployees = function () {
            StudentsFeesService.fetchAllEmployees()
                .then(
                    function (data) {
                        self.employees = data;
                    },
                    function (errResponse) {
                        console.error('Error while fetching employees');
                    }
                );
        };

    }]);
