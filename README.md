# chat_server_api
Chat Server API to save and retrieve multiple user chat messages

local server host and port: localhost:9393
Mongo DB: localhost:27017/chat

API:
Chat Messages: API to Save and Retrive from Mongo DB collection: ChatMessage
/messages/from/{user}
Sample : localhost:9393/messages/from/test : Retrieve all the messages sent from specific user
/messages/from/{user}/room/{room}
Sample : localhost:9393/messages/from/test/room/111 : Retrieve all the messages sent from specific user to specific room 111

Chat Rooms:API to Save and Retrieve all the chat rooms available from Mongo collection: ChatRoom
/rooms/: 
Sample: localhost:9393/rooms/ : Retrieve all the rooms currently in database

User API: To handle login, logout, user creation and deletion from Mongo collection User
/userInfo/: 
Sample:localhost:9393/userInfo/active : Retrieve all the Users logged in currently in the system

