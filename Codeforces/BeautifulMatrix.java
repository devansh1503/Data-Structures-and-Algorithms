import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulMatrix {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int oneRow = 0;
        int oneCol = 0;
        for(int i=0; i<5; i++){
            String[]row = br.readLine().split(" ");
            for(int j=0; j<row.length; j++){
                if(row[j].equals("1")){
                    oneRow = i;
                    oneCol = j;
                }
            }
        }
        int res = Math.abs(2-oneRow) + Math.abs(2-oneCol);
        System.out.println(res);
    }
}
