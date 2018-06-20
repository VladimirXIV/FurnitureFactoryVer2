function createDepartmentTableFromJSON(JSONArray) {

    var divID = document.getElementById("main");

    var fullTable = "<table>" +
                         "<th>" +
                            "<td>Department</td>" +
                         "</th>";

    for (i in JSONArray) {
        fullTable += "<tr>" +
                          "<td>" + JSONArray[i].name + "</td>" +
                      "</tr>";
    }

    fullTable += "</table>";

    divID.innerHTML += fullTable;
}

function createEmployeeTableFromJSON(JSONArray) {

    var divID = document.getElementById("main");

    var fullTable = "<table>" +
        "<th>" +
        "<td>Department</td>" +
        "</th>";

    for (i in JSONArray) {
        fullTable += "<tr>" +
            "<td>" + JSONArray[i].name + "</td>" +
            "</tr>";
    }

    fullTable += "</table>";

    divID.innerHTML += fullTable;
}

function createOrdertTableFromJSON(JSONArray) {

    var divID = document.getElementById("main");

    var fullTable = "<table>" +
        "<th>" +
        "<td>Department</td>" +
        "</th>";

    for (i in JSONArray) {
        fullTable += "<tr>" +
            "<td>" + JSONArray[i].name + "</td>" +
            "</tr>";
    }

    fullTable += "</table>";

    divID.innerHTML += fullTable;
}

function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById("footer").innerHTML = h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}

function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}

function getAllDepartments() {
    $.ajax ({
        type: "GET",
        url: "http://localhost:9080/furniturefactory-1.0-SNAPSHOT/getAllDepartments",
        datatype: "json",
        success: function(data) {
            createTableFromJSON(data)
        }
    })
}

function getAllEmployees() {
    $.ajax ({
        type: "GET",
        url: "http://localhost:9080/furniturefactory-1.0-SNAPSHOT/getAllDepartments",
        datatype: "json",
        success: function(data) {
            createTableFromJSON(data)
        }
    })
}

function getAllOrders() {
    $.ajax ({
        type: "GET",
        url: "http://localhost:9080/furniturefactory-1.0-SNAPSHOT/getAllDepartments",
        datatype: "json",
        success: function(data) {
            createTableFromJSON(data)
        }
    })
}