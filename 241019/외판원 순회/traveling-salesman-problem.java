import java.io.*;
import java.util.*;


public class Main {
    public static int[][] arr;
    public static int n;
    public static boolean[] visited;
    public static int[] selected;
    public static int ans;

    public static void dfs(int idx){

        if (idx == n-1){
            int sum = 0;
            sum += arr[0][selected[0]-1];
            sum += arr[selected[n-2]-1][0];

            for (int i=0; i<n-2; i++){
                sum += arr[selected[i]-1][selected[i+1]-1];
            }
            // System.out.println(Arrays.toString(selected));

            ans = Math.min(ans, sum);

        }else{
            for (int i=2; i<=n; i++){
                if (!visited[i]){
                    selected[idx] = i;
                    visited[i] = true;
                    dfs(idx+1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        selected = new int[n-1];
        arr = new int[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        ans = (int)1e9;

        dfs(0);

        System.out.println(ans);

    }
}