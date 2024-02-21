package laicode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int longest(String input) {
        // Write your solution here
        if(input == null || input.length()==0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while(fast<input.length()){
            if(!set.contains(input.charAt(fast))){
                set.add(input.charAt(fast));
                fast++;
                longest = Math.max(longest,(fast-slow));
            }
            else{
                set.remove(input.charAt(slow));
                slow++;
            }
        }
        return longest;
    }
}
