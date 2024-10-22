import java.io.*;
import java.util.*;

public class Main {
    public static int[] numbers;
    public static int[] result;
    public static boolean[] visited;
    
    public static int n,ans,m;
    public static void dfs(int idx, int j){
        if (idx == m){
            // XOR 한 수 구하고 ans랑 비교
            int resultN = result[0];
            for (int i=1; i<m; i++){
                resultN = resultN ^ result[i];
            }
            ans = Math.max(ans,resultN);           
            return;
        }
        for (int i=j; i<n; i++){
            if (!visited[i]){
                result[idx] = numbers[i];
                visited[i] = true;
                dfs(idx+1, i);
                visited[i] = false;
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
        numbers = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(stk.nextToken());
        }

        visited = new boolean[n];

        dfs(0, 0);
        System.out.println(ans);
        // n개의 음이아닌 정수
        // m개를 뽑아 XOR

    }
}