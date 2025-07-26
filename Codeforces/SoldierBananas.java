import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SoldierBananas {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = input[0];
        int n = input[1];
        int b = input[2];
        long totalCost = (long)b*(b+1)/2 * k; // (1+2+3+.....)*k
        long res = Math.max(0, totalCost-n);
        System.out.println(res);
    }
}
