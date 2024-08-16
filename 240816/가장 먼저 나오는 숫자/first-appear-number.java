import java.io.*;
import java.util.*;

public class Main {
    public static int find_lower(int value, int[] arr){
        int st = 0;
        int end = arr.length - 1;
        int mid = 0;
        int ans = 10000000;

        while (st<=end){
            mid = (st+end)/2;

            if (arr[mid] < value){
                st = mid+1;
            } else{
                ans = Math.min(ans,mid);
                end = mid-1;
            }
        }

        return ans==10000000 || arr[ans] != value? -1 : ans+1;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // x중에서 최초로 등장하는 위치
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        
        for (int i=0; i<m; i++){
            int value = Integer.parseInt(stk.nextToken());
            System.out.println(find_lower(value,arr));

        }


    }
}