'use strict';
App.factory('StudentsFeesService', ['$http', '$q', function ($http, $q) {

        return {
            payStudentFees: function (fee) {
                return $http.post('http://localhost:8080/DrizzlyAdmin/payStudentfees/', fee)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching students by filter');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            findStudentsFees: function (id, name, mobile, email, category) {
                console.log("student.stId   ::  " + id + "   category   :: " + category);
                return $http.get('http://localhost:8080/DrizzlyAdmin/students/' + id + '/' + name + '/' + mobile + '/' + email + '/' + category)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching students by filter');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            findstudentsFeesByCategory: function (id, category) {
                console.log("student.stId   ::  " + id + "   category   :: " + category);
                return $http.get('http://localhost:8080/DrizzlyAdmin/students/' + id + '/' + category)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching students by filter');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            fetchStudentsByCategory: function (category) {
                return $http.get('http://localhost:8080/DrizzlyAdmin/studentsByCategory/' + category)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching students by filter');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            fetchStudentsByCategoryFeesmode: function (category,feesMode) {
                return $http.get('http://localhost:8080/DrizzlyAdmin/studentsByCategoryFeesmode/' + category +"/"+feesMode)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching students by filter');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            fetchStudentsById: function (StId) {
                return $http.get('http://localhost:8080/DrizzlyAdmin/studentsByStId/' + stId)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching students by filter');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            fetchAllEmployees: function () {
                return $http.get('http://localhost:8080/DrizzlyAdmin/employees/')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching employees');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            fetchAllCategory: function () {
                return $http.get('http://localhost:8080/DrizzlyAdmin/getAllCategory/')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching all Category');
                                    return $q.reject(errResponse);
                                }
                        );
            }
        };
    }]);
