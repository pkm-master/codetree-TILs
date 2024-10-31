import java.io.*;
import java.util.*;

public class Main {
    public static boolean isValid(int now){
        return now>0 && now <=1000000? true : false;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()){
            int now = q.poll();
            if (isValid(now-1) && dp[now-1] == 0){
                dp[now-1] = dp[now]+1;
                q.add(now-1);
            }
            if (isValid(now+1) && dp[now+1] == 0){
                dp[now+1] = dp[now]+1;
                q.add(now+1);
            }
            if (isValid(now*2) && dp[now*2] == 0){
                dp[now*2] = dp[now]+1;
                q.add(now*2);
            }
            if (isValid(now*3) && dp[now*3] == 0){
                dp[now*3] = dp[now]+1;
                q.add(now*3);
            }
            
        }

        System.out.println(dp[n]);


    }


}