
function noBack() { window.history.forward(); }

$('#li1').click(function(){
	document.getElementById('tpl').width=500;
});

$('#li2').click(function(){
	document.getElementById('tpl').width=450;
});

function ingrandimento() {
	document.getElementById('logobar').height=50;
};

function rimpicciolimento() {
	document.getElementById('logobar').height=40;
};

function cambiaImgGooglePlay() {
	document.getElementById('appLink').src="img/GooglePlayOver.png";
}

function ricambiaImgGooglePlay() {
	document.getElementById('appLink').src="img/GooglePlay.PNG";
}

function cambiaImgFb() {
	document.getElementById('pageLink').src="img/facebookOver.png";
}

function ricambiaImgFb() {
	document.getElementById('pageLink').src="img/facebook.png";
}

/*
	HOME
*/

function controlloAccedi(){
	
	var email = document.getElementById('email').value;
	var pw = document.getElementById('password').value;
	
	if ((email == "") || (email == "undefined")) {
			window.alert("Il campo Username è obbligatorio.");
		   document.modulo.user.focus();
		   return false;
		}
	
	if ((pw == "") || (pw == "undefined")) {
			window.alert("Il campo Password è obbligatorio.");
		   document.modulo.pw.focus();
		   return false;
		}
}

function controlloRegistrati(){
	
	var nome = document.getElementById('name').value;
	var cognome = document.getElementById('lastname').value;
	var email = document.getElementById('email2').value;
	var pw = document.getElementById('password2').value;
	
	if ((nome == "") || (nome == "undefined")) {
		window.alert("Il campo Nome è obbligatorio.");
	   document.modulo.nome.focus();
	   return false;
	}

	if ((cognome == "") || (cognome == "undefined")) {
		window.alert("Il campo Cognome è obbligatorio.");
	   document.modulo.cognome.focus();
	   return false;
	}
	
	if ((email == "") || (email == "undefined")) {
			window.alert("Il campo Email è obbligatorio.");
		   document.modulo.email.focus();
		   return false;
		}
	
	if ((pw == "") || (pw == "undefined")) {
			window.alert("Il campo Password è obbligatorio.");
		   document.modulo.pw.focus();
		   return false;
		}
}

function controlloLogin(){
	
	var utente = sessionStorage.getItem('utente');
	
	if(utente)
		top.location.href = 'MieiViaggi.html';
}

/*
	IL MIO PROFILO
*/

function cambiaPW(){
	var richiesta = window.confirm("Stai per cambiare la tua Password. Vuoi continuare?");
    
    if (richiesta)
    	top.location.href = 'CambiaPassword.html'
}

function logout(){
	var richiesta = window.confirm("Stai per uscire da questo account. Vuoi continuare?");
    
    if (richiesta){
    	top.location.href = 'Home.html';
    	localStorage.clear();
    	sessionStorage.clear();
    }
    		
}

/*
ALTRO
*/

function controlloAccount(){
	
	var utente = sessionStorage.getItem('utente');
	
	if(!utente)
		top.location.href = 'Home.html';
}

