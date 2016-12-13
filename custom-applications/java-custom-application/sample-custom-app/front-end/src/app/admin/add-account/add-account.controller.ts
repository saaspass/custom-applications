import {AddAccountRequest} from './add-account.model';
import {AddAccountService} from './add-account.service';
import {ErrorResponse} from '../../response.model';

export class AddAccountController {

    request: AddAccountRequest;

    /** @ngInject */
    constructor(private toastr: Toastr,
                private AddAccountService: AddAccountService) {
    }

    addAccount() {
        this.AddAccountService.addAccount(this.request).then(response => {
            const json = JSON.stringify(response, null, ' ');
            this.toastr.success(`<pre>${json}</pre>`);
        }).catch((response: ng.IHttpPromiseCallbackArg<ErrorResponse>) => {
            const json = JSON.stringify(response.data, null, ' ');
            this.toastr.error(`<pre>${json}</pre>`);
        });
    }
}
