import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        

        stk = new StringTokenizer(br.readLine());
        HashMap hash = new HashMap();

        for (int i = 0 ; i < N ; i++){
            int key = Integer.parseInt(stk.nextToken());
            if (hash.containsKey(key)){
                int newV = (int)hash.get(key) + 1;
                hash.replace(key,newV);
            }else {
                hash.put(key,1);

            }
        }

        stk = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < M ; i++){
            int key = Integer.parseInt(stk.nextToken());
            System.out.print(hash.getOrDefault(key,0));
            System.out.print(" ");

        }
    }
}