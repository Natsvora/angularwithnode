angular.
        module('login').
        component('empAdd', {
            templateUrl: 'app/login/login.template.html',
            controller: ['User', '$location', '$routeParams', function hello(User, $location, $routeParams) {

                    
                    var self = this;
                    var validated;
                    if ($routeParams.id)
                    {
                        console.log("calllllll");
                        var param = $routeParams.id;
                        console.log("me" + param);
                         var d= User.get({id: param});
                         self.user = d;
                        self.user.dt = '29/03/1997'; 
                        self.registered = true;

                        self.save = function () {
                            //self.registered=false;    
                            var data = self.user;
                            //console.log(data);
                            self.userForm.pass1.$setValidity("passset", true);
                            self.userForm.pass1.setVaiblity = false;
                            self.userForm.pass.$setValidity("passset", true);
                            console.log(self.user);
                            //if (self.userForm.$valid)
                            {
                                var newUser = new User(data);
                                newUser.$update(function () {
                                    $location.path("/");
                                });
                            }

                        };
                    } else
                    {
                        self.save = function () {

                            var data = self.user;
                            console.log(data);

                            if (self.userForm.$valid)
                            {
                                var newUser = new User(data);
                                newUser.$save(function () {
                                    $location.path("/");
                                });
                            }

                        };
                    }
                    self.desi = ["Ba", "Qa", "Developer"];


                    self.today = function () {
                        self.user.dt = new Date(new Date().getFullYear() - 18, 0, 1);
                    };
                    self.today();

                    self.clear = function () {
                        self.user.dt = null;
                    };

                    self.format = 'dd-MM-yyyy';

                    self.changepass = function () {

                        self.userForm.pass1.$setValidity("passset", self.user.pass == self.user.pass1);

                    }


                    self.dateOptions = {
                        datepickerMode: 'year',
                        maxDate: new Date(new Date().getFullYear() - 18, 0, 1),
                        startingDay: 1
                    };




                    self.open1 = function () {
                        self.popup1.opened = true;
                    };


                    self.setDate = function (year, month, day) {
                        var d = new Date(year, month, day);
                        self.user.dt = $filter('date')(d, 'yyyy-MM-dd');
                    };


                    self.popup1 = {
                        opened: false
                    };





                }]
        });

