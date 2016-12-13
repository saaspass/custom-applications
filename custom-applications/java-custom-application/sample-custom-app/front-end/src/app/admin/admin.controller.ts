import {AuthService} from '../auth/auth.service';
import {ErrorResponse, SpResponse} from '../response.model';
import {Principal} from '../auth/principal.model';
import {RemoveAccountService} from '../remove-account/remove-account.service';
import {UnregisterService} from '../unregister/unregister.service';

export class AdminController {

    /** @ngInject */
    constructor(private $state: ng.ui.IStateService,
                private toastr: Toastr,
                private AuthService: AuthService,
                private UnregisterService: UnregisterService,
                private RemoveAccountService: RemoveAccountService,
                private principal: Principal) {
    }

    getUsername(): string {
        return this.principal.username;
    }

    logout() {
        this.AuthService.logout();
        this.$state.go('app.login');
        this.toastr.success('logout successful');
    }

    unregister() {
        this.UnregisterService.unregister()
            .then(response => this.success(response))
            .catch(response => this.error(response));
    }

    removeAccount() {
        this.RemoveAccountService.removeAccount()
            .then(response => this.success(response))
            .catch(response => this.error(response));
    }

    private success(response: SpResponse) {
        const json = JSON.stringify(response, null, ' ');

        if (response.warning) {
            this.toastr.warning(`<pre>${json}</pre>`);
        } else {
            this.toastr.success(`<pre>${json}</pre>`);
            this.$state.go('app.login');
        }
    }

    private error(response: ng.IHttpPromiseCallbackArg<ErrorResponse>) {
        const json = JSON.stringify(response.data, null, ' ');
        this.toastr.error(`<pre>${json}</pre>`);
    }
}
