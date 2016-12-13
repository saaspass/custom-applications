import {app} from '../../app';
import {VerifyAccountController} from './verify-account.controller';

app.config(config);

/** @ngInject */
function config($stateProvider: ng.ui.IStateProvider) {

    $stateProvider.state('app.admin.verifyaccount', {
        url: '/verify-account',
        template: require('./verify-account.html'),
        controller: VerifyAccountController,
        controllerAs: 'vm'
    });
}
