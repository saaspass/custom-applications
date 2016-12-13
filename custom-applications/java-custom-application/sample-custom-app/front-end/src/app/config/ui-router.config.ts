import {app} from '../app';

app.run(config);

/** @ngInject */
function config($log: ng.ILogService,
                $injector: ng.auto.IInjectorService,
                $rootScope: ng.IRootScopeService,
                $state: ng.ui.IStateService) {

    $rootScope.$on('$stateChangeError', error);

    function error(event: ng.IAngularEvent,
                   toState: ng.ui.IState,
                   toParams: {[key: string]: string},
                   fromState: ng.ui.IState,
                   fromParams: {[key: string]: string},
                   error: ng.IHttpPromiseCallbackArg<any>) {

        // prevent blank page on first page load
        if (!fromState.name) {
            $state.go('app.login');
        }

        // state change cancelled intentionally
        if (error === undefined) {
            return;
        }

        if (error.status === 401) {
            $state.go('app.login');
        }

        const toastr = $injector.get<Toastr>('toastr');
        toastr.error(`${error.status}`, `${error.status}`);

        $log.error(arguments);
    }
}
