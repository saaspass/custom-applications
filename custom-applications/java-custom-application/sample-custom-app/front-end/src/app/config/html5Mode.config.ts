import {app} from '../app';

app.config(config);

/** @ngInject */
function config($locationProvider: ng.ILocationProvider) {
    $locationProvider.html5Mode(true);
}
