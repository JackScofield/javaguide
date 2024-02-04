# SDE Interview



## JAVA



### Java foundation

#### JVM vs JDK vs JRE

##### JVM

The Java Virtual Machine (JVM) is the virtual machine that runs the Java **class file (.class)**.The JVM has specific implementations for different systems (Windows, Linux, macOS) that are designed to use the same bytecode and they all give the same results. Bytecode and system-specific JVM implementations are the key to the "compile once, run anywhere" nature of the Java language.

There are more than just one JVM, the **HotSpot VM** is simply an implementation of the JVM specification.



##### JDK and JRE

JDK = Java Development Kit

JRE = Java Runtime Environment



JDK contains everything of JRE, and **javac** and other tools

JRE has JVM, java modules



#### .class file bytecode

In Java, the code that can be understood by the JVM is called bytecode (i.e., a file with a .class extension), which is not specific to any particular processor, but **only to the virtual machine**.

The Java language, by means of bytecode, solves to a certain extent the problem of the low efficiency of execution of traditional interpreted languages, and at the same time, retains the characteristics of the interpreted languages that can be ported. Therefore, Java programs run relatively efficiently (although there is still a gap with languages such as C++, Rust, Go, etc.), and because the bytecode is not specific to a particular machine, Java programs can be run on computers with many different operating systems **without recompilation**.

https://en.wikipedia.org/wiki/Java_bytecode



![image-20240123205305982](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20240123205305982.png)



#### Java key word

![image-20240123205451816](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20240123205451816.png)



#### Java variables

**member variable**: declared in class, not in method, stored on heap (primitive)

**local variable**: declared in method, not in class, stored on stack

 





#### Overload and Overwrite

Overloading: same method name different arguments, different process, constructor

Overwrite: child class inherite parent class method, same arguments, different process. Constructor cannot be overwrited

![image-20240123233121520](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20240123233121520.png)



#### Java data type

4 整数： byte short int long

2 float: float double

1 character: char

1 bool: boolean

![image-20240123235322632](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20240123235322632.png)



#### Object oriented 4 properties

##### abstraction

##### encapsulation

private variable and use get set

##### inheritance

1. child class has all variables and methods from parent class. Child class cannot access to private variables and methods of parent class.
2. child class can extend parent class
3. child class can implement parent method in its own way

##### polymorphism 

parent class reference to child class. Interface



#### Interface vs abstract class

common:

* cannot be instantiated
* can have abstract method

difference:

* implement an interface = has the ability to ... / abstract class = affiliation
* one class can only extend one class, but can implement multiple interfaces
* in interface, variable must be `public static final`, cannot be modified and have to have default value. in abstract class, variables set to default, can be changed



#### Deep copy and shallow copy/ reference copy

**Shallow Copy**: A shallow copy creates a new object on the heap (a difference from a reference copy), however, if the original object's internal attributes are of reference type, the shallow copy directly copies the internal object's reference address, i.e., the copied object and the original object share the same internal object.

**Deep Copy**: A deep copy makes an exact copy of the entire object, including any internal objects contained within the object.

**reference copy** 2 different references point to a same object

![image-20240124200818069](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20240124200818069.png)





#### Object class

##### object class commmon methods

object class is the parent class of all classes, it has 11 main methods:

```java
/**
 * native 方法，用于返回当前运行时对象的 Class 对象，使用了 final 关键字修饰，故不允许子类重写。
 */
public final native Class<?> getClass()
/**
 * native 方法，用于返回对象的哈希码，主要使用在哈希表中，比如 JDK 中的HashMap。
 */
public native int hashCode()
/**
 * 用于比较 2 个对象的内存地址是否相等，String 类对该方法进行了重写以用于比较字符串的值是否相等。
 */
public boolean equals(Object obj)
/**
 * naitive 方法，用于创建并返回当前对象的一份拷贝。
 */
protected native Object clone() throws CloneNotSupportedException
/**
 * 返回类的名字实例的哈希码的 16 进制的字符串。建议 Object 所有的子类都重写这个方法。
 */
public String toString()
/**
 * native 方法，并且不能重写。唤醒一个在此对象监视器上等待的线程(监视器相当于就是锁的概念)。如果有多个线程在等待只会任意唤醒一个。
 */
public final native void notify()
/**
 * native 方法，并且不能重写。跟 notify 一样，唯一的区别就是会唤醒在此对象监视器上等待的所有线程，而不是一个线程。
 */
public final native void notifyAll()
/**
 * native方法，并且不能重写。暂停线程的执行。注意：sleep 方法没有释放锁，而 wait 方法释放了锁 ，timeout 是等待时间。
 */
public final native void wait(long timeout) throws InterruptedException
/**
 * 多了 nanos 参数，这个参数表示额外时间（以毫微秒为单位，范围是 0-999999）。 所以超时的时间还需要加上 nanos 毫秒。。
 */
public final void wait(long timeout, int nanos) throws InterruptedException
/**
 * 跟之前的2个wait方法一样，只不过该方法一直等待，没有超时时间这个概念
 */
public final void wait() throws InterruptedException
/**
 * 实例被垃圾回收器回收的时候触发的操作
 */
protected void finalize() throws Throwable { }

```



