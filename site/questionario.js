
function printResponse(url){
    var x = getResponse(url);
    console.log(x);
    return x;
}

printResponse("http://localhost:8500/quest/?s=start");

function printNrefresh(url){
	var y = printResponse(url);
	

	var x = printResponse("http://localhost:8500/quest/?s=start");
	if (x == 'acabou'){
		window.location.href="final.html";
	}
}