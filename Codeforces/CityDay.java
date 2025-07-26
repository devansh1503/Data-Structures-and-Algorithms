import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CityDay {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]inp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int x = inp[1];
        int y = inp[2];

        for(int i=0; i<arr.length; i++){
            int j = i;
            boolean flag = true;
            while(j>=0 && j>=i-x){
                if(arr[j]<arr[i]){
                    flag = false;
                    break;
                }
                j--;
            }
            j=i;
            if(!flag) continue;
            while(j<arr.length && j<=i+y){
                if(arr[j]<arr[i]){
                    flag = false;
                    break;
                }
                j++;
            }
            if(flag){
                System.out.println(i+1);
                break;
            }
        }
    }
}
