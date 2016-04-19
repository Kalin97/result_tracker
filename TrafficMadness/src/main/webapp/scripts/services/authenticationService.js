gameStorageServices.factory('authentication', function($cookies, httpRest) {
	var authenticationUrl = "api/v1/authentication/";
	var userCookieKey = "userCookieKey";

	return {
		user: $cookies.getObject(userCookieKey),

		login: function(user) {
			var request = httpRest.post(authenticationUrl, user);

			request.success(function() {
				user.password = null;
				$cookies.putObject(userCookieKey, user);
				this.user = user;
			});

			return request;
		},

		logout: function() {
			$cookies.remove(userCookieKey);

			return httpRest.delete(authenticationUrl);
		},

		getUser: function() {
			return this.user;
		}, 

		isLoggedIn: function() {
			return this.user != null;
		}
	}
});