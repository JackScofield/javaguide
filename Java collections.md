### Java collections

Java collections: Collection interface, Map interface

Collection Interface: List, Set, Queue (subinterface)

Map interface

![image-20240130160816482](/Users/jackpu/Library/Application Support/typora-user-images/image-20240130160816482.png)



#### List, Set, Queue, Map differences

* `List`: elements are indexed, could be repeated
* `Set`: elements are unique, not indexed, non-repeatable
* `Queue` FIFO, indexed, repeatable
* `Map`: key-value pairs. key is unique, each key only matches one value



#### Collections data structure

##### List

* `ArrayList`: `Object[]` object array
* `Vector`: `Object[]` array
* `LinkedList`: two direction list (after jdk 1.7)

##### Set

* HashSet: based on `HashMap` , store elements in hashmap
* `LinkedHashSet`: 
* `TreeSet`: red black tree

##### Queue

* `PriorityQueue`: `Object[]` array

* `ArrayQueue: ` `Object[]` array and 2 pointers.

##### Map

* `HashMap`:  array +linkedlist.  Collision solver: if the size of linkedlist is larger than threshold (default is 8), if the array size is less than 64, extends the size of array. if array size is larger than 64, convert linkedlist to red black tree. (time efficiency)

* `LinkedHashMap`
* `Hashtable`, array + linkedlist
* `TreeMap`: red black tree



#### ArrayList vs Vector

* `ArrayList` is implementation class of `List` interface, use `Object[]`, not thread safe.
* `Vector` is old implementation class of `List` interface, use `Object[]`, thread safe.



#### ArrayList vs LinkedList

* Both not thread safe
* Arraylist use Object array, LinkedList use doubly linked llist (after jdk 1.7)
* Add element:
  * `ArrayList`, if use `add(E e)`, it will add new element at the end, which would be O(1), if use `add(int index, E e)` it would be O(n-1), move all elements backward.
  * `LinkedList`, add or remove from the head or tail, O(1). add in the middle, O(n), need to move to that place first
* ArrayList can be accessed with index faster than LinkedList
* ArrayList might waste mem space, because it would leave some empty space for future elements. LinkedList need to store pointers, so it also wastes some men space.

We do not use linkedlist for most part, even Josh Bloch said he would not use LinkedList.

![image-20240130163806241](/Users/jackpu/Library/Application Support/typora-user-images/image-20240130163806241.png)



#### ArrayList change array size

```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable{

  }
```





testgit 

