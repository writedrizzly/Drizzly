'use strict';
        App.factory('StudentService', ['$http', '$q', function($http, $q){

        return {

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
        },
        
        findStudentsFees: function(id,name,mobile,email,category){
        console.log("student.stId   ::  "+id+"   category   :: "+category);
        return $http.get('http://localhost:8080/DrizzlyAdmin/students/' +id+'/'+name+'/'+mobile+'/'+email+'/'+category)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while fetching students by filter');
                                return $q.reject(errResponse);
                        }
                );
        },
        
        fetchAllStudents: function() {
        return $http.get('http://localhost:8080/DrizzlyAdmin/students/')
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while fetching students');
                                return $q.reject(errResponse);
                        }
                );
        },

        addStudent: function(student){
        return $http.post('http://localhost:8080/DrizzlyAdmin/students/', student)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while creating students');
                                return $q.reject(errResponse);
                        }
                );
        },
        updateStudent: function(student, id){
        return $http.put('http://localhost:8080/DrizzlyAdmin/students/' + id, student)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while updating students');
                                return $q.reject(errResponse);
                        }
                );
        },
        deleteStudent: function(id){
        return $http.delete('http://localhost:8080/DrizzlyAdmin/students/' + id)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while deleting students');
                                return $q.reject(errResponse);
                        }
                );
        }

    };
}]);
