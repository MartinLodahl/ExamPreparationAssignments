
var originalJSON;

btnsend.onclick = function () {
    var amount = document.getElementById("amount").value;
    var region = document.getElementById("region").value;
    var gender = document.getElementById("gender").value;
    if (amount > 500) {
        alert("You can't pick that many people, for your smuggling routes (MAX 500)");
        return;
    }
    var url = GenerateURL(amount, region, gender);
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
    promise.then(function (response) {
        return response.json();
    }).then(function (json) {
        originalJson = json;
        var html;
        for (var i = 0; i < json.length; i++) {
            html += "<tr><td>" + json[i].name + "</td><td>" + json[i].surname + "</td><td>" + json[i].gender + "</td></tr>"
        }
        document.getElementById("tblbody").innerHTML = html;

    });
};

btnsql.onclick = function() {
    var array = [];
    for (var i = 0; i < originalJson.length; i++) {

        array.push(originalJson[i]);
    }
    array = array.map(function (x) {
        return "INSERT INTO names (name,surname,gender) VALUES (\"" + x.name + "\",\"" + x.surname + "\",\"" + x.gender+"\")";
    });
    array = array.join(";&#13;&#10");
    console.log(array);
    document.getElementById("sql").innerHTML = array;
};

function GenerateURL(amount, region, gender) {
    if (amount < 1) {
        amount = 1;
    }
    var url = "http://uinames.com/api/?amount=" + amount;
    if (region === "All" && gender === "both") {
    } else if (region === "All") {
        url += "&gender=" + gender;
    } else if (gender === "both") {
        url += "&region=" + region;
    } else if (true) {
        url += "&region=" + region + "&gender=" + gender;
    }
    return url;
}