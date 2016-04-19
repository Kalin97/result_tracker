gameStorageServices.factory('News', function($resource) {
    return $resource('api/v1/news/:newsId', {}, {
		update: { method: "PUT" },
	});
});