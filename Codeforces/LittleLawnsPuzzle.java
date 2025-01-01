import java.io.*;
import java.util.*;

public class LittleLawnsPuzzle {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // Size of the grid

            // Read both rows of the puzzle
            int[] row1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] row2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // Build adjacency list to represent the columns as a graph
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                graph.computeIfAbsent(row1[i], k -> new ArrayList<>()).add(row2[i]);
                graph.computeIfAbsent(row2[i], k -> new ArrayList<>()).add(row1[i]);
            }

            // Count the number of connected components in the graph
            Set<Integer> visited = new HashSet<>();
            int components = 0;

            for (int num : graph.keySet()) {
                if (!visited.contains(num)) {
                    components++;
                    dfs(graph, num, visited);
                }
            }

            // The number of possible configurations is 2^components % MOD
            result.append(modularExponentiation(2, components, MOD)).append("\n");
        }

        // Print all results at once
        System.out.print(result);
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    private static long modularExponentiation(int base, int exp, int mod) {
        long result = 1;
        long power = base;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * power) % mod;
            }
            power = (power * power) % mod;
            exp >>= 1;
        }

        return result;
    }
}
