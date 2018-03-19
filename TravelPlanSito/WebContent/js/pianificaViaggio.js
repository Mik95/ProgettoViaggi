
var utente=localStorage.getItem('utente');
utente = JSON.parse(utente);

$(document).ready(function(){
	$.ajax({
		url: 'luoghi',
		method: 'get',
	})
	.done(function(luoghi){
		localStorage.setItem('luoghi', JSON.stringify(luoghi));
		});
	
});

var luoghi=localStorage.getItem('luoghi');
luoghi = JSON.parse(luoghi);

var id;

$('#btnCreaPack').click(function(e) {
	// 1. impedire al form HTML di fare submit
	e.preventDefault();
	luoghi.forEach(function(l){
		if(l.nome==($('#citta').val()))
			id = l.idLuogo;
	});
		
	var Obj = {
			nPersone: $('#nPersone').val(),
			idLuogo: id,
			partenza: $('#partenza').val(),
			email: utente.email
	}
	
	$.ajax({
		url: 'pacchetto',
		method: 'post',
		data: Obj
	})
	.done(function(esito){
			localStorage.setItem('pacchetto', JSON.stringify(Obj));
			sessionStorage.setItem('id_pacchetto', JSON.stringify(esito));
			window.alert("Pacchetto creato correttamente");
			location.href ='AggiungiTappe.html#'+esito;	
	})
	.fail(function() {
		window.alert("qualcosa è andato storto.");
		console.error('qualcosa è andato storto.')
	});

});
