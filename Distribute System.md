## Distributed System

6.5840



### Theory and algorithm



#### CAP theory

Consistency: all node read get the latest version of the data

Availability: non error node should respond in time

Partition tolerance: network partition does not effect system



We can only choose CP or AP, no CA (network partition is premise)

CP: Zookeeper, HBase

AP: Cassandra, Eureka



#### Paxos Algorithm

* Basic Paxos: multi node consensus on a value
* Multi-Paxos



#### Raft Algorithm

##### 2. Basic

Node type:

* Leader
* Candidate
* Follower

![](.\pictures\raft1.png)

Term:

term is increasing number

Every term begins with a election, and if no leader is elected, it will start another term

Once a candidate becomes a leader, it starts a term

Every node stores its term number, and if one node term number is smaller than others, it will updates, if a candidate or leader find its term is outdated, it will become a follower.



Log:

* entry
* log



##### 3. select a leader

Raft use heartbeat to select a leader.

A node receive heartbeat from leader or candidate, it will reset the countdown and remain follower.



A leader must receive N/2 + 1 votes



##### 4. log replica

Once a leader has been elected, it takes client requests, appends them to its log, and then replicates these log entries to the other nodes (followers). The leader waits for a majority of nodes to acknowledge the log entries before considering them committed and responding to the client.



Raft chooses **consistency over availability** in the face of network partitions, ensuring that the system does not process conflicting updates that could lead to data inconsistency, at the cost of not being able to serve write requests in partitions without a majority.









### Map/Reduce







