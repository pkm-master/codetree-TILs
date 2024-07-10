import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        TreeSet<Integer> set = new TreeSet<>();

        for (int i=1 ; i<=m ; i++){
            set.add(i);
        }

        stk = new StringTokenizer(br.readLine());
        for (int i=0 ; i<n ; i++){
            set.remove(Integer.parseInt(stk.nextToken()));
            System.out.println(set.last());
        
        }
    }
}