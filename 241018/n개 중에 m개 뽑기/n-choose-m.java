import java.io.*;
import java.util.*;

public class Main {
    public static int n,m;
    public static int[] result;
    public static void dfs(int idx, int before){
        if (idx == m){
            for (int i=0; i<m; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
        } else{
            for (int i=before+1; i<=n; i++){
                result[idx] = i;
                dfs(idx+1, i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        result = new int[m];

        dfs(0,0);

    }
}