import java.io.*;
import java.util.*;


public class Main {
    public static int[][] arr;
    public static int n;
    public static boolean[] visited;
    public static int[] selected;
    public static int ans;

    public static void dfs(int idx){

        if (idx == n){
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i=0; i<n; i++){
                q.add(arr[i][selected[i]-1]);
            }

            ans = Math.max(ans, q.poll());

        }else{
            for (int i=1; i<=n; i++){
                if (!visited[i-1]){
                    selected[idx] = i;
                    visited[i-1] = true;
                    dfs(idx+1);
                    visited[i-1] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        selected = new int[n];
        arr = new int[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        ans = 0;

        dfs(0);

        System.out.println(ans);

    }
}