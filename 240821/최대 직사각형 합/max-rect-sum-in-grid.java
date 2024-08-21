// -1000이상 1000이하의 숫자로 이루어진 n*n크기의 2차원 격자
// 격자를 벗어나지 않는 적절한 직사각형중 사각형 내 숫자들의 합이 최대가 되도록
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] prefix = new int[n+1][n+1];


        for (int i=1; i<=n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++){
                prefix[i][j] = prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+Integer.parseInt(stk.nextToken());

            }
        }

        int ans = 0;

        for (int i1=1; i1<=n; i1++){
            for (int j1=1; j1<=n; j1++){
                for (int i2=0; i2<i1; i2++){
                    for (int j2=0; j2<j1; j2++){
                        ans = Math.max(ans, prefix[i1][j1] - prefix[i2][j1] - prefix[i1][j2] + prefix[i2][j2]);
                    }
                }
            }
        }

        System.out.println(ans);

    }

}