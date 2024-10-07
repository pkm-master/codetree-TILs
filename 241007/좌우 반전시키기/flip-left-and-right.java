import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int press = 0;

        int[] arr = new int[n];

        for (int i=0;i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i=0; i<n; i++){
            if (i!=n-1 && arr[i] == 0){
                press++;
                arr[i] = 1;
                arr[i+1] = arr[i+1]==1? 0 : 1;
                arr[i+2] = arr[i+2]==1? 0 : 1;
            }else if (i == n-1 && arr[i] == 0){
                press = -1;
            }

        }

        System.out.println(press);
    }
}