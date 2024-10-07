import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String A = br.readLine();
        String B = br.readLine();
        int[] wrap = new int[n];

        for (int i=0; i<n; i++){
            if (A.charAt(i) != B.charAt(i)) wrap[i] = 1;

        }

        int cnt = 0;
        if (wrap[0] == 1){
            cnt++;
        }
        for (int i=0; i<n-1; i++){
            if (wrap[i] != wrap[i+1] && wrap[i] == 0){
                cnt++;
            }
        }

        System.out.println(cnt);

        
    }
}