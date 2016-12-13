import {app} from '../app';
import {SsoController} from './sso.controlller';

app.config(config);

/** @ngInject */
function config($stateProvider: ng.ui.IStateProvider) {

    $stateProvider.state('app.sso', {
        url: '/sso?account&tracker',
        template: require('./sso.html'),
        controller: SsoController,
        controllerAs: 'vm'
    });
}
