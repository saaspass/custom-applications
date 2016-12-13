import {VerifyAccountRequest} from './verify-account.model';
import {VerifyAccountService} from './verify-account.service';
import {ErrorResponse} from '../../response.model';

export class VerifyAccountController {

    request: VerifyAccountRequest;

    /** @ngInject */
    constructor(private toastr: Toastr,
                private VerifyAccountService: VerifyAccountService) {
    }

    verifyAccount() {
        this.VerifyAccountService.verifyAccount(this.request).then(response => {
            const json = JSON.stringify(response, null, ' ');
            this.toastr.success(`<pre>${json}</pre>`);
        }).catch((response: ng.IHttpPromiseCallbackArg<ErrorResponse>) => {
            const json = JSON.stringify(response.data, null, ' ');
            this.toastr.error(`<pre>${json}</pre>`);
        });
    }
}
