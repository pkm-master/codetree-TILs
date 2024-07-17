import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        TreeSet<Integer> set = new TreeSet<>();

        stk = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++){
            set.add(Integer.parseInt(stk.nextToken()));
        }

        stk = new StringTokenizer(br.readLine());
        for (int i=0 ; i<m ; i++){
            int new_int = Integer.parseInt(stk.nextToken());
            if (set.floor(new_int) != null) {
                System.out.println(set.floor(new_int));
                set.remove(set.floor(new_int));
            } else{
                System.out.println(-1);
            }
        }

    }

}