import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(stk.nextToken());

        int[] L = new int[n];
        int[] R = new int[n];

        L[0] = (int)Math.pow(2,31)-1;

        for (int i=1; i<n; i++) L[i] = Math.min(L[i-1],arr[i-1]);


        R[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--) R[i] = Math.max(R[i+1],arr[i]);

        int ans = 0;
        for (int i=1; i<n; i++){
            ans = Math.max(ans, R[i]-L[i]);
        }

        System.out.println(ans);



    }
}