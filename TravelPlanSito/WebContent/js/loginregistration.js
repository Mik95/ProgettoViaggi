$('#btnLogin').click(function(e) {
	// 1. impedire al form HTML di fare submit
	e.preventDefault();
	$.ajax({
		url: 'login',
		method: 'post',
		data: $('#formLogin').serialize()
	})
	.done(function(esito){
		console.log(esito);
		if(esito.success) {
			sessionStorage.setItem('utente', JSON.stringify(esito.oggettoRisultante));
			location.href ='PianificaViaggio.html';
		} else {
			window.alert("Email e/o Password errato/i.");
		}
	})
	.fail(function() {
		console.error('qualcosa è andato storto.')
	});
	
});

$('#btnSignin').click(function(e) {
	// 1. impedire al form HTML di fare submit
	e.preventDefault();
	$.ajax({
		url: 'registration',
		method: 'post',
		data: $('#formSignin').serialize()
	})
	.done(function(esito){
		console.log(esito);
		if(esito.success) {
			window.alert("Registrazione effettuata correttamente");
			location.href ='Home.html';
		}
		
		else
			window.alert("Registrazione fallita");
	})
	.fail(function() {
		window.alert("qualcosa è andato storto.");
		console.error('qualcosa è andato storto.')
	});
	
});