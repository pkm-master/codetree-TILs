import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 순서대로 나열한다음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        ArrayList<Integer> low = new ArrayList<>();
        ArrayList<Integer> high = new ArrayList<>();

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());
            for (int j=0; j<m; j++){
                low.add(k);
                high.add(k);                
            }
            total += m ;
        }

        Collections.sort(low);
        Collections.reverse(high);

        int ans = 0;
        for (int i=0; i<total/2; i++){
            ans = Math.max(ans, low.get(i) + high.get(i));
        }

        System.out.println(ans);
    }
}