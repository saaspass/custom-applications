import {app} from '../app';

app.config(config);

/** @ngInject */
function config($stateProvider: ng.ui.IStateProvider,
                $urlRouterProvider: ng.ui.IUrlRouterProvider) {

    $stateProvider.state('app', {
        url: '/app',
        abstract: true,
        template: require('./root.html'),
        controllerAs: 'vm'
    });

    $urlRouterProvider.otherwise('/app/login');
}
