var strutture=localStorage.getItem('strutture');
strutture = JSON.parse(strutture);

var i=0;

$(document).ready(function(){
	var url= window.location.href;
	strutture.forEach(function(s){
		if(url.search('#'+s.idStruttura) >=0){
			$('#nome').html(s.nome);
			$('#nome').append('&nbsp;');
			
			switch(s.numeroStelle)
			{
			case 1: 
				$('#nome').append('<span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>&nbsp;');
				break;

			case 2: 
				$('#nome').append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>&nbsp;');
				break;
				
			case 3: 
				$('#nome').append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>&nbsp;');
				break;

			case 4: 
				$('#nome').append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span>&nbsp;');
				break;
				
			case 5: 
				$('#nome').append('<span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span>&nbsp;');
				break;	

			}
			
			$('#button').append('<a href="PrenotaMezzo.html#'+s.luogo.idLuogo+'"><input type="button" id="pa'+i+'" class="gestplan aview" value="Prenota Alloggio" /></a>');
			
			$('#pa'+i).click(function(){
				sessionStorage.setItem('id_struttura', JSON.stringify(s.idStruttura));
			})
			i++;
			
			$('#prezzo').append(s.prezzoAlGiorno+'€');
			
			$('#luogo').append('<img alt="maplogo" src="img/maps.png" width="20">&nbsp;Città: '+s.luogo.nome+'&nbsp; - &nbsp;Longitudine: '+s.longitudine+' &nbsp; - &nbsp;Latitudine: '+s.latitudine);
			
			switch(s.disponibilitaCamere){
			case true:
				$('#disp').append('<img src="img/checkYes.png" style="padding-top: 3px" height="16px">');
				break;
			case false:
				$('#disp').append('<img src="img/checkNo.png" style="padding-top: 3px" height="16px">');
				break;
				
			}
			
			$('#ntel').append(s.numeroTelefono);
			$('#email').append(s.email);
			$('#strutt').append(s.tipologiaStruttura);
			$('#sogg').append(s.tipoSoggiorno);
			$('#descrizione').append(s.descrizione);
			
			
			switch(s.piscina){
			case true:
				$('#piscina').append('<img src="img/checkYes.png" style="padding-top: 3px" height="16px">');
				break;
			case false:
				$('#piscina').append('<img src="img/checkNo.png" style="padding-top: 3px" height="16px">');
				break;
				
			}
			
			switch(s.parcheggio){
			
			case true:
				$('#park').append('<img src="img/checkYes.png" style="padding-top: 3px" height="16px">');
				break;
			case false:
				$('#park').append('<img src="img/checkNo.png" style="padding-top: 3px" height="16px">');
				break;
				
			}
			
			switch(s.animaliAmmessi){
			
			case true:
				$('#pets').append('<img src="img/checkYes.png" style="padding-top: 3px" height="16px">');
				break;
			case false:
				$('#pets').append('<img src="img/checkNo.png" style="padding-top: 3px" height="16px">');
				break;
				
			}
			
			switch(s.salaGiochi){
			case true:
				$('#sg').append('<img src="img/checkYes.png" style="padding-top: 3px" height="16px">');
				break;
			case false:
				$('#sg').append('<img src="img/checkNo.png" style="padding-top: 3px" height="16px">');
				break;
				
			}
			
			switch(s.salaCongressi){
			
			
			
			case true:
				$('#sc').append('<img src="img/checkYes.png" style="padding-top: 3px" height="16px">');
				break;
			case false:
				$('#sc').append('<img src="img/checkNo.png" style="padding-top: 3px" height="16px">');
				break;
				
			}
			
			switch(s.ascensore){
			
			case true:
				$('#ascensore').append('<img src="img/checkYes.png" style="padding-top: 3px" height="16px">');
				break;
			case false:
				$('#ascensore').append('<img src="img/checkNo.png" style="padding-top: 3px" height="16px">');
				break;
				
			}
			
			switch(s.ariaCondizionata){
			
			case true:
				$('#aria').append('<img src="img/checkYes.png" style="padding-top: 3px" height="16px">');
				break;
			case false:
				$('#aria').append('<img src="img/checkNo.png" style="padding-top: 3px" height="16px">');
				break;
				
			}
			
			switch(s.riscaldamento){
			
			case true:
				$('#risc').append('<img src="img/checkYes.png" style="padding-top: 3px" height="16px">');
				break;
			case false:
				$('#risc').append('<img src="img/checkNo.png" style="padding-top: 3px" height="16px">');
				break;
				
			}
			
			$('#foto1').append('<img style="top: 0px; left: 0px; width: 980px; height: 380px; position: absolute; display: block;" src="img/hotel/'+s.idStruttura+'0.png" />');
			$('#foto2').append('<img style="top: 0px; left: 0px; width: 980px; height: 380px; position: absolute; display: block;" src="img/hotel/'+s.idStruttura+'1.png" />');
			$('#foto3').append('<img style="top: 0px; left: 0px; width: 980px; height: 380px; position: absolute; display: block;" src="img/hotel/'+s.idStruttura+'2.png" />');
			$('#foto4').append('<img style="top: 0px; left: 0px; width: 980px; height: 380px; position: absolute; display: block;" src="img/hotel/'+s.idStruttura+'3.png" />');
			$('#foto5').append('<img style="top: 0px; left: 0px; width: 980px; height: 380px; position: absolute; display: block;" src="img/hotel/'+s.idStruttura+'4.png" />');
			
			
			var myLatLng = new google.maps.LatLng(s.latitudine,s.longitudine);
			var myOptions = {
				zoom: 14,
			        center: myLatLng,
			        mapTypeId: google.maps.MapTypeId.ROADMAP
			    }
				
			var map = new google.maps.Map(document.getElementById("mappa"), myOptions);
			    
			var marker = new google.maps.Marker({
			        position: myLatLng, 
			        map: map
			});
				
			var contentString = 'La struttura è qui';
			var infoWindow = new google.maps.InfoWindow({
			        content: contentString
			});
				
			google.maps.event.addListener(marker, 'click', function() {
			        infoWindow.open(map,marker);
			});  
			
			
		}
	})
	

	
})