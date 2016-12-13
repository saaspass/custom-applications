import {app} from '../app';
import {AuthService} from './auth.service';

app.run(init);

/** @ngInject */
function init(AuthService: AuthService) {
    AuthService.init();
}
