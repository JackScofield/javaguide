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
  class Person implements Comparable<Person>
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





尊敬阿里云领导：您好！我是浦泽元。我硕士毕业于约翰霍普金斯大学，专业是计算机科学；本科就读于伦斯勒理工学院，修数学和计算机双学位。我在本科和研究生期间也有着多年课上课后的软件开发经验，得知阿里云在西雅图的software engineer职位后（Software Engineer-Seattle Alibaba Cloud · Seattle, WA）,我十分渴望能加入阿里云这个团队。阿里云作为国内最知名的云计算服务商，在世界范围有更大的发展也是令人备受鼓舞。我在20年回国实习期间用过阿里云的ECS，操作易上手体验良好，十分期待能在北美aws，gcp，azure三足鼎立的局面下，看到阿里云的市场。

根据在LinkedIn上的岗位需求，所需技能包括network programming, multi-thread programming，c/c++和python等脚本语言。我在JHU上过两门计算机网络相关的课程，上过一门parallel computing, 对岗位所需知识也算是有理论储备和一些实习经验。此外对于一些开源系统如Hadoop, k8s, Cassandra 也有一些涉猎，虽然仅仅是皮毛但也对此充满好奇，也享受学习和开源的过程。我愿意保持努力，虚心学习，融入团队，为了阿里云在世界范围的更好发展贡献自己的一份力量。

我相信一定有大量的跟我一样想法的中国留学生向往阿里里云，所以特别感谢阿里云领导的推荐，让我离优秀的团队更近一步，我会尽最大的努力去储备知识、准备面试。再次感谢，祝新年快乐身体健康！  

浦泽元 2024.2.4



