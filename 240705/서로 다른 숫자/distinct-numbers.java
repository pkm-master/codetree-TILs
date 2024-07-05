import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> hash = new HashSet<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < n ; i++){
            int ele = Integer.parseInt(stk.nextToken());
            hash.add(ele);

        }

        System.out.print(hash.size());

    }
}