import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        HashMap<Integer,Integer> backIdx = new HashMap<>();
        HashMap<Integer,Integer> frontIdx = new HashMap<>();

        int[] arr = new int[n];
        TreeSet<Integer> numbers = new TreeSet<>();

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            numbers.add(arr[i]);
        }
        Arrays.sort(arr);

        for (int i=0; i<n; i++) backIdx.put(arr[i],i);
        for (int i=n-1; i>=0; i--) frontIdx.put(arr[i],i);

        PriorityQueue<Integer> setNum = new PriorityQueue<>(Collections.reverseOrder());
        int[] nums = new int[n];
        int[] dp = new int[n];

        for (int i=0; i<n; i++){
            int upperbound = numbers.floor(arr[i]+k);
            int upperidx = backIdx.get(upperbound);
            nums[i] = upperidx-i+1;
        } 

        dp[n-1] = nums[n-1];

        for (int i=n-2; i>=0; i--) dp[i] = Math.max(nums[i],nums[i+1]);

        for (int i=0; i<n; i++){
            if (numbers.higher(arr[i]+k)!=null){
                int upper = numbers.higher(arr[i]+k);
                setNum.add(nums[i]+dp[frontIdx.get(upper)]);
            }else{
                setNum.add(nums[i]);
            }
        }

        System.out.println(setNum.poll());

        
    }
}