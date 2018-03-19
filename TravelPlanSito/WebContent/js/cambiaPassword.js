$('#btnChange').click(function(e) {
	
	var email = document.getElementById('email').value;
	var pw = document.getElementById('password').value;
	var conferma = document.getElementById('conferma').value;
	
	if ((email == "") || (email == "undefined")) {
			window.alert("Il campo Email è obbligatorio.");
		   document.modulo.email.focus();
		   return false;
		}
	
	if ((pw == "") || (pw == "undefined")) {
		window.alert("Il campo Nuova Password è obbligatorio.");
	   document.modulo.pw.focus();
	   return false;
	}
	
	if ((conferma == "") || (conferma == "undefined")) {
			window.alert("Il campo Conferma Password è obbligatorio.");
		   document.modulo.conferma.focus();
		   return false;
		}
	
	if (pw != conferma) {
		   alert("La password confermata è diversa da quella scelta, controllare.");
		   document.modulo.conferma.value = "";
		   document.modulo.conferma.focus();
		   return false;
		}
	
	else{
	
	// 1. impedire al form HTML di fare submit
	e.preventDefault();
	$.ajax({
		url: 'changePassword',
		method: 'post',
		data: $('#formChange').serialize()
	})
	.done(function(esito){
		console.log(esito);
		if(esito.success) {
			localStorage.setItem('utente', JSON.stringify(esito.oggettoRisultante));
			window.alert("Password cambiata correttamente");
			location.href ='Home.html';
			localStorage.clear();
		}
		
		else
			window.alert("Cambio Password fallito");
	})
	.fail(function() {
		window.alert("qualcosa è andato storto.");
		console.error('qualcosa è andato storto.')
	});
	
	}
	
});

var utente = localStorage.getItem('utente');

if(utente) { 
	utente =JSON.parse(utente)
   	$("#email").val(utente.email);
	}