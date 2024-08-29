import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int st5 = n/5;
        while ((n - st5 * 5) % 2 == 1 && st5>0){
            st5--;
        }

        int n2 = (n - st5 * 5) / 2;

        if (n2 * 2 + st5 *5 == n){
            System.out.println(st5 + n2);
        } else{
            System.out.println(-1);
        }

    }
}