import {app} from './app';
import {API_URL} from './config/const.config';
import {AuthService} from './auth/auth.service';
import {BarcodeService} from './barcode/barcode.service';
const Stomp = require('stompjs/lib/stomp.js').Stomp;
const SockJS = require('sockjs-client');

app.run(SocketHandler);

/** @ngInject */
function SocketHandler($state: ng.ui.IStateService,
                       toastr: Toastr,
                       AuthService: AuthService,
                       BarcodeService: BarcodeService) {

    const ws = new SockJS(`${API_URL}/socket`);
    const client = Stomp.over(ws);

    client.connect({}, function () {
        client.subscribe(`/topic/instant-login/${BarcodeService.session()}`, success);
        client.subscribe(`/topic/instant-registration/${BarcodeService.session()}`, success);
    });

    function success(frame) {

        console.log({frame});

        const json = JSON.stringify(frame, null, ' ');
        toastr.success(`<pre>${json}</pre>`);

        const body = JSON.parse(frame.body);
        AuthService.setToken(body.token);
        $state.go('app.admin');
    }
}
