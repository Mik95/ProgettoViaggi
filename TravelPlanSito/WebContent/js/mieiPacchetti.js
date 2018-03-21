
$.ajax({
			url: 'pacchetti',
			method: 'get'
		})
		.done(function(pacchetti) {
				localStorage.setItem('pacchetti', JSON.stringify(pacchetti));
	
		});

$.ajax({
	url: 'tappe',
	method: 'get'
})
.done(function(tappe) {
		localStorage.setItem('tappe', JSON.stringify(tappe));

});

$.ajax({
	url: 'rientri',
	method: 'get'
})
.done(function(rientri) {
		localStorage.setItem('rientri', JSON.stringify(rientri));

});


var pacchetti=localStorage.getItem('pacchetti');
pacchetti = JSON.parse(pacchetti);

var tappe=localStorage.getItem('tappe');
tappe = JSON.parse(tappe);

var rientri=localStorage.getItem('rientri');
rientri = JSON.parse(rientri);

var luoghi=localStorage.getItem('luoghi');
luoghi = JSON.parse(luoghi);

var utente=sessionStorage.getItem('utente');
utente = JSON.parse(utente);

var i=0,j=0;

$(document).ready(function(){
	pacchetti.forEach(function(p){
		if(p.utente.email==utente.email){
			
			var Obj = {
					struttura: "Partenza:",
					luogo: p.partenza_arrivo.nome,
					data: p.dataPartenza
				}
			
			tappe.forEach(function(t){
				if(t.pacchettoViaggio.idPacchettoViaggio==p.idPacchettoViaggio){
					$('#listaPacchetti').append('<table style="color: #fff" align="center" id="dentrolabel">'
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
					}
				})
				
			rientri.forEach(function(r){
				if(r.idViaggioDiRientro==p.rientro.idViaggioDiRientro){
					$('#listaPacchetti').append('<table style="color: #fff" align="center" id="dentrolabel">'
							+'<tr>'
							+'<td align="center" class="tappa">'
							+Obj.struttura+'<br><br>'+Obj.luogo+'<br>'+Obj.data
							+'</td>'
						
							+'<td align="center" class="linea">'
							+'<div id="img'+i+'"></div>'
							+'<hr color="white" size="2px">'
							+'</td>'
						
							+'<td align="center" class="tappa">'
							+'Arrivo:<br><br>'+p.partenza_arrivo.nome+'<br>'+Obj.data
							+'</td>'      		
							+'</tr><br>'
							);
					
					switch(r.mezzo.tipoMezzo)
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
				}
			})
			
			$('#listaPacchetti').append('<table align="center">'
        			+'<tr>'
					+'<td><input type="button" id="mp'+j+'" class="gestplan" value="Modifica Piano"/></td>'
					+'<td><input type="button" id="ep'+j+'" class="gestplan" value="Elimina Piano" /></td>'
				+'</tr>'
    			+'</table>'
    			+'<hr style="height: 6px; border: 0px; background-color: #179b77; margin-bottom: 35px">'
    			);
			
			$('#mp'+j).click(function(){
				var Obj2 = {
						nPersone: p.numeroPersone,
						idLuogo: p.partenza_arrivo.idLuogo,
						partenza: p.dataPartenza,
						email: utente.email
				}
				
				localStorage.setItem('pacchetto', JSON.stringify(Obj2));
				sessionStorage.setItem('id_pacchetto', p.idPacchettoViaggio);
				location.href="AggiungiTappe.html";
			})
			
			$('#ep'+j).click(function(){
				
				var Obj3 = {
						idPacchetto: p.idPacchettoViaggio
				}
				
				var richiesta = window.confirm("Stai per eliminare questo Piano. Vuoi continuare?");
			    
			    if (richiesta){
				
			    	$.ajax({
			    		url: 'deletePack',
			    		method: 'get',
			    		data: Obj3
			    	})
			    	.done(function(esito) {
			    		localStorage.setItem('elimina', esito);
			    		location.href="MieiViaggi.html";
			    	});
			    	
			    }
			})
			
			j++;
		}
	})
})
