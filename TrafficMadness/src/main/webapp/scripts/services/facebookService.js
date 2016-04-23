gameStorageServices.factory('facebook', function($q) {
    return {
        getUserEmail: function() {
            var deferred = $q.defer();

            FB.login(function(response) {
	            FB.api('/me', {
	                fields: 'name'
	            }, function(response) {
	                if (!response || response.error) {
	                    deferred.reject('Error occured');
	                } else {
	                    deferred.resolve(response);
	                }
	            });
	        });

            return deferred.promise;
        }
	}
});