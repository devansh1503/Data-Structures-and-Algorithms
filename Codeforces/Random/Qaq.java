import java.util.*;
import java.io.*;

public class Qaq{
    static String check = "QAQ";
    static HashMap<String, Integer>dp;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        dp = new HashMap<>();
        System.out.println(helper(str, "", 0));
    }
    public static int helper(String str, String curr, int idx){
        if(curr.length()>check.length()) return 0;
        if(curr.length() == check.length()){
            if(curr.equals(check)) return 1;
        }
        if(idx >= str.length()) return 0;
        if(dp.containsKey(curr+"-"+idx)) return dp.get(curr+"-"+idx);
        int take = helper(str, curr+str.charAt(idx), idx+1);
        int nottake = helper(str, curr, idx+1);
        dp.put(curr+"-"+idx, take+nottake);
        return take+nottake;
    }
}

// A more optimized approach will be to only append characters from QAQ keeping a check on their index as well