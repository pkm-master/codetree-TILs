import java.io.*;
import java.util.*;

public class Main {
    public static int find_lower(int value, int[] arr){
        
        int st = 0;
        int end = arr.length-1;
        int ans = -1;
        int mid = (st+end)/2;

        while (st<=end){
            mid = (st+end)/2;
            if (arr[mid]<value){
                st = mid+1;
                ans = Math.max(ans,mid);
            } else if (arr[mid]>=value){
                end = mid-1;
            }    
        }
        return ans;
    }

    public static int find_upper(int value, int[] arr){
        
        int st = 0;
        int end = arr.length-1;
        int ans = 1000000;
        int mid = (st+end)/2;

        while (st<=end){
            mid = (st+end)/2;
            if (arr[mid]>value){
                ans = Math.min(ans,mid);
                end = mid-1;
            } else if (arr[mid]<=value){
                st = mid+1;
            }  
        }
        if ( ans == 1000000 || (mid == arr.length-1 && arr[mid] == value)) return arr.length;
        return ans;
    }


    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n개의 숫자가 오름차순
        // m개의 숫자가 추가적
        // 각각의 숫자가 처음 주어진 n개의 숫자중 몇번 나왔는지

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        
        }
         
        // System.out.println(Arrays.toString(arr));

        for (int i=0; i<m; i++){
            int value = Integer.parseInt(br.readLine());
            System.out.println(find_upper(value, arr)- find_lower(value,arr)-1);
            // System.out.println();


        }



    }
}