angular.
        module('empDetail').
        component('empDetail', {
            templateUrl: "app/emp-detail/emp-detail.template.html",
            controller: ['User', '$uibModal', 'orderByFilter', '$log', '$routeParams', function (User, $uibModal, orderBy, $log, $routeParams) {




                    var data = this;

                    data.delete = function (userid) {
                        console.log(userid);
                    };

                    data.head = {
                        a: "userId",
                        b: "username",
                        c: "mail",
                        d: "mno",
                        e: "desi",
                        f: "dt",
                        g: "addr"
                    };

                    data.user = User.query(function (response) {
                        angular.forEach(response, function (item) {
                            if (item.numFound > 0) {
                                for (var i = 0; i < item.numFound; i++) {

                                    data.user[i] = item.docs[i];

                                }

                            }
                        });

                    });
                    data.sortType = 'username'; // set the default sort type
                    data.sortReverse = false;  // set the default sort order

//


                    data.open = function (size, parentSelector) {
                        console.log(size);
                        data.id = size;
                        var parentElem = parentSelector ?
                                angular.element($document[0].querySelector('.modal-demo ' + parentSelector)) : undefined;
                        var modalInstance = $uibModal.open({
                            animation: data.animationsEnabled,
                            ariaLabelledBy: 'modal-title',
                            ariaDescribedBy: 'modal-body',
                            templateUrl: 'myModalContent.html',
                            controller: function ($uibModalInstance) {
                                var $ctrl = this;


                                $ctrl.ok = function () {
                                    $uibModalInstance.close();
                                    User.remove({id: size}, function () {
                                        data.user = User.query();
                                    });
                                };
                                $ctrl.cancel = function () {
                                    $uibModalInstance.close();
                                };
                            }
                            ,
                            controllerAs: '$ctrl',
                            size: size,
                            appendTo: parentElem,
                            resolve: {
                                items: function () {
                                    return data.items;
                                }
                            }
                        });


                    };
                }]
        });
