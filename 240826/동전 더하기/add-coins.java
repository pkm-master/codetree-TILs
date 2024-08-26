import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] coins = new int[n];
        for (int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int j = n-1;
        int ans = 0;
        while (k>0 && j>0){
            ans += k/coins[j];
            k = k%coins[j];
            j--;
        }

        System.out.println(ans);

    }
}