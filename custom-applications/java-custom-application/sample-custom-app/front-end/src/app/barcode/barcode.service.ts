import {app} from '../app';
import {API_URL} from '../config/const.config';
import {BarcodeResponse} from './barcode.model';
import {BarcodeType} from './barcode-type';
import {Cached} from '../util/method-memoizer';

export class BarcodeService {

    /** @ngInject */
    constructor(private $http: ng.IHttpService) {
    }

    @Cached
    session(): string {
        return this.uuid();
    }

    barcodeImage(type: BarcodeType): ng.IPromise<string> {
        return this.barcode(type).then((response: BarcodeResponse) =>
            `data:image/png;base64,${response.barcodeimage}`
        );
    }

    bluetoothCode(type: BarcodeType): ng.IPromise<string> {
        return this.barcode(type).then((response: BarcodeResponse) =>
            `saaspass://bluepass?${response.bluetoothcode}`
        );
    }

    private uuid(): string {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, (c) => {
            const r = Math.random() * 16 | 0;          // tslint:disable-line:no-bitwise
            const v = c === 'x' ? r : (r & 0x3 | 0x8); // tslint:disable-line:no-bitwise
            return v.toString(16);
        });
    }

    private barcode(type: BarcodeType): ng.IPromise<BarcodeResponse> {
        return this.$http.get<BarcodeResponse>(
            `${API_URL}/barcode?session=${this.session()}&type=${BarcodeType[type]}`
        ).then(response => response.data);
    }
}

app.service('BarcodeService', BarcodeService);
