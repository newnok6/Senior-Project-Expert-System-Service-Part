/**
 * Created by Panupak on 6/8/2014.
 */
'use strict';
/**
 * AdminController
 * @constructor
 */

function AdminController($scope,$location){
    $scope.changeView = function(){
           $location.url("/subprop")
        console.log("GOOD")
    };
};