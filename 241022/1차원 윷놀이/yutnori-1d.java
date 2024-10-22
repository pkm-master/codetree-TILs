import java.io.*;
import java.util.*;

public class Main {
    public static int[] dist;
    public static int[] result;
    public static int n,m,k,ans;
    public static void dfs(int idx){
        if (idx == n){
            int currScore = 0;
            for (int i=0; i<k; i++){
                if(result[i]>=m){  
                    currScore++;
                }
            }
            
            ans = Math.max(ans,currScore);

            return;

        }
        for (int i=0; i<k; i++){
            result[i] += dist[idx];
            dfs(idx+1);
            result[i] -= dist[idx];
            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        dist = new int[n];
        stk = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            dist[i] = Integer.parseInt(stk.nextToken());
        }
        result = new int[k];
        for (int i=0; i<k; i++){
            result[i] = 1;
        }
        dfs(0);

        System.out.println(ans);

    }
}