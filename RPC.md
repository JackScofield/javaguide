## RPC



RPC protocol is on TCP



### From TCP

if we need to send data from one process to another between 2 computers, we can use `socket`

We can use TCP or UDP, but TCP is reliable so :

```c
int fd = socket(AF_INET,SOCK_STREAM,0);
```



Once we have a socket, we can use `bind()` to bind a ip port , use `connect()` to connect, use `send()` and `recv()` to communicate.



### Problem with pure TCP

TCP has properties: **connection oriented, reliable, byte stream**

Byte stream is just a stream of 0 and 1, we cannot just use byte steam cause it is meanless.

We need to define some protocol to determine the boundary of the message.



Every data has **header** and **body**

Based on TCP, many protocols been invented such as HTTP and RPC



### HTTP vs RPC

RPC is remote procedure call 

HTTP is Hyper Text Transfer Protocol

![](.\pictures\rpc1.png)

By using RPC, we can call a remote function just like a local one.

![rpc2](.\pictures\rpc2.png)

There are many RPC specification: gRPC and thrift

Note: although most RPC use TCP, not all of them using TCP, gRPC use http2



#### Why do we need HTTP since we have RPC

RPC is before HTTP, 

before Http, most connection is client/server (c/s), every software just use its company's RPC.

But here comes a new software called Browser. And it is Browser/server (B/S)

Every company should obey the same protocol to develop communication between browser and server. 

Http was firstly invented for B/S communication.



Now RPC more used between microservices within each company.

But why we still need RPC since http is more general.



#### Difference between RPC and Http

Data content, 

Json Protobuf -> 0 and 1 serialize

RPC and Http all need serialize and deserialize



But for http, header is always very big and takes a lot of space, RPC using protobuf, which header is very small and using TCP connection pool.



HTTP2 vs RPC:

HTTP2 is very good even better than RPC, and gRPC using Http2, but Http2 is very new and RPC has been used for 40 years, so it will remain at least for near future.

![](.\pictures\rpc3.png)







### gPRC

a RPC framework

![](.\pictures\rpc4.png)



Use case:

![](.\pictures\rpc5.png)

![](.\pictures\rpc6.png)