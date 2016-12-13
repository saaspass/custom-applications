import {app} from '../app';

app.config(httpConfig);

/** @ngInject */
function httpConfig($httpProvider: ng.IHttpProvider) {
    $httpProvider.interceptors.push(AuthTokenInterceptor);
}

/** @ngInject */
function AuthTokenInterceptor() {
    return {request};
}

function request(config: ng.IRequestConfig): ng.IRequestConfig {
    config.headers['Authorization'] = localStorage.getItem('token');
    return config;
}
