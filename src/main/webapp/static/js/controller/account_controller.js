'use strict';
App.controller('AccountController', ['$scope','AccountService', function ($scope, AccountService) {
    var self = this;
    self.account = {acId:null,acCredit:null,acDebit:'',acCategory:'',acStaff:null,acNote:'',acDate:null, acFromDate:null, acToDate:null};
    self.fullAccount = {normalAcc:null,mangmentCorpAcc:null,mangmentRajaguruAcc:null,mangmentMullaiAcc:null};
    self.accounts = [];
    self.mgmntCorpAccount = [];
    self.mgmntRajaguruAccount = [];
    self.mgmntMullaiAccount = [];    
    self.employee = {emId: null, emName: '', emJoinDate: '', emSalary: '', emReleivedDate: '', emAddress: '', emCity: '', emState: '', emPincode: '', emCountry: '', emMobile1: '', emMobile2: '', emEmail1: ''};
    self.employees = [];
    self.givenFromMgmntTotal = 0;
    self.givenToMgmntTotal = 0;
    self.givenFromCorpMgmt = 0;
    self.givenToCorpMgmt = 0;
    self.givenFromRajaguruMgmt = 0;
    self.givenToRajaguruMgmt = 0;
    self.givenFromMullaiMgmt = 0;
    self.givenToMullaiMgmt = 0;
    self.creditTotal = 0;
    self.debitTotal =0;
 
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
                    self.mgmntCorpAccount = self.fullAccount.mangmentCorpAcc;
                    self.mgmntRajaguruAccount = self.fullAccount.mangmentRajaguruAcc;
                    self.mgmntMullaiAccount = self.fullAccount.mangmentMullaiAcc;
                    self.acountTotal();
                    self.mgmntAcountTotal();
                    self.pagingController(AccountService.PagerService(),self.accounts.length);
                    self.givenFromMgmntTotal =  self.givenFromCorpMgmt + self.givenFromRajaguruMgmt + self.givenFromMullaiMgmt;
                    self.givenToMgmntTotal = self.givenToCorpMgmt + self.givenToRajaguruMgmt + self.givenToMullaiMgmt;
                    self.cashInHand =self.creditTotal - self.debitTotal;
                    self.nb = 0;
                    self.actdebt=self.debitTotal-self.givenFromMgmntTotal;
                    self.acccredt=self.creditTotal-self.givenFromMgmntTotal;
                    if(self.actdebt<0){
                        self.nb = self.actdebt+self.acccredt;
                    }else{
                         self.nb = self.acccredt-self.actdebt;
                    }
                    console.log('cashInHand  ',self.cashInHand);
                    Highcharts.chart('containerchart', {
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false,
                            type: 'pie'
                        },
                        title: {
                            text: 'Drizzly Accounts'+'<br>'
                                    +'Actual Credit : '+ (self.creditTotal-self.givenFromMgmntTotal)+ '<br>'
                                    +'Actual Debit : '+ (self.debitTotal-self.givenFromMgmntTotal)+ '<br>'
                                    +'Net Balance : '+ ( self.nb)
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
                            data: [
                            {
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
                                name: 'Cash In Hand',
                                y: self.cashInHand,
                                sliced: true,
                                selected: true
                            }, {
                                name: 'Received from - Managment',
                                y: self.givenFromMgmntTotal,
                                sliced: true,
                                selected: true
                            }, {
                                name: 'Given to - Managment',
                                y: self.givenToMgmntTotal,
                                sliced: true,
                                selected: true
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
        self.givenFromCorpMgmt = 0;
        self.givenToCorpMgmt = 0;
        self.givenFromRajaguruMgmt = 0;
        self.givenToRajaguruMgmt = 0;
        self.givenFromMullaiMgmt = 0;
        self.givenToMullaiMgmt = 0;
        if(self.mgmntCorpAccount.length > 0){
            angular.forEach(self.mgmntCorpAccount, function(acc) {
                self.givenFromCorpMgmt += acc.acCredit;
                self.givenToCorpMgmt += acc.acDebit;
            });
            console.log('mgmntCorpAccount creditTotal : '+self.givenFromCorpMgmt);
        }
        if(self.mgmntRajaguruAccount.length > 0){
            angular.forEach(self.mgmntRajaguruAccount, function(acc) {
                self.givenFromRajaguruMgmt += acc.acCredit;
                self.givenToRajaguruMgmt += acc.acDebit;
            });
            console.log('mgmntRajaguruAccount creditTotal : '+self.givenFromRajaguruMgmt);
        }
        if(self.mgmntMullaiAccount.length > 0){
            angular.forEach(self.mgmntMullaiAccount, function(acc) {
                self.givenFromMullaiMgmt += acc.acCredit;
                self.givenToMullaiMgmt += acc.acDebit;
            });
            console.log('mgmntMullaiAccount creditTotal : '+self.givenFromMullaiMgmt);
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
