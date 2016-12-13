import {app} from '../../app';
import {API_URL} from '../../config/const.config';
import {AddAccountRequest} from './add-account.model';
import {SpResponse} from '../../response.model';

export class AddAccountService {

    /** @ngInject */
    constructor(private $http: ng.IHttpService) {
    }

    addAccount(request: AddAccountRequest): ng.IPromise<SpResponse> {
        return this.$http.post(`${API_URL}/add-account`, request)
            .then(response => response.data);
    }
}

app.service('AddAccountService', AddAccountService);
