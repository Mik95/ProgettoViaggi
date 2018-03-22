$.ajax({
			url: 'listaStrutture',
			method: 'get'
		})
		.done(function(Struttura) {
				localStorage.setItem('strutture', JSON.stringify(Struttura));
	
		});

var strutture=localStorage.getItem('strutture');
strutture = JSON.parse(strutture);

var pacchetto=localStorage.getItem('pacchetto');
pacchetto = JSON.parse(pacchetto);

var i=0;

var ricerca=sessionStorage.getItem('ricerca');

$('#btnCerca').click(function(){
	sessionStorage.setItem('ricerca',$('#ricercaCitta').val());
	ricerca = JSON.parse(ricerca);
	
})

$(document).ready(function(){
	if(!ricerca || ricerca==""){
		strutture.forEach(function(s){
			if(s.luogo.idLuogo!=pacchetto.idLuogo){
				var stringa='<div class="field-wrap"><label class="planlabel">'
					+'<table align="center" id="dentrolabel">'
		            	+'<tr>'
							+'<td align="center" class="fotohotel">'
								+'<img src="img/hotel/'+s.idStruttura+'0.png" style="margin-top:30px" height="200px" width="200px">'
							+'</td>'
								
							+'<td>'
								+'<table style="width: 100%;">'
									+'<tr>'
										+'<td class="nomealloggio">'
											+s.nome+
											'&nbsp;'
											
											
											+'<span class="stars'+i+'"></span>'
											
										+'</td>'
										
										+'<td class="prezzo">'+s.prezzoAlGiorno+'€</td>'  
									+'</tr>'
									
									+'<tr><td class="descalloggio"><img alt="maplogo" src="img/maps.png" width="20">&nbsp;Città: '+s.luogo.nome+'&nbsp; - &nbsp;Longitudine: '+s.longitudine+' &nbsp; - &nbsp;Latitudine: '+s.latitudine+' </td></tr>'
									+'<tr><td class="descalloggio">Tipologia struttura: '+s.tipologiaStruttura+'</td></tr>'
									+'<tr><td class="descalloggio">'+s.descrizione+'</td></tr>'
								+'</table>'
							+'</td>'  		
		           		+'</tr>'
		           +'</table>'
		            		
		            +'<table align="center">'
		            	+'<tr>'
							+'<td><a href="AlloggioView.html#'+s.idStruttura+'"><input type="button" class="gestplan" value="Dettagli Alloggio"/></a></td>'
							+'<td><a href="PrenotaMezzo.html#'+s.luogo.idLuogo+'"><input type="button" class="gestplan" id="pa'+i+'" value="Prenota Alloggio" /></a></td>'
						+'</tr>'
		            +'</table>'
				+'</label>'
			+'</div>';
			
			
			$('#listaHotel').append(stringa);
			

			$('#pa'+i).click(function(){
					sessionStorage.setItem('id_struttura', JSON.stringify(s.idStruttura));
				})
			
			switch(s.numeroStelle)
			{
			case 1: 
				$('.stars'+i).append('<span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>&nbsp;');
				break;

			case 2: 
				$('.stars'+i).append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>&nbsp;');
				break;
				
			case 3: 
				$('.stars'+i).append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>&nbsp;');
				break;

			case 4: 
				$('.stars'+i).append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span>&nbsp;');
				break;
				
			case 5: 
				$('.stars'+i).append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span>&nbsp;');
				break;	

			}
			
			i++;
			
			}
		})
	}
	else{
		strutture.forEach(function(s){
			if(s.luogo.nome==ricerca){
				var stringa='<div class="field-wrap"><label class="planlabel">'
					+'<table align="center" id="dentrolabel">'
		            	+'<tr>'
							+'<td align="center" class="fotohotel">'
								+'<img src="img/hotel/'+s.idStruttura+'0.png" style="margin-top:30px" height="200px" width="200px">'
							+'</td>'
								
							+'<td>'
								+'<table style="width: 100%;">'
									+'<tr>'
										+'<td class="nomealloggio">'
											+s.nome+
											'&nbsp;'
											
											
											+'<span class="stars'+i+'"></span>'
											
										+'</td>'
										
										+'<td class="prezzo">'+s.prezzoAlGiorno+'€</td>'  
									+'</tr>'
									
									+'<tr><td class="descalloggio"><img alt="maplogo" src="img/maps.png" width="20">&nbsp;Città: '+s.luogo.nome+'&nbsp; - &nbsp;Longitudine: '+s.longitudine+' &nbsp; - &nbsp;Latitudine: '+s.latitudine+' </td></tr>'
									+'<tr><td class="descalloggio">Tipologia struttura: '+s.tipologiaStruttura+'</td></tr>'
									+'<tr><td class="descalloggio">'+s.descrizione+'</td></tr>'
								+'</table>'
							+'</td>'  		
		           		+'</tr>'
		           +'</table>'
		            		
		            +'<table align="center">'
		            	+'<tr>'
							+'<td><a href="AlloggioView.html#'+s.idStruttura+'"><input type="button" class="gestplan" value="Dettagli Alloggio"/></a></td>'
							+'<td><a href="PrenotaMezzo.html#'+s.luogo.idLuogo+'"><input type="button" class="gestplan" id="pa'+i+'" value="Prenota Alloggio" /></a></td>'
						+'</tr>'
		            +'</table>'
				+'</label>'
			+'</div>';
			
			
			$('#listaHotel').append(stringa);
			

			$('#pa'+i).click(function(){
					sessionStorage.setItem('id_struttura', JSON.stringify(s.idStruttura));
				})
			
			switch(s.numeroStelle)
			{
			case 1: 
				$('.stars'+i).append('<span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>&nbsp;');
				break;

			case 2: 
				$('.stars'+i).append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>&nbsp;');
				break;
				
			case 3: 
				$('.stars'+i).append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>&nbsp;');
				break;

			case 4: 
				$('.stars'+i).append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span>&nbsp;');
				break;
				
			case 5: 
				$('.stars'+i).append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span>&nbsp;');
				break;	

			}
			
			i++;
			
			}
		})
			
	}

})

	