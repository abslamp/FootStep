


function loadJSON(){
    var HttpRequest = new XMLHttpRequest();
    var DataFile = "fleet/vin/7c08973d-bed4-4cbd-9c28-9282a02a6032?page=0&size=10";

    HttpRequest.onreadystatechange = function () {
        if(HttpRequest.readyState == 4){
            var JsonObj = JSON.parse(HttpRequest.responseText);
            document.getElementById("test").innerHTML = JsonObj.content[0].address;
        }
    }
    HttpRequest.open("GET", DataFile, true);
    HttpRequest.send();
}




function showChat(message) {
    var response = document.getElementById('board');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(message.message));
    response.appendChild(p);
}


var stompClient = null;
window.onload = function () {
    // $.cookie('receiveAddress','/topic/chat');
    connect($.cookie('receiveAddress'));
}

function connect(receiveAddress) {
    var socket = new SockJS('/stomp');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function() {
        stompClient.subscribe(receiveAddress, function(calResult){  //  /topic/chat
            showChat(JSON.parse(calResult.body));
        });
    });
}

function send(sendAddress) {
    var inputValue = document.getElementById("chatInput").value;
    stompClient.send(sendAddress, {}, JSON.stringify({ 'message': inputValue }));

    //   /app/sendMessage
}



// function setupWebSocketConnection() {
//     $.ajax({
// //		beforeSend: function(xhrObj){
// //			xhrObj.setRequestHeader("Content-Type","application/json");
// //	    },
//         url: 'xml//test2',
//         success: function (stompUrlt) {
//             var stompUrl = 'stomp' ;
//             if (stompUrl) {
//                 var socket = new SockJS("//" + stompUrl);
//                 var stompClient = Stomp.over(socket);
//                 stompClient.heartbeat.outgoing = 0;
//                 stompClient.heartbeat.incoming = 0;
//                 stompClient.debug = function () {
//                 };  //turn off debugging
//                 var on_connect = function () {
//                     var inputValue = document.getElementById("test").value;
//                     stompClient.send("/app/sendMessage", {}, JSON.stringify({
//                         'message': encodeURIComponent(inputValue)
//                     }));
//                     console.log('Connected to vehicle updates: ' + stompUrl);
//                     stompClient.subscribe("/topic/chat", function (m) {
//                         var updateMsg = JSON.parse(m.body);
//                         showChat(updateMsg);
//                     });
//                 };
//                 var on_error = function () {
//                     /*
//                      * Re-attempt to connect to web socket.
//                      */
//                     setTimeout(setupWebSocketConnection, 3000);
//                 };
//                 stompClient.connect('guest', 'guest', on_connect, on_error, '/');
//             } else {
//                 console.error('Unknown URL for "service-location-updater". Vehicle location updates are disabled!');
//             }
//         },
//         error: function (xhr, error) {
//             console.error('Cannot retrieve "service-location-updater" URL.');
//             console.error(JSON.stringify(error));
//             /*
//              * Re-attempt to setup a web socket connection.
//              */
//             setTimeout(setupWebSocketConnection, 3000);
//         },
// //	    dataType: 'json'
//     });
// }