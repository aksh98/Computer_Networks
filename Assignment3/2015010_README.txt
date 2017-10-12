QUESTION:
Building on your PA2 assignment, you will add following capabilities to make it a full-fledged chat application like Whatsapp. 
Tasks

1. A client, say client 0, should be able to send following types of messages (one marks each):
a) Client X: Message - the message will be delivered to Client X.
b) All: Message - the message will be delivered to all present clients.
c) Client X,Y: Message - the message will be delivered to Client X and Y only
d) Server: "List All" - the message will go to server which will then reply with the list of all the clients that are currently connected.
e) If a client sends a message to another client which does not exist then the server should reply back saying the client does not exist.

————————————————————————————————————————————————————————— 


I created two files server_2015010.java and client_2015010.java
port: 2222
runs on localhost.
Server creates threads for each of the client and client has two threads for reading and writing.

use ctrl+c for exitting the client
Server runs even when you exit the client.

Format is as used in the question

