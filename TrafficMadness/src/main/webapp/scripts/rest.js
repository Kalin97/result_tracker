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

function postRequest(url, requestData) 
{
	return $.ajax(endpoint(url), {
		method: "POST",
		dataType: "json",
		data: JSON.stringify(requestData),
		contentType: "application/json; charset=utf-8"
	});
}

function putRequest(url, requestData) 
{
	return $.ajax(endpoint(url), {
		method: "PUT",
		dataType: "json",
		data: JSON.stringify(requestData),
		contentType: "application/json; charset=utf-8"
	});
}
