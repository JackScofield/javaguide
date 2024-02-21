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

Use `grow` method:

```java
/**
 * 要分配的最大数组大小
 */
private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

/**
 * ArrayList扩容的核心方法。
 */
private void grow(int minCapacity) {
    // oldCapacity为旧容量，newCapacity为新容量
    int oldCapacity = elementData.length;
    // 将oldCapacity 右移一位，其效果相当于oldCapacity /2，
    // 我们知道位运算的速度远远快于整除运算，整句运算式的结果就是将新容量更新为旧容量的1.5倍，
    int newCapacity = oldCapacity + (oldCapacity >> 1);

    // 然后检查新容量是否大于最小需要容量，若还是小于最小需要容量，那么就把最小需要容量当作数组的新容量，
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;

    // 如果新容量大于 MAX_ARRAY_SIZE,进入(执行) `hugeCapacity()` 方法来比较 minCapacity 和 MAX_ARRAY_SIZE，
    // 如果minCapacity大于最大容量，则新容量则为`Integer.MAX_VALUE`，否则，新容量大小则为 MAX_ARRAY_SIZE 即为 `Integer.MAX_VALUE - 8`。
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);

    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```

Use bitwise shift to multiple by 1.5 faster than using multiply operation. 10 + 10/2 = 15, 33 + 33/2 = 49

`Arrays.copyOf()`

```java
public static int[] copyOf(int[] original, int newLength) {
  // 申请一个新的数组
    int[] copy = new int[newLength];
// 调用System.arraycopy,将源数组中的数据进行拷贝,并返回新的数组
    System.arraycopy(original, 0, copy, 0,
                     Math.min(original.length, newLength));
    return copy;
}

```

给原数组扩容



#### comparable and Comparator

* comparable interface from java.lang. it has a method `compareTo(Object obj)` to sort. A class needs to implement `comparable`

  ```java
  class laicode.Person implements Comparable<laicode.Person>
  ```

* `comparator` interface is from `java.util` , it has a method `int compare(Object o1, Obejct o2)`

  Used in sort method, new a comparator within the argument and overwrite the compare method in it.

  ```java
  Collections.sort(arrayList, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
          return o2.compareTo(o1);
          // return o2-o1;
      }
  });
  ```



#### ArrayDeque vs LinkedList

Both implement Deque interface

* `ArrayDeque` use size variable array and double pointers. `LinkedList` uses list
* `ArrayDeque` cannot store NULL, `LinkedList` can store NULL
* ArrayDeque is better in performance



#### PriorityQueue

* `PriorityQueue` use binary heap as data structure, itself is a size variable array
* `PriorityQueue` insert element and pop O(logn)
* `PriorityQueue` not thread safe, cannot store NULL



#### HashMap and HashSet

HashSet use HashMap to implement. 



#### HashSet how to check repeat element

When add something in hashset, 

* compute hashcode for the element, if no same hashcode, then assume element is not repeated
* if has the same hashcode, then use the `equals()` method to check if they are the same



#### HashMap implementation

![image-20240204160737979](C:\Users\24736\AppData\Roaming\Typora\typora-user-images\image-20240204160737979.png)

after jdk 1.8, if the length of list is larger than `8`

* check the size of array is larger than 64:
  * less than 64, enlarge the size of array
  * larger than 64, convert the list to red black tree



#### Why HashMap array size is always a power of 2

After you get the hash number, you need to do a module operation to get the actual index of the array.

If size of the array is `n`, to get the index is `hash % n`

And if n is a power of 2

`hash % n == hash & (n-1)`, more efficient for computing



#### Iterate a HashMap:

1. ForEach EntrySet:

   ```java
   Map<Integer, String> map = new HashMap();
   map.put(1, "Java");
   map.put(2, "JDK");
   map.put(3, "Spring Framework");
   map.put(4, "MyBatis framework");
   for (Map.Entry<Integer, String> entry : map.entrySet()) {
       System.out.println(entry.getKey());
       System.out.println(entry.getValue());
   }    
   ```

2. ForEach KeySet:

   ```java
   Map<Integer, String> map = new HashMap();
   map.put(1, "Java");
   map.put(2, "JDK");
   map.put(3, "Spring Framework");
   map.put(4, "MyBatis framework");
   
   for (Integer key : map.keySet()) {
       System.out.println(key);
       System.out.println(map.get(key));
   }
   ```

3. stream api
4. lambda



For all methods: `entrySet()` has the best performance



#### ConcurrentHashMap:

thread safe

![](pictures\concurrenthashmap1.png)

after jdk 1.8:

only synchronized the first node of the list or the root of the tree, if no hash collision, won't influence other read and write on other list or tree.





























