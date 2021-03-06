'use strict';

angular.module('burnsearchApp')
    .factory('AuthServerProvider', function loginService($http, $httpParamSerializer, localStorageService, Base64) {
        return {
            login: function(credentials) {
                var data = {
                    username: credentials.username,
                    password: credentials.password,
                    grant_type: "password",
                    scope: "read write",
                    client_secret: "a4abf0145eae0ac6ed98a8ab2182ff68d8d2536a",
                    client_id: "burnsearchapp"
                };
                return $http.post('oauth/token', $httpParamSerializer(data), {
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded",
                        "Accept": "application/json",
                        "Authorization": "Basic " + Base64.encode("burnsearchapp" + ':' + "a4abf0145eae0ac6ed98a8ab2182ff68d8d2536a")
                    }
                }).success(function (response) {
                    var expiredAt = new Date();
                    expiredAt.setSeconds(expiredAt.getSeconds() + response.expires_in);
                    response.expires_at = expiredAt.getTime();
                    localStorageService.set('token', response);
                    return response;
                });
            },
            logout: function() {
                // logout from the server
                $http.post('api/logout').then(function() {
                    localStorageService.clearAll();
                });
            },
            getToken: function () {
                return localStorageService.get('token');
            },
            hasValidToken: function () {
                var token = this.getToken();
                return token && token.expires_at && token.expires_at > new Date().getTime();
            }
        };
    });
