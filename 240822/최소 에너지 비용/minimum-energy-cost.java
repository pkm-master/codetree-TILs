import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] energy = new int [n-1];
        int[] spot = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n-1; i++) energy[i] = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) spot[i] = Integer.parseInt(stk.nextToken());

        int[] dp = new int[n];
        dp[0] = spot[0];

        for (int i=1; i<n; i++) dp[i] = Math.min(dp[i-1],spot[i]);

        int ans = 0;

        for (int i=0; i<n-1; i++) ans += dp[i] * energy[i];

        System.out.println(ans); 

    }
}