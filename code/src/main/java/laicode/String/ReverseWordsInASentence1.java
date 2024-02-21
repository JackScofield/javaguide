package laicode.String;

public class ReverseWordsInASentence1 {

    public static String reverseWords(String input) {
        // Write your solution here
        String reversed = utils.reverseWithIndex(input,0,input.length()-1);
        int left = 0;
        int right =0;
        String res = reversed;
        for(int i =0;i<reversed.length();i++){
            if(reversed.charAt(i) != ' '){
                right++;
                if(right == reversed.length()-1){
                    res = utils.reverseWithIndex(res,left,right);
                    break;
                }
            }
            else{
                res = utils.reverseWithIndex(res,left,right-1);
                left = i+1;
                right = i+1;
            }
        }
        return res;
    }

}


