package org.example.HashTableAndString;

public class DetermineIfOneStringIsAnotherSub {
    public int strstr(String large, String small) {
        // Write your solution here
        if(large.length()<small.length()){
            return -1;
        }
        if(small.length()==0){
            return 0;
        }
        for(int i=0;i<=large.length()-small.length();i++){
            if(large.charAt(i)==small.charAt(0)){
                int j=0;
                for(;j<small.length();j++){
                    if(large.charAt(i+j)!=small.charAt(j)){
                        break;
                    }
                }
                if(j==small.length()){
                    return i;
                }
            }
        }
        return -1;
    }
}
