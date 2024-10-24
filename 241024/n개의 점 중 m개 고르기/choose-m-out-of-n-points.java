import java.io.*;
import java.util.*;
class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static Pair[] points;
    public static int n,m,ans,partAns;
    public static int[] selected;
    public static boolean[] visited;
    public static int[][] dist;

    public static int[] twoSelected;

    public static void max(int idx, int j){
        if (idx == 2){
            int result = dist[selected[twoSelected[0]]][selected[twoSelected[1]]];
            partAns = Math.max(result,partAns);
            return;
        }
        for (int i=j; i<m; i++){
            twoSelected[idx] = i;
            max(idx+1,i+1);
        }
    }

    public static void dfs(int idx, int j){
        if (idx==m){
            partAns = 0;
            max(0,0);
            ans = Math.min(ans, partAns);

            return;
        }
        for (int i=j; i<n; i++){
            if (!visited[i]){
                selected[idx] = i;
                visited[i] = true;
                dfs(idx+1, i);
                visited[i] = false;
            }
        }
    }
    public static int distance(Pair p1, Pair p2){
        // 거리반환
        return (int)Math.pow(p1.x-p2.x,2) + (int)Math.pow(p1.y-p2.y,2);
    
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        points = new Pair[n];
        selected = new int[m];
        visited = new boolean[n];
        twoSelected = new int[2];
        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            points[i] = new Pair(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }
        dist = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                dist[i][j] = distance(points[i], points[j]);
            }
        }

        ans = (int)1e9;

        dfs(0,0);

        System.out.println(ans);

    }
}