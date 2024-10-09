import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String A = br.readLine();
        String B = br.readLine();

        boolean[] arr = new boolean[n];

        for (int i=0; i<n; i++){
            arr[i] = A.charAt(i) == B.charAt(i) ? false : true;
        }

        int cnt = 0;
        int part = 0;

        for (int i=0; i<n; i++){
            if (arr[i]){
                part++;
                if (part == 4){
                    cnt++;
                    part = 0;
                }
            } else{
                if (part != 0){
                    cnt++;
                    part = 0;
                }
            }

            if (i==n-1){
                if (part != 0){
                    cnt++;
                    part = 0;
                }
            }
        }

        System.out.println(cnt);

    }
}