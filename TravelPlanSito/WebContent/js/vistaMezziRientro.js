
$.ajax({
			url: 'mezzi',
			method: 'get'
		})
		.done(function(mezzi) {
				localStorage.setItem('mezzi', JSON.stringify(mezzi));
	
		});

var mezzi=localStorage.getItem('mezzi');
mezzi = JSON.parse(mezzi);

var pacchetto=localStorage.getItem('pacchetto');
pacchetto = JSON.parse(pacchetto);

var id_pacchetto=sessionStorage.getItem('id_pacchetto');
id_pacchetto = JSON.parse(id_pacchetto);

var i=0;

$(document).ready(function(){
	
	mezzi.forEach(function(m){
		
			if((pacchetto.idLuogo==m.arrivo.idLuogo)){
				
				switch(m.tipoMezzo){
		
				case 'Aereo':
					$('#aereo').append('<div class="card"><br><div class="prezzo">'+m.prezzo+'€</div><div class="descalloggio">Data: '+m.data+'</div><div class="descalloggio">Ora: '+m.ora+'</div><br><div align="center"><input type="button" class="gestplan prenmez" id="pm'+i+'" value="Prenota Mezzo""></div></div>');
					break;
			
				case 'Autobus':
					$('#autobus').append('<div class="card"><br><div class="prezzo">'+m.prezzo+'€</div><div class="descalloggio">Data: '+m.data+'</div><div class="descalloggio">Ora: '+m.ora+'</div><br><div align="center"><input type="button" class="gestplan prenmez" id="pm'+i+'" value="Prenota Mezzo""></div></div>');
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
			    
				var Obj = {
			    			idLuogo: pacchetto.idLuogo,
			    			idMezzo: m.idMezzoDiTrasporto,
			    			idPacchetto: id_pacchetto
			    	}
			    	
			    var richiesta = window.confirm("Stai prenotare questo mezzo per il ritorno. Vuoi continuare?");
			    
			    if (richiesta){
			    
			    	$.ajax({
						url: 'rientro',
						method: 'post',
						data: Obj
					})
			    	.done(function(tappe){
			    			localStorage.setItem('rientro', JSON.stringify(tappe));
			    			top.location.href="MieiViaggi.html";
			    	})
			    	
			    }

			});
			i++;
			
	});

});