import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String,Integer> tree = new TreeMap<>();

        for ( int i = 1 ; i <= n ; i++){
            String key = br.readLine();
            if (tree.containsKey(key)){
                tree.replace(key, tree.get(key)+1);
            }else{
                tree.put(key,1);
            }
        }

        Iterator<Map.Entry<String,Integer>> iterator = tree.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());

        }


    }
}