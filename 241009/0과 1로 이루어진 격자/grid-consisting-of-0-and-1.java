import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static void press(int i, int j){
        for (int r=0; r<=i; r++){
            for (int c=0; c<=j; c++){
                arr[r][c] = arr[r][c] == 1? 0 : 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<n; j++){
                arr[i][j] = (int)(str.charAt(j)) - (int)('0');
            }
        }
        
        int ans = 0;
        for (int i=n-1; i>-1; i--){
            for (int j=n-1; j>-1; j--){
                if (arr[i][j] == 1){
                    press(i,j);
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}