import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] numbers = new int[n][n];

        for (int i=0 ; i<n ; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j=0 ; j<n ; j++){
                numbers[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[][] sums = new int [n+1][n+1];
        for (int i=1; i<=n ; i++){
            for (int j=1 ; j<=n ; j++){
                sums[i][j] = sums[i-1][j]-sums[i-1][j-1]+sums[i][j-1]+numbers[i-1][j-1];

            }
        }


        
        int max_value = 0;
        for (int i=k ; i<=n ; i++){
            for (int j=k ; j<=n ; j++){
                int value = sums[i][j]+sums[i-k][j-k]-sums[i-k][j]-sums[i][j-k];
                if (value > max_value) max_value = value;
            }   
        }

        System.out.println(max_value);

    }
}