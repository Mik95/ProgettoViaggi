var utente = sessionStorage.getItem('utente');

if(utente) {
	utente =JSON.parse(utente)
       	$("#name").html(utente.nome);
       	$('#lastname').html(utente.cognome);
       	$('#email').html(utente.email);
       	$('#password').html(utente.password);
       		}
