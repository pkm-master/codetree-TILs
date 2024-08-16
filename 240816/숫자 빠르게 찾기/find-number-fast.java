import java.io.*;
import java.util.*;

public class Main {
    public static int find(int value, int[] arr){
        int i=0;
        int j=arr.length-1;

        while (i<=j){
            int mid = (i+j)/2;
            if (arr[mid]>value){
                j = mid-1;
            } else if (arr[mid]<value) {
                i = mid+1;
            } else if(arr[mid] == value) {
                return mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for (int i=0; i<m; i++){
            int value = Integer.parseInt(br.readLine());
            System.out.println(find(value,arr));
        }


    }
}