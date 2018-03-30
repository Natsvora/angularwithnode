angular.
  module('core.phone').
  factory('Phone', ['$resource',
    function($resource) {
        console.log("1123");
      return $resource('phones/:phoneId.json', {}, {
        query: {
          method: 'GET',
          params: {phoneId: 'phones'},
          isArray: true
        }
      });
    }
  ]);

