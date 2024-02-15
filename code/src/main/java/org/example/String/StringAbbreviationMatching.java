package org.example.String;

public class StringAbbreviationMatching {
    public static boolean match(String input, String pattern) {
        // Write your solution here
        if(input == null || pattern == null){
            return false;
        }
        if(input.length() < pattern.length()){
            return false;
        }
        char[] patternArray = pattern.toCharArray();
        char[] inputArray = input.toCharArray();
        int i = 0;
        int j = 0;
        while(i<inputArray.length && j < patternArray.length){

            if(patternArray[j]>='0' && patternArray[j]<='9'){
                int count = 0;
                while(j<patternArray.length && patternArray[j]>='0' && patternArray[j]<='9'){
                    count = count * 10 + (patternArray[j]-'0');
                    j++;
                }
                i+=count;
            }
            else{
                if(inputArray[i] == patternArray[j]){
                    i++;
                    j++;
                }
                else{
                    return false;
                }
            }
        }
        return i==inputArray.length && j == patternArray.length;
    }
}
