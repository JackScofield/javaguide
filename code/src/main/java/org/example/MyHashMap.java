package org.example;

public class MyHashMap<K,V> {
    static class Node<K,V>{
        final K key;
        V value;
        Node<K,V> next;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }

        public void setValue(V value){
            this.value = value;
        }
    }

    private Node<K,V>[] array;
    private int size;
    private float load_factor;

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    public MyHashMap(int cap, float load_factor){
        if(cap<=0){
            throw new IllegalArgumentException("Cap should be larger than zero");
        }
        array = (Node<K, V>[]) (new Node[cap]);
        this.load_factor = load_factor;
        size = 0;
    }

    public MyHashMap(){
        this(DEFAULT_CAPACITY,DEFAULT_LOAD_FACTOR);
    }

    public synchronized int size(){
        return size;
    }
    public synchronized boolean isEmpty(){
        return size == 0;
    }

}
