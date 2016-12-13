import {app} from '../app';
import {AuthService} from '../auth/auth.service';
import {AdminController} from './admin.controller';

app.config(config);

/** @ngInject */
function config($stateProvider: ng.ui.IStateProvider) {

    $stateProvider.state('app.admin', {
        url: '/admin',
        template: require('./admin.html'),
        controller: AdminController,
        controllerAs: 'vm',
        resolve: {principal}
    });
}

/** @ngInject */
function principal(AuthService: AuthService) {
    return AuthService.getPrincipal();
}
