
function getResponse(url_link){
    var response = '';
    $.ajax({ type: "GET",   
             url: url_link,   
             async: false,
             success : function(text)
             {
                 response = text;
             }

    });
    return response;
}


function printResponse(url){
    var x = getResponse(url);
    console.log(x);
}