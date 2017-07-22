'use strict';

App.controller('StudentController', ['$scope', 'StudentService', function ($scope, StudentService) {
        var self = this;
        self.student = {stId:null,drTrFeesDues:[{fpId:null,fpStId:null,fpPaidAmount:'',fpPaidDate:'',fpPaidMode:''}],drMaCategory:{ctId:null,ctName:''},stName:null,stJoinedDate:'',stFeesMode:'',stFatherName:'',stMotherName:'',stRelievedDate:null,stAddress:'',stCity:'',stState:'',stPincode:'',stCountry:'',stMobile1:null,stMobile2:'',stEmail1:null,stPaidTotal:null,stYetToPayTotal:null,stThisTearmFees:null,stThisMonthFees:null,stThisYearFees:null};
        self.category = {id: null, name: ''};
        self.students = [];
        
        self.categories = [];

        self.fetchAllStudents = function () {
            StudentService.fetchAllStudents()
                    .then(
                            function (data) {
                                self.students = data;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Currencies');
                            }
                    );
        };;
        self.fetchAllCategory= function(){
            console.log("find all students category  ");
            StudentService.fetchAllCategory()
                    .then(
                            function (data) {
                                self.categories = data;
                            },
                            function (errResponse) {
                                console.error('Error while fetching All student Category');
                            }
                    );  
        };

        self.createStudent = function (student) {
            StudentService.addStudent(student)
                    .then(
                            self.fetchAllStudents,
                            function (errResponse) {
                                console.error('Error while creating Student.');
                            }
                    );
        };

        self.findStudent = function (id,name,mobile,emil,category) {
            console.log("findStudent  :: "+mobile);
            console.log("findStudent id  :: "+id);
            console.log("findStudent category :: "+category);
            StudentService.findStudentsFees(id,name,mobile,emil,category)
                    .then(
                            function (data) {
                                self.students = data;
                            },
                            function (errResponse) {
                                console.error('Error while fetching Currencies');
                            }
                    );
        };
         self.updateStudent = function (student, id) {
            StudentService.updateStudent(student, id)
                    .then(
                            self.fetchAllStudents,
                            function (errResponse) {
                                console.error('Error while updating Student.');
                            }
                    );
        }; 
       
        self.submit = function () {
            if (self.student.stId == null) {
                console.log('Saving New Student', self.student);
                self.createStudent(self.student);
            } else {
                console.log('Student updated with id ', self.student.stId);
                self.updateStudent(self.student, self.student.stId);
            } 
            self.reset();
        };

        self.edit = function (id) {
            console.log('id to be edited', id);
            for (var i = 0; i < self.students.length; i++) {
                if (self.students[i].stId == id) {
                    self.student = angular.copy(self.students[i]);
                    break;
                }
            }
        };
        self.find = function () {
            self.students = [];
            self.findStudent(self.student.stId,self.student.stName,self.student.stMobile1,self.student.stEmail1,self.student.drMaCategory.ctId);
        };
        
        self.fetchAll= function () {
            console.log('fetchAllStudents');
            self.fetchAllStudents();
        };
        self.remove = function (id) {
            console.log('id to be deleted', id);
            for (var i = 0; i < self.students.length; i++) {
                if (self.students[i].stId == id) {
                    self.reset();
                    break;
                }
            }
            self.deleteStudent(id);
        };

        self.deleteStudent = function (id) {
            StudentService.deleteStudent(id)
                    .then(
                            self.fetchAllStudents,
                            function (errResponse) {
                                console.error('Error while deleting Student.');
                            }
                    );
        };
        self.reset = function () {
            self.student = {stId: null, stName: '', stFeesMode: '', stCategory: '',stMobile1:'',stMobile2:''};
            $scope.myForm.$setPristine(); //reset Form
        };

}]);
