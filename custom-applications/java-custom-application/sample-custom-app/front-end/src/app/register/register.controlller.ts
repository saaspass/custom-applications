import {ErrorResponse} from '../response.model';
import {BarcodeService} from '../barcode/barcode.service';
import {BarcodeType} from '../barcode/barcode-type';
import {RegisterByUserRequest} from './register.model';
import {RegisterByUserService} from './register.service';

export class RegisterByUserController {

    request: RegisterByUserRequest;
    barcode: string;
    ilir: boolean;

    /** @ngInject */
    constructor(private $state: ng.ui.IStateService,
                private toastr: Toastr,
                private RegisterByUserService: RegisterByUserService,
                private BarcodeService: BarcodeService) {

        this.BarcodeService.barcodeImage(BarcodeType.IR)
            .then((image: string) => this.barcode = image);
    }

    register() {
        this.RegisterByUserService.register(this.request).then(response => {
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

    refreshBarcode() {
        if (this.ilir) {
            this.BarcodeService.barcodeImage(BarcodeType.ILIR)
                .then(image => this.barcode = image);
        } else {
            this.BarcodeService.barcodeImage(BarcodeType.IR)
                .then(image => this.barcode = image);
        }
    }
}
