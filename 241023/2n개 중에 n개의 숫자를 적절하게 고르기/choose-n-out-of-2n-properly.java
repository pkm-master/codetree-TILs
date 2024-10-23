import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int totalSum, ans, n;
    public static int[] selected;
    public static boolean[] visited;


    public static void dfs(int idx, int j){
        if (idx == n){
            int selectedSum = 0;
            for (int i=0; i<n; i++){
                selectedSum += arr[selected[i]];
            }
            int notSelected = totalSum - selectedSum;

            ans = Math.min(ans, Math.abs(selectedSum - notSelected));

            return;
        }
        for (int i=j; i<2*n; i++){
            if( !visited[i]){
                visited[i] = true;
                selected[idx] = i;
                dfs(idx+1,i+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[2*n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        totalSum = 0;
        for (int i=0; i<2*n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
            totalSum+=arr[i];
        }

        selected = new int[n];
        visited = new boolean[2*n];
        ans = (int)1e9;
        
        dfs(0,0);

        System.out.println(ans);
    }
}