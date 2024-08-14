import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];
        HashMap<Integer,Integer> count = new HashMap<>();
        
        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int i=0;
        int j=0;
        int ans = 0;
        int tmp = 0;

        while (i<n && j<n){
            if (count.containsKey(arr[j])){
                count.put(arr[j],count.get(arr[j])+1);
                while (count.get(arr[j])>k){
                    i ++;
                    tmp --;
                    count.put(arr[i],count.get(arr[i])-1);
                }
            } else{
                count.put(arr[j],1);
            }

            tmp++;
            j++;

            ans = Math.max(ans,tmp);
        }

        System.out.println(ans);
    }
}