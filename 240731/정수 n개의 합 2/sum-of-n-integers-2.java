import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        int[] sums = new int [n];
        
        sums[0] = Integer.parseInt(stk.nextToken());

        for (int i=1 ; i<n ; i++){
            int new_value = Integer.parseInt(stk.nextToken());
            sums[i] = sums[i-1] + new_value;

        }

        int max_value = 0 ;
        for (int i=k; i<n ; i++){
            int diff = sums[i] - sums[i-k];
            if (max_value < diff) max_value = diff;
        }

        System.out.println(max_value);

    }
}