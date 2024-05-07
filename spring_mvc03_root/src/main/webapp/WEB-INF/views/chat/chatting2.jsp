<!DOCTYPE html>
<html>
<head>
    <title>WebSocket Chat</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        var stompClient = null;
        var roomId;

        function connect() {
        	// var socket = new SockJS('chat-ws2.do');
        var	socket = new WebSocket("ws://localhost:8090/chat-ws2.do");
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/public', function(messageOutput) {
                    showMessageOutput(JSON.parse(messageOutput.body));
                });
                stompClient.subscribe('/user/queue/chatroom/create', function(chatRoom) {
                    var room = JSON.parse(chatRoom.body);
                    roomId = room.id;
                    $('#roomInfo').html('Room created with ID: ' + roomId);
                });
                stompClient.subscribe('/topic/room/' + roomId, function(messageOutput) {
                    showMessageOutput(JSON.parse(messageOutput.body));
                });
            });
        }

        function disconnect() {
            if (stompClient !== null) {
                stompClient.disconnect();
            }
            console.log("Disconnected");
        }

        function createRoom() {
            var roomName = $('#roomName').val();
            stompClient.send("/app/chatroom.create", {}, JSON.stringify({
                'name': roomName
            }));
        }

        function joinRoom() {
            roomId = $('#roomId').val();
            stompClient.send("/app/chatroom.join", {}, JSON.stringify({
                'id': roomId
            }));
            $('#roomInfo').html('Joined Room ID: ' + roomId);
        }

        function sendMessage() {
            var message = $('#message').val();
            stompClient.send("/app/chatroom.sendMessage", {}, JSON.stringify({
                'message': message
            }));
        }

        function showMessageOutput(messageOutput) {
            var message = messageOutput.content;
            var sender = messageOutput.sender;
            $('#chat').append('<div><strong>' + sender + '</strong>: ' + message + '</div>');
        }

        $(function () {
            connect();
            $('form').on('submit', function(e) {
                e.preventDefault();
            });
            $( "#disconnect" ).click(function() { disconnect(); });
            $( "#send" ).click(function() { sendMessage(); });
            $( "#createRoom" ).click(function() { createRoom(); });
            $( "#joinRoom" ).click(function() { joinRoom(); });
        });
    </script>
</head>
<body>
<div id="roomInfo"></div>
<div id="chat"></div>
<form>
    <input type="text" id="roomName" placeholder="Enter room name" />
    <button id="createRoom">Create Room</button>
    <input type="text" id="roomId" placeholder="Enter room ID to join" />
    <button id="joinRoom">Join Room</button>
    <br>
    <input type="text" id="message" placeholder="Type a message..." />
    <button id="send">Send</button>
    <button id="disconnect">Disconnect</button>
</form>
</body>
</html>
