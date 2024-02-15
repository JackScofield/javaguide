import java.util.*;




public class Solution {
    public static int getValue(Map<String, Integer> map, String input, int numRetries) throws Exception {
        try {
            return map.get(input);
        }
        catch (Exception e) {
            if (numRetries > 3) {
                throw e;
            }
            return getValue(map,input, numRetries + 1);
        }
    }
    public static void main(String[] args) throws Exception {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张三", 30));
        personList.add(new Person("李四", 20));
        personList.add(new Person("王五", 10));
        personList.add(new Person("小红", 5));

        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for(Person p : personList){
            System.out.println(p.getName() + "-" + p.getAge());
        }
    }
}
