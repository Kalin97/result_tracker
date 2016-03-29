var ENDPOINT = "http://localhost:8080/TrafficMadness/";

function endpoint(url)
{
	return ENDPOINT + url;
}

function getRequest(url) 
{
	return $.ajax(endpoint(url), {
		method: "GET",
		dataType: "json"
	});
}

function deleteRequest(url) 
{
	return $.ajax(endpoint(url), {
		method: "DELETE",
		dataType: "json"
	});
}

function postRequest(url) 
{
	return $.ajax(endpoint(url), {
		method: "POST",
		dataType: "json",
		data: JSON.stringify(task),
		contentType: "application/json; charset=utf-8"
	});
}

function updateTask(url, data) 
{
	return $.ajax(endpoint(url), {
		method: "PUT",
		dataType: "json",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8"
	});
}
