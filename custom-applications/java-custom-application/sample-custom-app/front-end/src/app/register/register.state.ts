import {app} from '../app';
import {RegisterByUserController} from './register.controlller';

app.config(config);

/** @ngInject */
function config($stateProvider: ng.ui.IStateProvider) {

    $stateProvider.state('app.register', {
        url: '/register',
        template: require('./register.html'),
        controller: RegisterByUserController,
        controllerAs: 'vm'
    });
}
