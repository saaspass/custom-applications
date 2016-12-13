import {app} from '../app';
import {API_URL} from '../config/const.config';
import {LoginRequest, LoginResponse} from '../login/login.model';
import {Principal} from './principal.model';

export class AuthService {

    private principal: Principal;

    /** @ngInject */
    constructor(private $http: ng.IHttpService,
                private $q: ng.IQService) {
    }

    init() {
        const token: string = localStorage.getItem('token');
        if (token) {
            this.setToken(token);
        } else {
            this.logout();
        }
    }

    login(request: LoginRequest): ng.IPromise<Principal> {

        return this.$http.post<LoginResponse>(
            `${API_URL}/login`, request
        ).then(response => {
            this.setToken(response.data.token);
            return this.principal;
        });
    }

    logout() {
        localStorage.clear();
        this.principal = undefined;
    }

    isLoggedIn(): boolean {
        return !!this.principal;
    }

    setToken(token: string) {
        localStorage.setItem('token', token);
        this.principal = parse(token);

        function parse(token: string): Principal {
            const split = token.split(':');
            return {
                username: split[0],
                timeout: new Date(+split[1]),
                hash: split[2]
            };
        }
    }

    getPrincipal(): ng.IPromise<Principal> {
        if (this.principal) {
            return this.$q.resolve(this.principal);
        } else {
            return this.$q.reject({status: 401});
        }
    }
}

app.service('AuthService', AuthService);
