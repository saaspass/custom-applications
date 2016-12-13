import {AuthService} from '../auth/auth.service';
import {BarcodeService} from '../barcode/barcode.service';
import {BarcodeType} from '../barcode/barcode-type';
import {ErrorResponse} from '../response.model';
import {LoginRequest} from './login.model';

export class LoginController {

    request: LoginRequest;
    barcodeImage: string;
    bluetoothCode: string;

    /** @ngInject */
    constructor(private $state: ng.ui.IStateService,
                private toastr: Toastr,
                private BarcodeService: BarcodeService,
                private AuthService: AuthService,
                private $sce: ng.ISCEService) {

        this.BarcodeService.barcodeImage(BarcodeType.IL)
            .then(image => this.barcodeImage = image);

        this.BarcodeService.bluetoothCode(BarcodeType.BT).then(
            image => this.bluetoothCode = $sce.trustAsResourceUrl(image)
        );
    }

    login() {
        this.AuthService.login(this.request).then(response => {
            const json = JSON.stringify(response, null, ' ');
            this.toastr.success(`<pre>${json}</pre>`);
            this.$state.go('app.admin');
        }).catch((response: ng.IHttpPromiseCallbackArg<ErrorResponse>) => {
            const json = JSON.stringify(response.data, null, ' ');
            this.toastr.error(`<pre>${json}</pre>`);
        });
    }
}
