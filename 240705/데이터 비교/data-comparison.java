import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        HashSet<Long> hash = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            long ele = Long.parseLong(stk.nextToken());
            hash.add(ele);
        }

        int m = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());

        for (int j = 0 ; j < m ; j++){
            long ele = Long.parseLong(stk.nextToken());
            if (hash.contains(ele)){
                System.out.print("1"+" ");
            }else{
                System.out.print("0"+" ");
            }
        }

    }
}