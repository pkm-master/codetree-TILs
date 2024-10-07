import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String A = br.readLine();
        String B = br.readLine();

        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            if (A.charAt(i) == B.charAt(i)){
                arr[i] = 1;
            }
        }

        // 뒤에서부터
        int press = 0;
        for (int i=n-1; i>=0; i--){
            if (arr[i] == 0){
                press++;
                for (int j=0; j<=i; j++){
                    arr[j] = arr[j]==1? 0 : 1;
                }
            } 
        }

        System.out.println(press);

    }
}