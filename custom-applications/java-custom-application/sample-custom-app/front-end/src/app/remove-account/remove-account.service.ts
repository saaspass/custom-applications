import {app} from '../app';
import {API_URL} from '../config/const.config';
import {AuthService} from '../auth/auth.service';
import {Principal} from '../auth/principal.model';
import {SpResponse} from '../response.model';

export class RemoveAccountService {

    /** @ngInject */
    constructor(private $http: ng.IHttpService,
                private AuthService: AuthService) {
    }

    removeAccount(): ng.IPromise<SpResponse> {
        return this.AuthService.getPrincipal().then((principal: Principal) =>
            this.$http.post<SpResponse>(
                `${API_URL}/remove-account`,
                {username: principal.username}
            ).then(
                response => response.data
            ).finally(
                () => this.AuthService.logout()
            )
        );
    }
}

app.service('RemoveAccountService', RemoveAccountService);
