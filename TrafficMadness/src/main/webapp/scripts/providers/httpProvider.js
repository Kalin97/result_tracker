gameStorageApp.config(function($httpProvider, $rootScope) {
	$httpProvider.interceptors.push(function($q) {
		return {
			'responseError': function(rejection) {
				if(rejection.status == 404) {
					$rootScope.authentication.logout()
					// location.reload();
				}

				if (canRecover(rejection)) {
					return responseOrNewPromise
				}

				return $q.reject(rejection);
			}
		};
	});
});