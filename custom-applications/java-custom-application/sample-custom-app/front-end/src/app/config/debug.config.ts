import {app} from '../app';

app.config(config);

/** @ngInject */
function config($logProvider: ng.ILogProvider) {
    $logProvider.debugEnabled(true);
}
