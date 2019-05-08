jQuery(document).ready(function($) {
	showMeYourCookies('When index document is ready');

	$.ajax({
		type: 'GET',
		url: '/v1/pasajeros'

	}).done(function (data, textStatus, jqXHR) {
		showMeYourJqXHR('When GET /v1/pasajeros is done', jqXHR);
		showMeYourCookies('When GET /v1/pasajeros is done');

		var csrfToken = jqXHR.getResponseHeader('X-CSRF-TOKEN');
		if (csrfToken) {
			var cookie = JSON.parse($.cookie('pasajero'));
			cookie.csrf = csrfToken;
			$.cookie('pasajero', JSON.stringify(cookie));
		}

	}).fail(function (jqXHR, textStatus, errorThrown) {
		showMeYourJqXHR('When GET /v1/pasajeros fails', jqXHR);
		showMeYourCookies('When GET /v1/pasajeros fails');

		if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
			var cookie = JSON.stringify({method: 'GET', url: '/', csrf: jqXHR.getResponseHeader('X-CSRF-TOKEN')});
			$.cookie('pasajero', cookie);

			window.location = '/login.html';

		} else {
			console.error('Houston, we have a problem...');
		}
	});

	$('#logoutButton').on('click', function (event) {
		event.preventDefault();

		showMeYourCookies('When logoutButton is clicked');

		var cookie = JSON.parse($.cookie('pasajero'));
		$.ajax({
			data: {},
			headers: {'X-CSRF-TOKEN': cookie.csrf},
			timeout: 1000,
			type: 'POST',
			url: '/logout'

		}).done(function(data, textStatus, jqXHR) {
			showMeYourJqXHR('When POST /logout is done', jqXHR);
			showMeYourCookies('When POST /logout is done');

			console.info('congratulations, you have logged out!');

			window.location = '/';

		}).fail(function(jqXHR, textStatus, errorThrown) {
			showMeYourJqXHR('When POST /logout fails', jqXHR);
			showMeYourCookies('When POST /logout fails');
			console.error('Help! I cannot get out of here!');
		});
	});
});