import * as angular from 'angular';
import 'bootstrap/dist/css/bootstrap.css';
import 'angular-toastr/dist/angular-toastr.css';
import 'angular-block-ui/dist/angular-block-ui.css';

export const app: ng.IModule = angular.module('app', [
    <string> require('angular-ui-router'),
    <string> require('angular-ui-bootstrap'),
    <string> require('angular-toastr'),
    <string> require('angular-block-ui')
]);
