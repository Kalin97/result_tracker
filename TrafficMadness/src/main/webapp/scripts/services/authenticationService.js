gameStorageServices.factory('authentication', function($cookies, httpRest, AUTH_ROLES) {
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

		isLoggedInWithRole: function(role) {
			return this.user != null && this.user.role == role;
		},

		isLoggedInAdmin: function() {
			return this.user != null && this.user.role != AUTH_ROLES.USER;
		}
	}
});