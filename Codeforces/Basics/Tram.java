import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tram {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int minCapacity = 0;
        int currState = 0;
        while(n-->0){
            int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int exit = arr[0];
            int enter = arr[1];
            currState = (currState - exit) + enter;
            minCapacity = Math.max(minCapacity, currState);
        }
        System.out.println(minCapacity);
    }
}