##### == vs equals()

`==`:

* for primitive type, `==` compares value 3==2 return false 
* for reference, `==` compares the address in memory

`equals()`

equals() cannot use for primitive types, it is used to determine whether 2 objects are the same or not. Every class has equals() methods.

* if a class does not overwrite `equals()`, it use `Object` `equals()`
* if a class does overwrite `equals()`, (what we usually do)

Example:

```java
String a = new Stirng("abc");
String b = new String("abc");
String aa = "abc";
String bb = "abc";
System.out.println(aa == bb);// true
System.out.println(a == b);// false
System.out.println(a.equals(b));// true
System.out.println(42 == 42.0);// true
```



#### hashcode()







#### String

##### String, StringBuffer, StringBuilder

String cannot be changed, why: 

```java
public final class String implements java.io.Serializable,Comparable<String>, CharSequence {
    // @Stable 注解表示变量最多被修改一次，称为“稳定的”。
    @Stable
    private final byte[] value;
}

abstract class AbstractStringBuilder implements Appendable, CharSequence {
    byte[] value;

}
```

it has `final` key word, final class cannot be inherited. 

1. `value[]` is private and final, no method to change the value
2. String class is final cannot be inherited

Note: why use `byte[]` not `char[]` after java9: if use Latin-1, char takes 2 bytes and byte takes 1 byte.



`StringBuilder` and `StringBuffer` extends `AbstractStringBuilder`



StringBuilder is not thread safe, StringBuffer is thread save because it has lock

if change a string object, it would create a new string and make this reference point to the new string. 



##### string concat using "+" or StringBuilder

java does not support overloading for arithmetic operations,  "+" and "+=" only for `String`

Using "+" for string would new a StringBuilder in bytecode, and using append() to implement concat



##### String equals()

`String` has overwrite `equals()`, used to compare the value of 2 strings

##### StringTable in heap

StringTable is a memory space specifically for string in JVM. Used to improve the efficiency and reduce mem cost, reduce the repeated creating of strings

````java
// 在堆中创建字符串对象”ab“
// 将字符串对象”ab“的引用保存在字符串常量池中
String aa = "ab";
// 直接返回字符串常量池中字符串对象”ab“的引用
String bb = "ab";
System.out.println(aa==bb);// true
````



##### String with +

```java
String str1 = "str";
String str2 = "ing";
String str3 = "str" + "ing";
String str4 = str1 + str2;
String str5 = "string";
System.out.println(str3 == str4);//false
System.out.println(str3 == str5);//true
System.out.println(str4 == str5);//false
```

In 



#### Exception 和 Error 有什么区别

Every exception has a same parent class `java.lang.Throwable`



* `Exception` can be handled by program, using `catch` to get the exception. `checked Exception` `Unchecked Exception`

* `Error` cannot be handled by the program. JVM will end thread.

  ![image-20240127051334556](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20240127051334556.png)

* `Checked Exception`, if this exception is not `catch` or `throws`, cannot compile

  Any other exception except `RuntimeException` and its child classes, they are `checked exception`\

* `Unchecked Exception` : `RuntimeException` and its child classes



##### Throwable class method

* String getMessage(): return brief message
* String toString(): return detailed message
* void printStackTrace() print on cmd



##### try-catch-finally

```java
try {
    System.out.println("Try to do something");
    throw new RuntimeException("RuntimeException");
} catch (Exception e) {
    System.out.println("Catch Exception -> " + e.getMessage());
} finally {
    System.out.println("Finally");
}

```

do not use `return` in finally

finally may not be executed, if jvm terminated, thread close





#### Java reflection







































