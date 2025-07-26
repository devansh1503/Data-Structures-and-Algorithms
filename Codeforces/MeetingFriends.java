import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MeetingFriends {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]points = br.readLine().split(" ");
        int[]pt = new int[3];
        for(int i=0; i<3; i++){
            pt[i] = Integer.parseInt(points[i]);
        }
        Arrays.sort(pt);
        System.out.println((pt[1]-pt[0])+(pt[2]-pt[1]));
    }
}
