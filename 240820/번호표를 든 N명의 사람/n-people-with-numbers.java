import java.io.*;
import java.util.*;

public class Main {
    public static int n,t;
    public static int[] arr;
    
    public static int find_index(int value, int[] arr){
        for (int i=0; i<arr.length; i++){
            if (arr[i] == value){
                return i;
            }
        }

        return -1;
    }

    public static boolean is_possible(int value){

        int[] stage = new int[value];
        
        for (int i=0; i<value; i++){
            stage[i] = arr[i];
        }

        for (int i=value; i<n; i++){
            // 스테이지의 최솟값에 arr[i]값을 더해줌
            int min = Arrays.stream(stage).min().getAsInt();
            int index = find_index(min, stage);
            stage[index] += arr[i];
        }

        int time = Arrays.stream(stage).max().getAsInt(); 
        if (time <= t ){
            return true;
        }        
        return false;

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());
        arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int st = 0;
        int end = n;
        int ans = n;

        while (st<=end){
            int mid = (st+end)/2;
            if (is_possible(mid)){
                end = mid-1;
                ans = Math.min(ans,mid);
            } else{
                st = mid+1;
            }
        }

        System.out.println(ans);

    }
}