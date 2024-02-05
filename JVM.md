## JVM

Hotspot VM

![jvm](/Users/jackpu/Desktop/work/javaguide/pictures/jvm.png)

### JVM memory management



For java, with the help of JVM, no need to use delete/free operation to clean up all created object.

Java programmer give memory control to JVM. So it is important to know how JVM works if memory leak occurs.



#### Java runtime data area

![runtimedataarea](/Users/jackpu/Desktop/work/javaguide/pictures/runtimedataarea.png)



##### Java VM stack

stack is thread private,born with the thread creation, die when the thread terminated.

Method local variables are in stack

Stack:

* Stack frame:
  * lcoal variable
  * operation number
  * dynamic links
  * method return address

Local variable can be primitive type and reference of object

Stack is not unlimited, but usually is enough. If method has loop call, and push too many into the stack, it will output `StackOverFlowError`  error

There are 2 return method in java. first is use return and second is throwing exception.And with the return will pop out the stack frame.

* `StackOverFlow`, stack is not dynamically expand, and when thread requires more stack space than JVM allowed
* `OutOfMemoryError` stack space is dynamically expanded. But JVM cannot get enough space when expanding stack space.



##### Native method satck

used for `native` method



##### Heap:

Largest memory space in JVM

All threads share the same heap. 

**Heap is used to store the object instance, almost all object instances and array allocate memory space in heap**



Garbage Collection mainly works on heap.

In the aspect of GC, heap can be separated: Eden, Survivor, Old 

![GC1](/Users/jackpu/Desktop/work/javaguide/pictures/GC1.png)

Eden, s0s1 (survivor) new

Tenured, old

MetaSpace, permanent



For most cases: 

object instance will allocate space in eden. After GC in new generation, if still alive, will be s0 or s1. Age will be increased to 1. After age reaches 15, will be old age.





##### String constant pool

**String constant pool** is a specific space JVM allocates for enhance the efficiency for string operation

```java
String aa = "ab"; // "ab"  is in heap. reference in string constant pool
String bb = "ab"; // bb get the reference of obejct "ab"
System.out.println(aa==bb); //true
```

String constant pool is in heap, easy for GC



#### HotSpot VM creating objects

What happened when create an object:

1. class loader checking:
2. Allocate memory space
   * bump pointer: no memory pieces. Used memory | free memory. A pointer in the middle. GC: Serial, ParNew
   * Free list: has memory pieces. Find a enough memory sector for the object. GC: CMS
3. set default value
4. Set object header, including hash, GC age, lock mark, class pointer
5. exe init()



### Garbage Collection

