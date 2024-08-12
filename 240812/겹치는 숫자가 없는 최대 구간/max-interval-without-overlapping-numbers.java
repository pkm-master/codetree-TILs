import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // counting array를 추가로 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[n+1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] ls = new int[n];

        int ans = 0;
        int j = 0;

        for (int i=0; i<n; i++){
            ls[i] = Integer.parseInt(stk.nextToken());
        }

        for( int i=0; i<n; i++){
            while (j<n && count[ls[j]]!=1){
                count[ls[j]] += 1;
                j++;

            }
            ans = Math.max(ans, j-i);
            count[ls[i]] -= 1;

        }

        System.out.println(ans);

    }
}