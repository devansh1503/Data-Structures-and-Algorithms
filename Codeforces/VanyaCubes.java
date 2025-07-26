import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VanyaCubes {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        int height = 0;
        while(total<n){
            height++;
            int cubesOnLevel = height * (height + 1) / 2;
            total += cubesOnLevel;
        }
        if(total > n){
            System.out.println(height-1);
        }
        else System.out.println(height);
    }
}
