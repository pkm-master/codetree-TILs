import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int ans = -(int)Math.pow(10,9);
        int sums = 0;

        for (int i=0; i<n; i++){
            sums += arr[i];
            ans = Math.max(ans, sums);
            if (sums<0) sums = 0;
        }

        System.out.println(ans);

    }
}