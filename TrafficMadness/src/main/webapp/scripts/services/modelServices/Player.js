gameStorageServices.factory('Player', function($resource) {
	return $resource('api/v1/playerRest/:playerEmail', {}, {});
});