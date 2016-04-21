gameStorageServices.factory('Feedback', function($resource) {
    return $resource('api/v1/feedback/:feedbackId', {}, {
		update: { 
			method: "PUT",
			headers: {
				'Content-Type': 'application/json'
			}
		}
	});
});