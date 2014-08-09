'use strict';
/**
 * SubstancePropControllers
 * @constructor
 */
var SubstancePropControllers = angular.module('SubstancePropControllers',[]);

SubstancePropControllers.controller('SolubilityListCtrl',['$scope','$http',
               function($scope,$http){
                   $http.get('subprop/solubilityList.json').success(function (solubilityList) {
                       $scope.solubilities = solubilityList;
                   });
               }]);
