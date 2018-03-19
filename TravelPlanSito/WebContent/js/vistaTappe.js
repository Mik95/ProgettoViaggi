$(document).ready(function(){
	
	$.ajax({
		url: 'tappe',
		method: 'get'
	})
	.done(function(tappe){
			localStorage.setItem('tappe', JSON.stringify(tappe));
	})

})

var tappe=localStorage.getItem('tappe');
tappe = JSON.parse(tappe);

var id_pacchetto=sessionStorage.getItem('id_pacchetto');
id_pacchetto = JSON.parse(id_pacchetto);


$(document).ready(function(){
	tappe.forEach(function(t){
		if(t.pacchettoViaggio.idPacchettoViaggio==id_pacchetto){
			$('#tappeSalvate').append('<table align="center" id="dentrolabel">'
			+'<tr>'
			+'<td align="center" class="tappa">'
			+'Milano<br>01/01/2018'
			+'</td>'
		
			+'<td align="center" class="linea">'
			+'<img src="img/airplane.png" width="30px">'
			+'<hr color="white" size="2px">'
			+'</td>'
		
			+'<td align="center" class="tappa">'
			+'Roma<br>01/01/2018'
			+'</td>'      		
			+'</tr>'
			);
		}
	})
})