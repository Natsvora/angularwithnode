
angular.
        module('employeeApp').
        factory('User', ['$resource',
            function ($resource) {
                console.log("1123");
                return $resource('/user/:id', { id: '@id'}, {
                   'update':{
                       method:'PUT'
                   }
                });
            }
        ]);
