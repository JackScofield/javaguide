package CrossTraining;

public class RemoveAdjacentRepeatedCharactersIV {
    public static String deDup(String input) {
        // Write your solution here
        if(input == null || input.length() < 2){
            return input;
        }

        int left = 0;
        int right = 1;
        String res = input;
        boolean stop = false;
        while(right < input.length()){

            if(input.charAt(left) == input.charAt(right)){
                stop = true;
                right++;
            }
            else{
                if(!stop){
                    left++;
                    right++;
                }
                else{
                    res = helper(left,right,input);
                    break;
                }
            }
        }
        if(right - left == input.length()){
            return "";
        }
        if(right-left>1){
            res = helper(left,right,input);
        }

        if(res.equals(input)){
            return input;
        }
        return deDup(res);
    }

    private static String helper(int left, int right, String input){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<input.length();i++){
            if(i>=left && i < right){
                continue;
            }
            else{
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}
