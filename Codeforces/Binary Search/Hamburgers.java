import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hamburgers {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String recipe = br.readLine();
        String[]ing = br.readLine().split(" ");
        long n1 = Long.parseLong(ing[0]);
        long n2 = Long.parseLong(ing[1]);
        long n3 = Long.parseLong(ing[2]);
        String[]price = br.readLine().split(" ");
        long p1 = Long.parseLong(price[0]);
        long p2 = Long.parseLong(price[1]);
        long p3 = Long.parseLong(price[2]);
        long balance = Long.parseLong(br.readLine());

        int B = 0;
        int S = 0;
        int C = 0;
        for(char ch : recipe.toCharArray()){
            if(ch == 'B') B++;
            if(ch == 'S') S++;
            if(ch == 'C') C++;
        }

        long left = 0, right = 10000000000001L;
        while(left <= right){
            long mid = left + (right - left) / 2;

            long Bmax = mid * B;
            long Smax = mid * S;
            long Cmax = mid * C;

            Bmax -= n1;
            Smax -= n2;
            Cmax -= n3;

            long totalPrice = 0;

            if(Bmax>0){
                totalPrice += Bmax*p1;
            }
            if(Smax>0){
                totalPrice += Smax*p2;
            }
            if(Cmax>0){
                totalPrice += Cmax*p3;
            }

            if(totalPrice <= balance){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        System.out.println(right);

    }
    
}
