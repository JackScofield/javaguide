## System Design

* Understand the problem and establish the design scope (Back of envelope) 3-10min
* Propose high-level design and get buy-in
* Design deep dive
* Wrap up



Distributed, performance optimization, monitoring



### Rate Limiter

* token bucket
* leaking bucket
* fixed window counter
* sliding window log
* sliding window counter

<img src="C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201124245395.png" alt="image-20231201124245395" style="zoom:80%;" />

![image-20231201124514276](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201124514276.png)







### Consistent Hashing

![image-20231201125008854](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201125008854.png)

<img src="C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201125147673.png" alt="image-20231201125147673" style="zoom:80%;" />





### Key-value storage

![image-20231201125259773](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201125259773.png)

<img src="C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201125916309.png" alt="image-20231201125916309" style="zoom:80%;" />

![image-20231201131552189](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201131552189.png)

![image-20231201131628693](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201131628693.png)

![image-20231201131641720](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201131641720.png)





### Unique Id generator in distributed system

Multi-master replication

UUID

Ticket Server

Twitter snowflake approach

![image-20231201132926611](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201132926611.png)





### URL shortener

![image-20231201132953797](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201132953797.png)

![image-20231201133022199](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201133022199.png)

HASH function base62

![image-20231201133108273](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201133108273.png)





### Web crawler

![image-20231201135050727](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201135050727.png)





### Notification System

contact info gathering, User profile

![image-20231201135342864](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201135342864.png)

![image-20231201135420807](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201135420807.png)







### News feed system

![image-20231201140517037](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201140517037.png)

fan out on read and write 



![image-20231201141844860](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201141844860.png)

News feed cache only stores:

postId userId

postId userId









### Chatting System

Websocket, long polling

single server

![image-20231201143607018](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201143607018.png)

DB: cassandra

Data model:

Message_ID

Message from

message to

content:

create_at 



Need server discovery to find the best chat server for client

![image-20231201143757011](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201143757011.png)

Use heartbeat to check temp disconnected





### Design youtube

Focus on posting videos and streaming videos

posting:

![image-20231201144421754](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201144421754.png)





### Google Drive(cloud storage)

![image-20231201145552222](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201145552222.png)

![image-20231201145649768](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201145649768.png)



### Ad event aggregate System

![image-20231201151608919](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20231201151608919.png)

​	