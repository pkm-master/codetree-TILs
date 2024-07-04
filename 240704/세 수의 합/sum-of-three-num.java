import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        long K = Long.parseLong(stk.nextToken());

        long[] arr = new long[n];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++){
            arr[i] = Long.parseLong(stk.nextToken());
        }

        int ans = 0;

        for (int i  = 0 ; i < n ; i++){
            for ( int j = i+1 ; j < n ; j++){
                for (int k = j+1; k < n ; k++){
                    if (arr[i]+arr[j]+arr[k] == K ){
                        ans +=1;
                    }
                }
            }
        }

        System.out.println(ans);

    }
}