import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int[][] num_a = new int[n+1][m+1];
        int[][] num_b = new int[n+1][m+1];
        int[][] num_c = new int[n+1][m+1];
        
        int a,b,c;

        for (int i=1; i<=n ; i++){
            String line = br.readLine();
            for (int j=1; j<=m ; j++){
                char value = line.charAt(j-1);
                a=b=c=0;
                if (value == 'a') a=1;
                else if (value == 'b') b=1;
                else if (value == 'c' ) c=1;                

                num_a[i][j] = num_a[i][j-1] + num_a[i-1][j] - num_a[i-1][j-1] + a;
                num_b[i][j] = num_b[i][j-1] + num_b[i-1][j] - num_b[i-1][j-1] + b;
                num_c[i][j] = num_c[i][j-1] + num_c[i-1][j] - num_c[i-1][j-1] + c;

            }
        }

        for (int k=0; k<K; k++){
            stk = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(stk.nextToken());
            int c1 = Integer.parseInt(stk.nextToken());
            int r2 = Integer.parseInt(stk.nextToken());
            int c2 = Integer.parseInt(stk.nextToken());

            int value_a = num_a[r2][c2]-num_a[r1-1][c2]-num_a[r2][c1-1]+num_a[r1-1][c1-1];
            int value_b = num_b[r2][c2]-num_b[r1-1][c2]-num_b[r2][c1-1]+num_b[r1-1][c1-1];
            int value_c = num_c[r2][c2]-num_c[r1-1][c2]-num_c[r2][c1-1]+num_c[r1-1][c1-1];

            System.out.println((value_a) + " " + (value_b) + " " + (value_c));
        }

    }
}