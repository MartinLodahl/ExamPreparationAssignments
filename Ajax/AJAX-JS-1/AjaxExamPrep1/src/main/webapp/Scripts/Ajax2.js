var clicked = "fr";

function country(event) {
    console.log(clicked);
    console.log(document.getElementById(clicked));
    document.getElementById(clicked).style.fill="#c0c0c0";
    clicked = event.target.id;
    document.getElementById(clicked).style.fill="red";
    var url = "http://restcountries.eu/rest/v1/alpha?codes=" + clicked;
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
    promise.then(function (response) {
        return response.json();
    }).then(function (json) {
        console.log(json);
        infoPlace = document.getElementById("info");
        infoPlace.innerHTML = "";
    infoPlace.innerHTML+="name "+json[0].name+"<br>";    
    infoPlace.innerHTML+="population "+json[0].population+"<br>";
    infoPlace.innerHTML+="Subregion "+json[0].subregion+"<br>";
    infoPlace.innerHTML+="Bording countries "+json[0].borders +"<br>";
    });
}

