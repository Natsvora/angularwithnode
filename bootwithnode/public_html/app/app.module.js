var app = angular.module('employeeApp', [
    'ngResource',
    'ngRoute',
    'empDetail',
    'ui.bootstrap',
    'login',
    'ngMessages'/*,
    'ngMockE2E'*/
]);
//app.run(['$httpBackend', function ($httpBackend) {
//        user = [
//            {
//                userId: 1,
//                username: 'Ada Lovelace',
//                mail: 'naimish@argusoft.in',
//                desi: 'Ba',
//                mno: '8445551815',
//                addr: 'gondal state',
//            },
//            {"userId": "123",
//                "username": "Nemi",
//                "mail": "naimishvora13@gmail.com",
//                "desi": "Developer",
//                "mno": "1231111111",
//                "addr": "asddddddddddddddddddddddddddddddddddddddddd",
//                "pass": "Nemi9099@",
//                "pass1": "Nemi9099@"},
//            {
//                userId: 2,
//                username: 'Grace Hopper',
//                mail: 'naimish@argusoft.in',
//                desi: 'Ba',
//                mno: '8445551906',
//                addr: 'gondal state'
//            },
//            {
//                userId: 3,
//                username: 'Charles Babbage',
//                mail: 'naimish@argusoft.in',
//                desi: 'Ba',
//                mno: '8445556433',
//                addr: 'gondal state'
//            }
//        ];
//        function findContactById(id) {
//            // Convert id to a number.
//            var contactId = Number(id);
//            var matches = user.filter(function (contact) {
//                return contact.userId == contactId;
//            });
//            var contact = matches.shift();
//            return contact;
//        }
//        ;
//
//// $httpBackend interactions are defined here…
//        $httpBackend.whenGET('/user').respond(user);
//        $httpBackend.whenPOST('/user').respond(function (method, url, data) {
//            var newContact = angular.fromJson(data);
//            user.push(newContact);
//            return [200, newContact, {}];
//        });
//
//        $httpBackend.whenDELETE(/\/user\/(\d+)/, undefined, ['id']).respond(function (method, url, data, headers, params) {
//            console.log(params.id);
//            var contact = findContactById(params.id);
//            if (contact == null) {
//                return [404, undefined, {}];
//            }
//
//            // Replace contacts array with filtered results, removing deleted contact.
//            user.splice(user.indexOf(contact), 1);
//            return [200, contact, {}];
//        });
//
//        $httpBackend.whenPUT('/user').respond(function (method, url, data, headers, params) {
//
//                    parsedData = angular.fromJson(data);
//                    console.log( parsedData.userId);
//                    var contact = findContactById(parsedData.userId);
//            if (contact == null) {
//                return [404, undefined, {}];
//            }
//
//            angular.extend(contact, parsedData);
//
//            return [200, contact, {}];
//        });
//
//
//        $httpBackend.whenRoute('GET', '/user/:id').respond(function (method, url, data, headers, params) {
//            var user = findContactById(params.id);
//            console.log("Mock" + user);
//            return [200, user, {}];
//        });
//
//        $httpBackend.whenGET(/\.html$/).passThrough();
//    }]);

   