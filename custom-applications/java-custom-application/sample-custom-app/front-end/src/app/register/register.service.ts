import {app} from '../app';
import {API_URL} from '../config/const.config';
import {SpResponse} from '../response.model';
import {AuthService} from '../auth/auth.service';
import {RegisterByUserRequest} from './register.model';

export class RegisterByUserService {

    /** @ngInject */
    constructor(private $http: ng.IHttpService,
                private AuthService: AuthService) {
    }

    register(request: RegisterByUserRequest): ng.IPromise<SpResponse> {
        return this.$http.post<SpResponse>(
            `${API_URL}/register-by-user`, request
        ).then(response => {
            if (response.data.isVerified) {
                // todo: this.AuthService.setToken(response.data.token);
                this.AuthService.setToken(request.username);
            }
            return response.data;
        });
    }
}

app.service('RegisterByUserService', RegisterByUserService);
