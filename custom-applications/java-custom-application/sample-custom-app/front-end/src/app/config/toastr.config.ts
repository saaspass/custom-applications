import {app} from '../app';

app.config(config);

/** @ngInject */
function config(toastrConfig: ToastrOptions) {

    const myConfig: ToastrOptions = {
        allowHtml: true,
        closeButton: true,
        extendedTimeOut: 5000,
        positionClass: 'toast-bottom-right',
        progressBar: true,
        timeOut: 15000
    };

    angular.extend(toastrConfig, myConfig);
}
