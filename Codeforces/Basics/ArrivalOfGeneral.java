import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrivalOfGeneral {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[]copy = new int[n];
        for(int i=0; i<n; i++){
            copy[i] = arr[i];
        }
        Arrays.sort(copy);
        int max = copy[n-1];
        int min = copy[0];

        int firstMax = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == max){
                firstMax = i;
                break;
            }
        }
        int firstMin = n-1;
        for(int i=n-1; i>=0; i--){
            if(arr[i] == min){
                firstMin = i;
                break;
            }
        }
        if(firstMax > firstMin){
            System.out.println((firstMax-0)+(n-firstMin-1)-1); //One swap deducted for swap of min and max in between
        }
        else{
            System.out.println((firstMax-0)+(n-firstMin-1));
        }
    }
}
