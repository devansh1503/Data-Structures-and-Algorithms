import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleOnRect {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        while(t-->0){
            String[]wh = br.readLine().split(" ");
            long w = Long.parseLong(wh[0]);
            long h = Long.parseLong(wh[1]);

            String[]xbottom = br.readLine().split(" ");
            String[]xtop = br.readLine().split(" ");
            String[]yleft = br.readLine().split(" ");
            String[]yright = br.readLine().split(" ");

            // Area of triangle = h*b/2 here we need to return Area * 2 = h*b

            long areaBottom = h * (Long.parseLong(xbottom[xbottom.length-1]) - Long.parseLong(xbottom[1]));
            long areaTop = h * (Long.parseLong(xtop[xtop.length-1]) - Long.parseLong(xtop[1]));
            long areaLeft = w * (Long.parseLong(yleft[yleft.length-1]) - Long.parseLong(yleft[1]));
            long areaRight = w * (Long.parseLong(yright[yright.length-1]) - Long.parseLong(yright[1]));

            long res = Math.max(Math.max(areaBottom, areaTop), Math.max(areaLeft, areaRight));

            System.out.println(res);
        }
    }
}
