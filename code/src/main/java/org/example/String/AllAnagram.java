package String;

import java.util.ArrayList;
import java.util.List;

import static String.utils.isAnagram;

public class AllAnagram {
    public static List<Integer> allAnagrams(String sh, String lo) {
        // Write your solution here
        if(sh == null || lo == null){
            return null;
        }
        int shLength = sh.length();
        List<Integer> res = new ArrayList<>();
        for(int i =0;i<lo.length()-shLength+1;i++){
            String tmp = lo.substring(i,i+shLength);
            if(isAnagram(tmp,sh)){
                res.add(i);
            }
        }
        return res;
    }
}
