import {app} from '../app';
import {LoginController} from './login.controlller';

app.config(config);

/** @ngInject */
function config($stateProvider: ng.ui.IStateProvider) {

    $stateProvider.state('app.login', {
        url: '/login',
        template: require('./login.html'),
        controller: LoginController,
        controllerAs: 'vm'
    });
}
