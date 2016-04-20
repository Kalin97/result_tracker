gameStorageServices.factory('NormalUser', function($resource) {
	return $resource('api/v1/users/:userId', {}, {
		getByEmail: { 
			method: "GET", 
			url: "api/v1/users/email/:playerEmail", 
			headers: {
				'Content-Type': 'application/json'
			}
		},
		update: { 
			method: "PUT",
			headers: {
				'Content-Type': 'application/json'
			}
		}		
	});
});