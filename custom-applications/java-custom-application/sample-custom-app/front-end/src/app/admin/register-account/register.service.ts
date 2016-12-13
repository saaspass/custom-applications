import {app} from '../../app';
import {API_URL} from '../../config/const.config';
import {AuthService} from '../../auth/auth.service';
import {RegisterByAdminRequest} from './register.model';
import {SpResponse} from '../../response.model';

export class RegisterByAdminService {

    /** @ngInject */
    constructor(private $http: ng.IHttpService,
                private AuthService: AuthService) {
    }

    register(request: RegisterByAdminRequest): ng.IPromise<SpResponse> {
        return this.$http.post<SpResponse>(
            `${API_URL}/register-by-admin`, request
        ).then(response => {
            if (response.data.isVerified) {
                // todo: this.AuthService.setToken(response.data.token);
                this.AuthService.setToken(request.username);
            }
            return response.data;
        });
    }
}

app.service('RegisterByAdminService', RegisterByAdminService);
