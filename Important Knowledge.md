## Important Knowledge

### Pessimistic Lock & OptimisticLock



#### Pessimistic lock

in java, `synchronized` is a pessimistic lock

One thread lock the resource, other threads has to wait for the release.



#### Optimistic lock

Always assume the best situation. Assume resource is ok to access, thread is able to operate without need to wait or lock.

When commit, check if the resource has been used by other threads

Used version number or CAS algorithm.



optimistic is usually good for high concurrent situation, but is too much write operation, will cause problem.





In all:

* pessimistic lock is good for many write operation situation
* optimistic lock is good for many read operation situation





##### CAS algorithm

compare and swap:

cas is an atomic operation

* Var: variable will be updated
* Expected: expected value
* N: new value

Example:

Thread A want to change variable i to 6. i's old value is 1. (V = 1, E = 1, N = 6).

1.  i == 1, no other threads change the variable, set i = 6
2. i != 1, i has been changed, CAS failed.

If multiple threads are doing CAS for one variable, only one will win. Other threads can stop or do it again.



##### Problem for optimistic lock

ABA problem for CAS algorithm:

When doing CAS operation: if V == E, we cannot ensure that V has not been changed. for example, V = 1, changed to 2 then change back to 1.

Salvation: add version number or timestamp



Loop operation problem: 

for those threads failed to operate, loop trial will cost. Set `pause`



### JMM Java memory model

