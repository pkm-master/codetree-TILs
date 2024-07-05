import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap tree = new TreeMap<>();
        StringTokenizer stk;

        for (int i = 0 ; i < n ; i++){
            stk = new StringTokenizer(br.readLine());
            String method = stk.nextToken();

            if (method.equals("print_list")){

                if (tree.size() == 0 ){
                    System.out.println("None");
                }
                Iterator<Map.Entry<Long, Long>> it = tree.entrySet().iterator();
                while(it.hasNext()) {
                    Map.Entry<Long, Long> entry = it.next();
                    if (it.hasNext()){
                        System.out.print(entry.getValue()+" ");
                    }else {
                        System.out.println(entry.getValue());
                    }

                }

            } else {
                long key = Long.parseLong(stk.nextToken());
                if (method.equals("add")){
                    long value = Long.parseLong(stk.nextToken());
                    tree.put(key,value);
                } else if (method.equals("remove")){
                    tree.remove(key);
                } else if (method.equals("find")){
                    System.out.println(tree.getOrDefault(key,"None"));
                }
            }

        }
        
    }
}