import {app} from '../app';
import {API_URL} from '../config/const.config';
import {AuthService} from '../auth/auth.service';
import {LoginResponse} from '../login/login.model';
import {SsoRequest} from './sso.model';

export class SsoService {

    /** @ngInject */
    constructor(private $http: ng.IHttpService,
                private AuthService: AuthService) {
    }

    login(request: SsoRequest): ng.IPromise<LoginResponse> {
        return this.$http.get<LoginResponse>(
            `${API_URL}/sso`,
            {params: request}
        ).then(response => {
            this.AuthService.setToken(response.data.token);
            return response.data;
        });
    }
}

app.service('SsoService', SsoService);
