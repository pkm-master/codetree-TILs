import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<String,Integer> tree = new TreeMap<>();

        for (int i = 0 ; i < n ; i++){
            String key = br.readLine();
            if (tree.containsKey(key)){
                tree.replace(key,tree.get(key)+1);
            } else{
                tree.put(key,1);
            }

        }


        Iterator<Map.Entry<String,Integer>> iterator = tree.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            double result = (double)entry.getValue()/n * 100;

            System.out.printf(entry.getKey() + " %.4f \n", result);
        }
    }
}