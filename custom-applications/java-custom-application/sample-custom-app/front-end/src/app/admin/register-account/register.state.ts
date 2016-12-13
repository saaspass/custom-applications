import {app} from '../../app';
import {RegisterByAdminController} from './register.controlller';

app.config(config);

/** @ngInject */
function config($stateProvider: ng.ui.IStateProvider) {

    $stateProvider.state('app.admin.register', {
        url: '/register',
        template: require('./register.html'),
        controller: RegisterByAdminController,
        controllerAs: 'vm'
    });
}
