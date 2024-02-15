package org.example.String;

import java.util.*;

public class SortStringLIst {
    public static List<List<String>> sortAndOutPutAnagram(String[] s){
        Map<String, List<String>> map = new HashMap<>();

        for (String str : s) {
            // Convert string to char array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // Add the original string to the map under its sorted version
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
    private static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int[] table = new int[256];
        for(int i =0;i<s1.length();i++){
            table[s1.charAt(i)]++;
        }
        for(int i =0;i<s2.length();i++){
            table[s2.charAt(i)]--;
        }
        for(int i =0;i<256;i++){
            if(table[i] != 0){
                return false;
            }
        }
        return true;
    }


    public static String decodeString(String s) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = 0; // repeated time
        int i = 0;
        while(i<s.length()){
            if(array[i]-'0'<10 && array[i]-'1' > 0){
                n = array[i]-'0';
                i++;
                continue;
            }
            else if(array[i] == '['){
                int start = i+1;
                int count = 1;
                while( count != 0){
                    i++;
                    if(array[i] == '['){
                        count++;
                    }
                    if(array[i] == ']'){
                        count--;
                    }
                }
                String subStr = s.substring(start,i);
                for(int j = 0;j<n;j++){
                    sb.append(decodeString(subStr));
                }
                i++;

            }
            else{
                sb.append(array[i]);
                i++;
            }

        }
        return sb.toString();
    }
}
