import java.io.*;
import java.util.*;

public class Main {

    public static int[][] prefix;
    public static int n;

    public static int getSum(int x1, int y1, int x2, int y2){
        return prefix[x2][y2] - prefix[x1][y2] - prefix[x2][y1] + prefix[x1][y1];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        prefix = new int[1001][1001];
        int[][] original = new int[1001][1001];

        for (int i=0; i<n; i++ ){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            original[r][c] = 1;

        }

        for (int i=1; i<=1000; i++){
            for (int j=1; j<=1000; j++){
                prefix[i][j] = original[i][j]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];

            }
        }

        int ans = (int)Math.pow(10,3);

        for (int i=1;i<=1000;i++){
            for (int j=1; j<=1000; j++){
                if (i%2==0 && j%2==0){
                    int first = prefix[i][j];
                    int second = getSum(0,j,i,1000);
                    int third = getSum(i,0,1000,j);
                    int fourth = getSum(i,j,1000,1000);

                    ans = Math.min(ans,Math.max(first,Math.max(second,Math.max(third,fourth))));

                }

            }
        }

        System.out.println(ans);

    }
}