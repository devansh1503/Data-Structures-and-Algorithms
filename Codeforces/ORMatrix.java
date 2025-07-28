import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ORMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = nm[0], cols=nm[1];
        int[][]grid = new int[rows][cols];
        for(int i=0; i<rows; i++){
            int[]r = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<cols; j++){
                grid[i][j] = r[j];
            }
        }
        Integer[][]res = new Integer[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 0){
                    fillRes(i, j, res);
                }
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(res[i][j] == null){
                    res[i][j] = 1;
                }
            }
        }
        boolean isOkay = verify(res, grid);
        if(isOkay){
            System.out.println("YES");
            for(Integer[]r : res){
                for(Integer num : r){
                    System.out.print(num+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("NO");
        }
    }
    public static void fillRes(int i, int j, Integer[][]res){
        res[i][j] = 0;
        int row = res.length;
        int col = res[0].length;
        for(int r=0; r<row; r++){
            res[r][j] = 0;
        }
        for(int c=0; c<col; c++){
            res[i][c] = 0;
        }
    }
    public static int makeCheck(int i, int j, Integer[][]res){
        int num = res[i][j];
        int row = res.length;
        int col = res[0].length;
        for(int r=0; r<row; r++){
            num |= res[r][j];
        }
        for(int c=0; c<col; c++){
            num |= res[i][c];
        }
        return num;
    }
    public static boolean verify(Integer[][]res, int[][]grid){
        int[][]toCheck = new int[res.length][res[0].length];
        for(int i=0; i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                if(res[i][j] == 0){
                    toCheck[i][j] = makeCheck(i, j, res);
                }
                else{
                    toCheck[i][j] = 1;
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(toCheck[i][j] != grid[i][j]) return false;
            }
        }
        return true;
    }
}
