import {app} from '../../app';
import {AddAccountController} from './add-account.controller';

app.config(config);

/** @ngInject */
function config($stateProvider: ng.ui.IStateProvider) {

    $stateProvider.state('app.admin.addaccount', {
        url: '/add-account',
        template: require('./add-account.html'),
        controller: AddAccountController,
        controllerAs: 'vm'
    });
}
