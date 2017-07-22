'use strict';
App.factory('EmployeeService', ['$http', '$q', function($http, $q){

        return {

        fetchAllEmployees: function() {
        return $http.get('http://localhost:8080/DrizzlyAdmin/employees/')
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while fetching employees');
                                return $q.reject(errResponse);
                        }
                );
        },

        createEmployee: function(employee){
        return $http.post('http://localhost:8080/DrizzlyAdmin/employees/', employee)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while creating employees');
                                return $q.reject(errResponse);
                        }
                );
        },
        updateEmployee: function(employee, id){
        return $http.put('http://localhost:8080/DrizzlyAdmin/employees/' + id, employee)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while updating employees');
                                return $q.reject(errResponse);
                        }
                );
        },
        deleteEmployee: function(id){
        return $http.delete('http://localhost:8080/DrizzlyAdmin/employees/' + id)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while deleting employees');
                                return $q.reject(errResponse);
                        }
                );
        }

    };
}]);
