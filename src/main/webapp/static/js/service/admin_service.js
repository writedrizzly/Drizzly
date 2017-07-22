'use strict';
App.factory('AdminService', ['$http', '$q', function($http, $q){

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
        
        fetchAllFees: function() {
        return $http.get('http://localhost:8080/DrizzlyAdmin/admin/fee/' + year)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while fetching fees');
                                return $q.reject(errResponse);
                        }
                );
        },

        createFee: function(fee){
        return $http.post('http://localhost:8080/DrizzlyAdmin/admin/fee/', fee)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while creating fees');
                                return $q.reject(errResponse);
                        }
                );
        },
        updateFee: function(fee, id){
        return $http.put('http://localhost:8080/DrizzlyAdmin/admin/fee/' + id, fee)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while updating fees');
                                return $q.reject(errResponse);
                        }
                );
        },
        deleteFee: function(id){
        return $http.delete('http://localhost:8080/DrizzlyAdmin/admin/fee/' + id)
                .then(
                        function(response){
                        return response.data;
                        },
                        function(errResponse){
                        console.error('Error while deleting fees');
                                return $q.reject(errResponse);
                        }
                );
        }

    };
}]);
