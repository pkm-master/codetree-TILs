import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i=0; i<n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        // System.out.println(arr);

        int ans = 0;
        int j=1;
        for (int i=0; i<n-1; i++){
            j = i+1;
            while(j<n && arr.get(i) + arr.get(j)<=k){
                if (arr.get(i) + arr.get(j)<=k){
                    ans ++;
                }
                j++;
            }

        }

        System.out.println(ans);   



    }
}