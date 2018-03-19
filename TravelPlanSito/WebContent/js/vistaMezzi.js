
$.ajax({
			url: 'mezzi',
			method: 'get'
		})
		.done(function(mezzi) {
				localStorage.setItem('mezzi', JSON.stringify(mezzi));
	
		});

var mezzi=localStorage.getItem('mezzi');
mezzi = JSON.parse(mezzi);

var strutture=localStorage.getItem('strutture');
strutture = JSON.parse(strutture);

var pacchetto=localStorage.getItem('pacchetto');
pacchetto = JSON.parse(pacchetto);

var id_struttura=sessionStorage.getItem('id_struttura');
id_struttura = JSON.parse(id_struttura);

var id_pacchetto=sessionStorage.getItem('id_pacchetto');
id_pacchetto = JSON.parse(id_pacchetto);

var i=0;

$(document).ready(function(){
	
	mezzi.forEach(function(m){
		strutture.forEach(function(s){
			var url= window.location.href;
			if((url.search('#'+s.luogo.idLuogo) >=0) && (s.luogo.idLuogo==m.arrivo.idLuogo)){
				
				switch(m.tipoMezzo){
		
				case 'Aereo':
					$('#aereo').append('<div class="card"><br><div class="prezzo">'+m.prezzo+'€</div><div class="descalloggio">Data: '+m.data+'</div><div class="descalloggio">Ora: '+m.ora+'</div><br><div align="center"><input type="button" class="gestplan prenmez" id="pm'+i+'" value="Prenota Mezzo""></div></div>');
					break;
			
				case 'Autobus':
					$('#autobus').append('<div class="card"><br><div class="prezzo">'+m.prezzo+'€</div><div class="descalloggio">Data: '+m.data+'</div><div class="descalloggio">Ora: '+m.ora+'</div><br><div align="center">><input type="button" class="gestplan prenmez" id="pm'+i+'" value="Prenota Mezzo""></div></div>');
					break;
			
				case 'Automobile':
					$('#auto').append('<div class="card"><br><div class="prezzo">'+m.prezzo+'€</div><div class="descalloggio">Data: '+m.data+'</div><div class="descalloggio">Ora: '+m.ora+'</div><br><div align="center"><input type="button" class="gestplan prenmez" id="pm'+i+'" value="Prenota Mezzo""></div></div>');
					break;
			
				case 'Treno':
					$('#treno').append('<div class="card"><br><div class="prezzo">'+m.prezzo+'€</div><div class="descalloggio">Data: '+m.data+'</div><div class="descalloggio">Ora: '+m.ora+'</div><br><div align="center"><input type="button" class="gestplan prenmez" id="pm'+i+'" value="Prenota Mezzo""></div></div>');
					break;
			
				}
			}
			
			$('#pm'+i).click(function(){
				var fineTappa = prompt("Inserire la data in cui si vuole terminare la tappa:", "dd/MM/yyyy");
			    if (fineTappa != null && fineTappa != "dd/MM/yyyy") {
			    	
			    	var Obj = {
			    			idMezzo: m.idMezzoDiTrasporto,
			    			idStruttura: id_struttura,
			    			idPacchetto: id_pacchetto,
			    			data: fineTappa
			    	}
			    	
			    	$.ajax({
						url: 'tappa',
						method: 'post',
						data: Obj
					})
					.done(function() {
							top.location.href="AggiungiTappe.html";
				
					});
			    	
			    	$.ajax({
			    		url: 'tappe',
			    		method: 'get'
			    	})
			    	.done(function(tappe){
			    			localStorage.setItem('tappe', JSON.stringify(tappe));
			    	})
			    
			    }
			});
			i++;
			
		});
	});

});