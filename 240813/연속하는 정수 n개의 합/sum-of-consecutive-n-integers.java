import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];

        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int i = 0;
        int ans = 0;
        int sums = 0;
        for (int j=0; j<n; j++){
            sums += arr[j];
            while (sums > m){
                sums -= arr[i];
                i+=1;

            }
            // System.out.println(sums);
            
            if (sums == m){
                ans+=1;
            } 

        }

        System.out.println(ans);
    }
}