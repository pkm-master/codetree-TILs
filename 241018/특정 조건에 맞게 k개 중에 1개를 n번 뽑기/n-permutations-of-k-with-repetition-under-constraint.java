import java.io.*;
import java.util.*;

public class Main {
    public static int n,k;
    public static int[] result;
    public static void dfs(int idx){
        if (idx == n){
            for (int i=0; i<n; i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();

        }else{
            for (int i=1; i<=k; i++){
                if (idx>=2 && result[idx-1] == result[idx-2] && result[idx-1] == i){
                    continue;
                }
                result[idx] = i;
                dfs(idx+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        k = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        result = new int[n];

        dfs(0);

    }
}