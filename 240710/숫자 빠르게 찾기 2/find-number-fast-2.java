import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0 ; i < n ; i++){
            set.add(Long.parseLong(stk.nextToken()));
        }

        for (int i = 0 ; i < m ; i++){
            long k = Long.parseLong(br.readLine());
            if (set.ceiling(k) == null){
                System.out.println("-1");
            }else{
                System.out.println(set.ceiling(k));
            }
        }
    }
}