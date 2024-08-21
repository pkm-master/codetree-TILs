// -1000이상 1000이하의 숫자로 이루어진 n*n크기의 2차원 격자
// 격자를 벗어나지 않는 적절한 직사각형중 사각형 내 숫자들의 합이 최대가 되도록
import java.io.*;
import java.util.*;


public class Main {

    public static int n;
    public static int[][] arr;
    public static int[][] prefix;
    public static int[] dp;
    
    // i1,j1 i2,j2 사이 직사각형 합 반환
    public static int sum(int i1, int j1, int i2, int j2){
        return prefix[i2][j2] - prefix[i1-1][j2] - prefix[i2][j1-1] + prefix[i1-1][j1-1]; 
    }

    // 시작행과 끝행 사이에서 가능한 최대합 반환 
    public static int maxSum(int i1, int i2){
        int max = -1000*300*300;
        dp = new int[n+1];

        for (int j=1; j<=n; j++){
            int part = sum(i1,j,i2,j);
            dp[j] = Math.max(part, dp[j-1]+part);
            max = Math.max(max,dp[j]);
        }

        return max;

    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prefix = new int[n+1][n+1];

        for (int i=1; i<=n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++){
                prefix[i][j] = prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+Integer.parseInt(stk.nextToken());

            }
        }

        int ans = -1000*300*300;

        for (int i1=1; i1<=n; i1++){
            for (int j1=i1; j1<=n; j1++){
                ans = Math.max(ans, maxSum(i1,j1));
            }
        }

        System.out.println(ans);

    }

}