package laicode;

public class Counter {
    public static int value = 0;
    public static void inc(){
        synchronized ((Counter.class)){
            value++;
        }
    }

    public void increase(){
        synchronized (this){
            value++;
        }
        System.out.println("Hello increase");
    }

    public static synchronized void decrease(){
        value--;
    }
    public static int getCounter(){
        synchronized (Counter.class){
            return value;
        }
    }


}
