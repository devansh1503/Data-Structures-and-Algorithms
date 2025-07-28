import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckySumDig {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 7a + 4b = n
        // 4s first then 7s to make the smallest
        int a = -1, b = -1;
        for(int i=n/7; i>=0; i--){
            if((n-(7*i))%4 == 0){
                a = i;
                b = (n-(7*i))/4;
                break;
            }
        }
        if(a==-1 && b==-1){
            System.out.println(-1);
            return;
        }

        StringBuilder str = new StringBuilder();
        for(int i=0; i<b; i++){
            str.append("4");
        }
        for(int i=0; i<a; i++){
            str.append("7");
        }
        System.out.println(str);
    }
}

// 4+4+4+4+7+7+7+7 = 44