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
        int[] sums = new int[n+1];

        for (int i=1 ; i<=n ; i++){
            int value = Integer.parseInt(stk.nextToken());
            sums[i] = sums[i-1] + value;

        }

        int cnt = 0;
        for (int e=1 ; e<=n ; e++){
            for (int s=0 ; s<n ; s++){
                int partial = sums[e]-sums[s];
                if (partial == k){
                    cnt ++;
                }
            }
        }

        System.out.println(cnt);
    }
}