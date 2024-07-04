import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 2차 평면 위에 n 개의 점
        // 동일한 x -> 
        // 남아있는 y값들의 합

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk;

        Map<Long,Long> hash = new HashMap<>();

        for (int i = 0 ; i < n ; i++){
            stk = new StringTokenizer(br.readLine());
            long x = Long.parseLong(stk.nextToken());
            long y = Long.parseLong(stk.nextToken());
            
            if (hash.containsKey(x)){
                if (y < hash.get(x)){
                    hash.replace(x,y);
                }
            } else {
                hash.put(x,y);
            }
        }

        long ans = 0;

        for (long y : hash.values()){
            ans += y;
        }


        System.out.println(ans);
    }
}