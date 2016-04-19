gameStorageServices.factory('httpRest', function($http) {
	return {
		get: function (url) {
			return $http.get(url);
		},

		delete: function (url) {
			return $http.delete(url);
		},

		post: function post(url, data) {
			return $http({
				url: url,
				dataType: 'json',
				method: 'POST',
				data: data,
				headers: {
				"Content-Type": "application/json"
				}
			});
		},

		put: function (url, data) {
			return $http({
				url: url,
				dataType: 'json',
				method: 'PUT',
				data: data,
				headers: {
				"Content-Type": "application/json"
				}
			});
		}
	}
});