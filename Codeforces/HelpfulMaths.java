import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HelpfulMaths {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]arr = Arrays.stream(br.readLine().split("\\+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        String res = "";
        for(int n : arr){
            res += n+"+";
        }
        System.out.println(res.substring(0,res.length()-1));
    }
}
