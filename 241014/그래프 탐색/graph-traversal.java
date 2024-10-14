import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] adj;
    public static HashSet<Integer> set = new HashSet<>();
    public static boolean[] visited;
    public static void dfs(int node){

        visited[node] = true;
        set.add(node);

        for (int next:adj[node]){
            if (!visited[next]) dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        adj = new ArrayList[n+1];

        for (int i=0; i<=n; i++){
            adj[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++){
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());

            adj[s].add(e);
            adj[e].add(s);

        }
        visited = new boolean[n+1];

        dfs(1);

        System.out.println(set.size()-1);

    }
}