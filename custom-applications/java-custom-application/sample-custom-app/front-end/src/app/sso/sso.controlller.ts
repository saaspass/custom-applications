import {ErrorResponse} from '../response.model';
import {SsoRequest} from './sso.model';
import {SsoService} from './sso.service';

export class SsoController {

    /** @ngInject */
    constructor(private $state: ng.ui.IStateService,
                private $stateParams: ng.ui.IStateParamsService & SsoRequest,
                private toastr: Toastr,
                private SsoService: SsoService) {

        SsoService.login({
            account: $stateParams.account,
            tracker: $stateParams.tracker
        }).then(response => {
            const json = JSON.stringify(response, null, ' ');
            this.toastr.success(`<pre>${json}</pre>`);
            this.$state.go('app.admin');
        }).catch((response: ng.IHttpPromiseCallbackArg<ErrorResponse>) => {
            const json = JSON.stringify(response.data, null, ' ');
            this.toastr.error(`<pre>${json}</pre>`);
        });
    }
}
