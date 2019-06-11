
function printResponse(url){
    var x = getResponse(url);
    console.log(x);
    return x;
}

var x = printResponse("http://localhost:8500/quest/?s=start");

function printNrefresh(url){
	var y = printResponse(url);
	

	var x = printResponse("http://localhost:8500/quest/?s=start");
	if (x[0] == "D"){
		location.replace("final.html");
		console.log("hey");
	}else{
		console.log(x[0]);
	}


}