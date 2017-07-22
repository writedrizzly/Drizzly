var app = angular.module('CustomFilter', ['ui.bootstrap']);

app.directive('myformat', function (dateFilter) {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            ngModel.$parsers.push(function (viewValue) {
                return dateFilter(viewValue, 'yyyy-MM-dd');
            });
        }
    };
});
