gameStorageApp.config(function($httpProvider) {
	$httpProvider.interceptors.push(function($q) {
		return {
			'responseError': function(rejection) {
				var deferred = $q.defer();

				if(rejection.status == 401) {
					console.log("logout");
					location.reload();
				}

				deferred.reject(rejection);

				return deferred.promise;
			}
		};
	});
});