import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[][] nums = new int[N+1][N+1];
        int[][] sums = new int[N+1][N+1];

        for (int i=1 ; i<=N ; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=1 ; j<=N ; j++){
                nums[i][j] = Integer.parseInt(stk.nextToken());
                sums[i][j] = sums[i][j-1] + nums[i][j];
            }
        }

        int max_value = 0;

        for (int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                int partial = 0;
                for (int k=-K ; k<=K ; k++){
                    if(i-k>0 && i-k<=N ){
                        int s = Math.max(0,j-(K-Math.abs(k))-1);
                        int e = Math.min(N,j+(K-Math.abs(k)));
                        partial += (sums[i-k][e] - sums[i-k][s]);
                    }
                }
                if (max_value<partial) max_value = partial;
            }
        }
        System.out.println(max_value);
    }
}