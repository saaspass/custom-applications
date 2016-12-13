import {ErrorResponse} from '../../response.model';
import {RegisterByAdminRequest} from './register.model';
import {RegisterByAdminService} from './register.service';

export class RegisterByAdminController {

    request: RegisterByAdminRequest;

    /** @ngInject */
    constructor(private $state: ng.ui.IStateService,
                private toastr: Toastr,
                private RegisterByAdminService: RegisterByAdminService) {
    }

    register() {
        this.RegisterByAdminService.register(this.request).then(response => {
            const json = JSON.stringify(response, null, ' ');

            if (response.warning) {
                this.toastr.warning(`<pre>${json}</pre>`);
            } else {
                this.toastr.success(`<pre>${json}</pre>`);
                this.$state.go('app.admin');
            }
        }).catch((response: ng.IHttpPromiseCallbackArg<ErrorResponse>) => {
            const json = JSON.stringify(response.data, null, ' ');
            this.toastr.error(`<pre>${json}</pre>`);
        });
    }
}
