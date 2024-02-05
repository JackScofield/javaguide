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

Thread A has resource 2 and want resource 1

Thread B has resource 1 and want resource 2

When these 2 threads happen in the same time, both cannot get what they want and it comes to a deadllock

```java
public class DeadLockDemo {
    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "线程 2").start();
    }
}

```

```
Thread[线程 2,5,main]get resource2
Thread[线程 1,5,main]get resource1
Thread[线程 1,5,main]waiting get resource2
Thread[线程 2,5,main]waiting get resource1
```

four conditions:

1. mutual exclusion: only one thread can use a resource at any given time
2. hold and wait: a thread is holding at least one resource at a time and it waiting to acquire other resources held by other threads
3. No preemption: resources can only be released
4. circular wait: a set of processes are waiting for each other in a circular fashion.



#### Wait() and sleep()

wait is a method for object, because it releases the object lock

sleep() pause the thread, so it is in `Thread`



#### Can I use run() directly?

when use start() method, thread will be runable, and will automatically run(). If use run(), it will run it as a normal method in main thread.





#### volatile 

`volatile` is a modifier used with variables, it tells the JVM that the variable may be accessed and modified by multiple threads.

1. Visibility: ensure all thread that read the variable will see the most recently written value by any thread. Without `volatile`, variables may be cached by threads, meaning that if one thread updates the variable, other threads might not see that update if they are reading from their cached version of the variable. 
2. Prevention of Instruction Reordering

It does not provide atomicity and it is not a substitute for synchronization.





#### synchronized keyword

1. used for object instant method:

   ```java
   synchronized void method(){
   
   }
   ```

2. used for class static method:

   ```java
   synchronized static void method(){
   
   }
   ```

3. used for a piece of code

   * `synchronized(object)`
   * `synchronized(.class)`

   ```java
   synchronized(this){
       
   }
   ```

   

different synchronize scope



in JVM, use Monitor

##### synchronized(this)

When get lock , use monitorenter, if lock counter == 0, counter = 1. Get lock

use monitorexit, if has the lock, lock counter -=1, release lock

##### public synchronized void method(){}

use `ACC_SYNCHRONIZED` signal



#### Thread pool



