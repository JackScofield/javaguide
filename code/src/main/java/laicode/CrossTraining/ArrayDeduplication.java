package laicode.CrossTraining;

import java.util.*;

public class ArrayDeduplication {
    public int[] dedup(int[] array) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i =0;i<array.length;i++){
            if(!visited.contains(array[i])){
                res.add(array[i]);
                visited.add(array[i]);
            }
        }
        int[] result = new int[res.size()];
        for(int i =0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
    public static int[] dedup2(int[] array) {
        // Write your solution here
        Map<Integer,Integer> table = new HashMap<>();
        for(int i =0;i<array.length;i++){
            if(!table.containsKey(array[i])){
                table.put(array[i],1);
            }
            else if(table.get(array[i])==1){
                table.put(array[i],2);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i =0;i<array.length;i++){
            if(table.get(array[i]) == 1){
                res.add(array[i]);
                table.put(array[i],0);
            }
            else if(table.get(array[i]) == 2){
                res.add(array[i]);
                res.add(array[i]);
                table.put(array[i],0);
            }
        }
        int[] result = new int[res.size()];
        for(int i =0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }


    public int[] dedup3(int[] array) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> arrayMap = new HashMap<Integer,Integer>();

        for(int i =0;i<array.length;i++){
            if(arrayMap.containsKey(array[i])){
                arrayMap.put(array[i],arrayMap.get(array[i])+1);
            }
            else{
                arrayMap.put(array[i],1);
            }
        }

        for(int i =0;i<array.length;i++){
            if(arrayMap.get(array[i])==1){
                res.add(array[i]);
            }
        }

        int[] result = convert(res);
        return result;
    }

    private int[] convert(List<Integer> res){
        int[] result = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
