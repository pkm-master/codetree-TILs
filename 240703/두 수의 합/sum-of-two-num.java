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

        Map<Long,Integer> hash = new HashMap<>();

        for (int i = 0 ; i < n ; i++){
            long m = Long.parseLong(stk.nextToken());
            if (hash.containsKey(m)){
                hash.replace(m, (int)hash.get(m)+1);
            }else {
                hash.put(m,1);
            }
       
        }

        int answer = 0;

        for (long key : hash.keySet()){
            answer += (int)hash.getOrDefault(key,0) * (int)hash.getOrDefault(k-key,0);
        }

        if (k % 2 == 0 ){
            int half = (int)hash.getOrDefault((long)k/2,0);
            answer -= half;

        }

        System.out.println(answer/2);
    }
}