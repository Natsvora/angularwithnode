angular.
        module('employeeApp').
        constant('baseURL', 'http://localhost:8080').
        factory('User', ['$resource', 'baseURL',
            function ($resource, baseURL) {
                return $resource(baseURL + '/user/:id', {id: '@id'}, {
                    'get': {method: 'GET'},
                    'save': {method: 'POST'},
                    'query': {method: 'GET', isArray: true},
                    'remove': {method: 'DELETE'},
                    'delete': {method: 'DELETE'},
                    'update':{method:'PUT'}
                });
            }
        ]);
