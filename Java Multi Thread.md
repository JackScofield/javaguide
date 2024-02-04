### Java Multi Thread



#### Process and thread

* Process has its own memory space
* Thread share **heap**, every thread has its own **stack**



A *thread* is a thread of execution in a program. The Java Virtual Machine allows an application to have multiple threads of execution running concurrently.

Every thread has a priority. Threads with higher priority are executed in preference to threads with lower priority. Each thread may or may not also be marked as a daemon. When code running in some thread creates a new `Thread` object, the new thread has its priority initially set equal to the priority of the creating thread, and is a daemon thread if and only if the creating thread is a daemon.



A java program has a main thread and other threads running at the same time



#### Thread that not share:

##### Program Counter Register

The program counter in the JVM points to the current instruction that is being executed or interpreted. 

Each thread executes its own sequence of bytecode instructions independently of other threads, PC keeps track of the address of the current instruction that the thread is executing 

##### Stack





#### What Threads share:

heap: store new object



#### Thread life circle

* NEW: been created but not run `start()`
* RUNNABLE: after `start()` , running and ready(for os) runnable for jvm
* BLOCKED: need to wait for lock released
* WAITING: this thread is waiting for other threads doing something
* TIME_WAITING: exceed waiting time
* TERMINATED: run finished

![threadlifecircle](.\pictures\threadlifecircle.png)

#### Deadlock

##### What is deadlock

























