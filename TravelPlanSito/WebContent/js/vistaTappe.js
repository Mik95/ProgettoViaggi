
var tappe=localStorage.getItem('tappe');
tappe = JSON.parse(tappe);

var id_pacchetto=sessionStorage.getItem('id_pacchetto');
id_pacchetto = JSON.parse(id_pacchetto);

var pacchetto=localStorage.getItem('pacchetto');
pacchetto = JSON.parse(pacchetto);

var luoghi=localStorage.getItem('luoghi');
luoghi = JSON.parse(luoghi);

var i=0, Obj=0;

var citta;
luoghi.forEach(function(l){
	if(l.idLuogo==pacchetto.idLuogo)
		citta=l.nome;
});

$.ajax({
	url: 'tappe',
	method: 'get'
})
.done(function(tappe){
		localStorage.setItem('tappe', JSON.stringify(tappe));
})

$(document).ready(function(){
	
	var Obj = {
			struttura: "Partenza:",
			luogo: citta,
			data: pacchetto.partenza
		}
	
	tappe.forEach(function(t){
		if(t.pacchettoViaggio.idPacchettoViaggio==id_pacchetto){
			$('#tappeSalvate').append('<table align="center" id="dentrolabel">'
			+'<tr>'
			+'<td align="center" class="tappa">'
			+Obj.struttura+'<br><br>'+Obj.luogo+'<br>'+Obj.data
			+'</td>'
		
			+'<td align="center" class="linea">'
			+'<div id="img'+i+'"></div>'
			+'<hr color="white" size="2px">'
			+'</td>'
		
			+'<td align="center" class="tappa">'
			+t.struttura.nome+'<br><br>'+t.struttura.luogo.nome+'<br>'+Obj.data
			+'</td>'      		
			+'</tr><br>'
			);
			
			Obj = {
					struttura: t.struttura.nome,
					luogo: t.struttura.luogo.nome,
					data: t.dataFineTappa
				}
		}
		
		switch(t.mezzo.tipoMezzo)
			{
			case "Aereo":
				$('#img'+i).append('<img src="img/airplane.png" width="30px">');
				break;
			case "Autobus":
				$('#img'+i).append('<img src="img/bus.png" width="30px">');
				break;
			case "Automobile":
				$('#img'+i).append('<img src="img/car.png" width="30px">');
				break;
			case "Treno":
				$('#img'+i).append('<img src="img/train.png" width="30px">');
				break;
			}
		
		i++;
		
	})
})
