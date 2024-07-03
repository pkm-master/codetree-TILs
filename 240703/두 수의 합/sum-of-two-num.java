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

        long max_value = 0;
        HashMap hash = new HashMap();

        for (int i = 0 ; i < n ; i++){
            long m = Long.parseLong(stk.nextToken());
            if (m > max_value){
                max_value = m;
            }
            if (hash.containsKey(m)){
                hash.replace(m, (int)hash.get(m)+1);
            }else {
                hash.put(m,1);
            }
       
        }

        int answer = 0;

        for (long i = 0 ; i <= k/2 ; i++){
            answer += (int)hash.getOrDefault(i,0) * (int)hash.getOrDefault(k-i,0);

        }

        for (long i = k+1 ; i <= max_value ; i++){
            answer += (int)hash.getOrDefault(i,0) * (int)hash.getOrDefault(k-i,0);
        }

        System.out.println(answer);
    }
}