angular.
        module('employeeApp').
        config(['$locationProvider', '$routeProvider',
            function config($locationProvider, $routeProvider) {
//                $locationProvider.hashPrefix('!');
                $routeProvider.
                        when('/adduser', {
                            template: '<emp-add></emp-add>'
                        }).
                        when('/updateuser/:id', {
                            template: '<emp-add></emp-add>'
                        }).
                        when('/', {
                            template: '<emp-detail></emp-detail>'
                        });
            }
    
        ]);
