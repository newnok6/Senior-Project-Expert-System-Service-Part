
var DrugExpertSystemApp = {};
var App = angular.module('DrugExpertSystemApp', ['DrugExpertSystemApp.directives','DrugExpertSystemApp.filters','DrugExpertSystemApp.services','ngRoute','SubstancePropControllers']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider',
    function ($routeProvider) {
    $routeProvider.
        when('/subprop', {
        templateUrl: 'subprop',
        controller: 'SolubilityListCtrl'

    })

    .when('/test', {
        templateUrl: 'adminhtml/testing',
        controller: 'SolubilityListCtrl'

    })
    .otherwise({redirectTo: '/test'});
}]);