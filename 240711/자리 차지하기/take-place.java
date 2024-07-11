import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();

        for (int i=1 ; i<= m ; i++){
            set.add(i);
        }

        int ans = 0;

        for (int i=0 ; i<n ; i++){
            int wanted = Integer.parseInt(stk.nextToken());
            if (set.floor(wanted) != null){
                set.remove(set.floor(wanted));
                ans += 1;
            } else{
                break;
            }
        }

        System.out.println(ans);
    }
}