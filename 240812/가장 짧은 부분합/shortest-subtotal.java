import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        long s = Long.parseLong(stk.nextToken());

        int[] arr = new int[n];
        stk = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        long sums = 0;
        int ans = 1000000;
        int j = 0;

        for (int i=0; i<n; i++){
            while (j<n && sums < s){
                sums+=arr[j];
                j++;

            }

            if (sums>=s)ans = Math.min(ans,j-i);
            sums -= arr[i];

        }
        System.out.println(ans==1000000? -1 : ans);
    }
}