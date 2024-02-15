package String;

import java.util.HashMap;
import java.util.Map;

public class utils {
    public static String reverseWithIndex(String input, int l, int r){
        char[] array = input.toCharArray();
        int left = l;
        int right = r;
        while(left<right){
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return new String(array);
    }

    public static boolean isAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        Map<Character, Integer> tableA = new HashMap<>();

        for(int i =0;i<a.length();i++){
            char c = a.charAt(i);
            if(tableA.containsKey(c)){
                tableA.put(c, tableA.get(c)+1);
            }
            else{
                tableA.put(c,1);
            }
        }
        for(int i =0;i<b.length();i++){
            char c = b.charAt(i);
            if(!tableA.containsKey(c)){
                return false;
            }
            else{
                if(tableA.get(c)>0){
                    tableA.put(c,tableA.get(c)-1);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
