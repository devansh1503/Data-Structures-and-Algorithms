import java.util.*;
import java.io.*;

// Need to optimize

public class OutstandingImpressionist{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String res = "";
            HashMap<Integer, Integer>duplicates = new HashMap<>();
            int[]left = new int[n];
            int[]right = new int[n];
            int i=0;
            int len = n;
            while(len-- > 0){
                int[]lr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int l = lr[0];
                int r = lr[1];
                left[i] = l;
                right[i] = r;
                if(l == r){
                    duplicates.put(l, duplicates.getOrDefault(l,0)+1);
                }
                i++;
            }
            for(int x=0; x<n; x++){
                if(left[x] == right[x]){
                    res += (duplicates.get(left[x])>1) ? '0' : '1';
                    continue;
                }
                int j=left[x];
                boolean valid = false;
                while(j<=right[x]){
                    if(!duplicates.containsKey(j)){
                        res += '1';
                        valid = true;
                        break;
                    }
                    j++;
                }
                if(!valid) res+='0';
            }
            result.append(res).append("\n");
        }
        System.out.println(result);
    }
}

