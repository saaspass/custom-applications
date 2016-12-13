import {app} from '../../app';
import {API_URL} from '../../config/const.config';
import {SpResponse} from '../../response.model';
import {VerifyAccountRequest} from './verify-account.model';

export class VerifyAccountService {

    /** @ngInject */
    constructor(private $http: ng.IHttpService) {
    }

    verifyAccount(request: VerifyAccountRequest): ng.IPromise<SpResponse> {
        return this.$http.post(`${API_URL}/verify-account`, request)
            .then(response => response.data);
    }
}

app.service('VerifyAccountService', VerifyAccountService);
