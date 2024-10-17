import java.io.*;
import java.util.*;


public class Main {
    public static int[][] lines;
    public static int n, maxAns;
    public static int[] horiz;
    public static int[] selected;

    public static int howMany(){
        int ans = 0;
        for (int i=0; i<n; i++){
            ans += selected[i];
        }

        return ans;
    }

    public static boolean isPossible(){
        horiz = new int[1001];
        for (int i=0; i<n; i++){
            if (selected[i] == 1){
                for (int j=lines[i][0]; j<=lines[i][1]; j++){
                    horiz[j]++;
                    if (horiz[j]==2){
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public static void dfs(int idx){
        if (idx==n){
            if (isPossible()){
                maxAns= Math.max(maxAns, howMany());
                
            }

        }else{
            for (int i=0; i<=1; i++){
                selected[idx] = i;
                dfs(idx+1);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lines = new int[n][2];
        selected = new int[n];

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());  
            lines[i][0] = Integer.parseInt(stk.nextToken());
            lines[i][1] = Integer.parseInt(stk.nextToken());
        }
        maxAns = 0;
        dfs(0);

        System.out.println(maxAns);
    }
}