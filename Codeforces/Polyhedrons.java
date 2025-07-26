import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Polyhedrons {
    public static void main(String[]args) throws IOException{
        HashMap<String, Integer>hm = new HashMap<>();
        hm.put("Tetrahedron", 4);
        hm.put("Cube", 6);
        hm.put("Octahedron", 8);
        hm.put("Dodecahedron", 12);
        hm.put("Icosahedron", 20);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        while(n-->0){
            String shape = br.readLine();
            sum += hm.get(shape);
        }
        System.out.println(sum);
    }
}
