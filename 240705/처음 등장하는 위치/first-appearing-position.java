import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        TreeMap<Long,Integer> tree = new TreeMap<>();

        for ( int i = 1 ; i <= n ; i++){
            long key = Long.parseLong(stk.nextToken());
            if (tree.containsKey(key)){
                
            }else{
                tree.put(key,i);
            }
        }

        Iterator<Map.Entry<Long,Integer>> iterator = tree.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Long,Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());

        }


    }
}