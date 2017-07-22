'use strict';
App.controller('AccountController', ['$scope','AccountService', function ($scope, AccountService) {
    var self = this;
    self.account = {acId:null,acCredit:null,acDebit:'',acCategory:'',acStaff:null,acNote:'',acDate:null, acFromDate:null, acToDate:null};
    self.fullAccount = {normalAcc:null,mangmentAcc:null};
    self.accounts = [];
    self.mgmntAccount = [];
    self.employee = {emId: null, emName: '', emJoinDate: '', emSalary: '', emReleivedDate: '', emAddress: '', emCity: '', emState: '', emPincode: '', emCountry: '', emMobile1: '', emMobile2: '', emEmail1: ''};
    self.employees = [];
    self.givenFromMgmt = 0;
    self.givenToMgmt = 0;
    self.creditTotal = 0;
    self.debitTotal =0;
    
//    $scope.orderByField = 'acCategory';
//    $scope.reverseSort = false1

//    self.acMgmntCreditTotal = function() {
//        if(self.mgmntAccount.length > 0){
//            console.log('mgmntAccount creditTotal : '+givenFromMgmt);
//            angular.forEach(self.mgmntAccount, function(acc) {
//                givenFromMgmt += acc.acCredit;
//            })
//        }
//        return givenFromMgmt;
//    };
//    
//    self.acMgmntDebitTotal = function() {
//        var givenToMgmt = 0;
//        if(self.mgmntAccount.length > 0){
//            console.log('mgmntAccount debitTotal : '+givenToMgmt);
//            angular.forEach(self.mgmntAccount, function(acc) {
//                givenToMgmt += acc.acDebit;
//            })
//        }
//        return givenToMgmt;
//    };
//    
//    self.acCreditTotal = function() {
//        var creditTotal = 0;
//        if(self.accounts.length > 0){
//            console.log('creditTotal : '+creditTotal);
//            angular.forEach(self.accounts, function(acc) {
//                creditTotal += acc.acCredit;
//                debitTotal += acc.acDebit;
//            })
//        }
//        return creditTotal;
//    };
//    
//    self.acDebitTotal = function() {
//        var debitTotal = 0;
//        if(self.accounts.length > 0){
//            console.log('debitTotal : '+debitTotal);
//            angular.forEach(self.accounts, function(acc) {
//                debitTotal += acc.acDebit;
//            })
//        }
//
//        return debitTotal;
//    };
    
    self.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };
    
    self.fetchAllEmployees = function () {
        AccountService.fetchAllEmployees()
            .then(
                function (data) {
                    self.employees = data;
                },
                function (errResponse) {
                    console.error('Error while fetching Currencies');
                }
            );
    };

    self.addAccount = function (account) {
        AccountService.AddAccount(account)
            .then(
                function (data) {
                    self.account = data;
                    console.log("going to fetch Accounts for date "+self.acDate());
                    self.findAccount(account.acDate,account.acDate);
                },
                function (errResponse) {
                    console.error('Error while creating account.');
                }
            );
    };

    self.findAccount = function (fromDate,toDate) {
        console.log("findAccount fromDate :: "+fromDate);
        console.log("findAccount toDate   :: "+toDate);
        AccountService.FecthAccount(fromDate,toDate)
            .then(
                function (data) {
                    self.accounts = data;
                },
                function (errResponse) {
                    console.error('Error while fetching Account');
                }
            );
    };

    self.find = function () {
        console.log("find account info");
        //self.accounts = [];
        $scope.search='';
        //self.findAccount(self.account.acFromDate,self.account.acToDate);
        console.log("find account from date : "+self.account.acFromDate);
        console.log("find account to date : "+self.account.acToDate);
        AccountService.FecthAccount(self.account)
            .then(
                function (data) {
                    self.fullAccount = data;
                    self.accounts = self.fullAccount.normalAcc;
                    self.mgmntAccount = self.fullAccount.mangmentAcc;
                    self.acountTotal();
                    self.mgmntAcountTotal();
                    self.pagingController(AccountService.PagerService(),self.accounts.length);
                    self.netBalance = (self.creditTotal + self.givenFromMgmt) - (self.debitTotal + self.givenToMgmt);
                    console.log('netBalance  ',self.netBalance);
                    Highcharts.chart('containerchart', {
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false,
                            type: 'pie'
                        },
                        title: {
                            text: 'Drizzly Accounts NetBalance : '+self.netBalance
                        },
                        tooltip: {
                            pointFormat: '{series.name}: <b>{point.y:.2f}</b>'
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    format: '<b>{point.name}</b>: {point.y:.2f}',
                                    style: {
                                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                    }
                                }
                            }
                        },
                        series: [{
                            name: 'Accounts',
                            colorByPoint: true,
                            data: [{
                                name: 'Net Balance',
                                y: self.netBalance
                            },{
                                name: 'Credit',
                                y: self.creditTotal,
                                sliced: true,
                                selected: true
                            }, {
                                name: 'Debit',
                                y: self.debitTotal,
                                sliced: true,
                                selected: true
                            }, {
                                name: 'Given from Management',
                                y: self.givenFromMgmt,
                                sliced: true,
                                selected: true
                            }, {
                                name: 'Given to Management',
                                y: self.givenToMgmt
                            }]
                        }]
                    });
                },
                function (errResponse) {
                    console.error('Error while fetching Account');
                }
            );
    };
    
    self.acountTotal = function(){
        self.creditTotal = 0;
                    self.debitTotal =0;
        if(self.accounts.length > 0){
            angular.forEach(self.accounts, function(acc) {
                self.creditTotal += acc.acCredit;
                self.debitTotal += acc.acDebit;
            });
            console.log('creditTotal : '+self.creditTotal);
        }
    };
    
    self.mgmntAcountTotal = function(){
        self.givenFromMgmt = 0;
        self.givenToMgmt = 0;
        if(self.mgmntAccount.length > 0){
            angular.forEach(self.mgmntAccount, function(acc) {
                self.givenFromMgmt += acc.acCredit;
                self.givenToMgmt += acc.acDebit;
            })
            console.log('mgmntAccount creditTotal : '+self.givenFromMgmt);
        }
        //self.debitTotal = self.debitTotal - self.givenToMgmt;
    };
    self.submit = function () {
        if (self.account.acId == null) {
            console.log('Saving New account', self.account);
            self.addAccount(self.account);
        } 
        self.reset();
    };

    self.reset = function () {
        self.account = {acId:null,acCredit:null,acDebit:'',acCategory:'',acNote:'',acDate:null, acFromDate:null, acToDate:null};
        $scope.myForm.$setPristine(); //reset Form
    };
    
    self.pagingController = function (PagerService,accountlistlength) {
        console.log("accountlistlength  ",accountlistlength);
        //var accounts = this;
        self.rangeOfItems = _.range(1, accountlistlength+1); // array of items to be paged
        self.pager = {};
        self.setPage = setPage;

        initController();
        function initController() {
            // initialize to page 1
            self.setPage(1);
        }
        function setPage(page) {
            if (page < 1 || page > self.pager.totalPages) {
                return;
            }
            // get pager object from service
            self.pager = PagerService.GetPager(accountlistlength, page);
            console.log("self.pager  ",self.pager);
            // get current page of items
            self.items = self.rangeOfItems.slice(self.pager.startIndex, self.pager.endIndex + 1);
        }
    };

}]);
