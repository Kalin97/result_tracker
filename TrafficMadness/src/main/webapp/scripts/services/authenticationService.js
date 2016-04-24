gameStorageServices.factory('authentication', function($cookies, httpRest) {
	var userCookieKey = "userCookieKey";
	var authenticationUrl = "api/v1/authentication/";

	return {
		user: $cookies.getObject(userCookieKey),

		login: function(userEmail, userRole) {
			this.user = {
				email: userEmail,
				role: userRole
			};

			$cookies.putObject(userCookieKey, this.user);
		},

		logout: function() {
			$cookies.remove(userCookieKey);

			return httpRest.delete(authenticationUrl);
		},

		getUser: function() {
			return this.user;
		}, 

		getUserRole: function() {
			return user.userRole;
		},

		isLoggedIn: function() {
			return this.user != null;
		},

		isHeadLoggedIn: function() {
			return this.user != null && this.user.administratorType == "HEAD";
		}
	}
});