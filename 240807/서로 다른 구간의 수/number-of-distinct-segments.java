import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int limit = 100000;
        int[] lines = new int[limit+1];
        for(int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            lines[s] = 1;
            lines[e] = -1;
        }

        int sums=0;
        int cnt=0;

        for(int i=0; i<=limit; i++){
            int tmp_sum = sums;
            sums+=lines[i];
            if(tmp_sum>sums && sums==0){
                cnt++;
            }
        }

        System.out.println(cnt);
        
    }
}