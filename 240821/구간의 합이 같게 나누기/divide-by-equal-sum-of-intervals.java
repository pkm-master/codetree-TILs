import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // n개의 정수로 이루어진 수열을 4개 구간
        // 각 구간은 최소한 한개의 원소를 포함
        // 각 구간에서 원소의 합은 같아야함
        // n *n
        // 4개의 합이 같다 

        // L 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] L = new int[n];
        int total = 0;

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            int value = Integer.parseInt(stk.nextToken());
            arr[i] = value;
            total += value;
        }

        L[0] = 0;
        for (int i=1; i<n; i++){
            L[i] = L[i-1]+arr[i-1];
        }

        TreeSet<Integer> first = new TreeSet<>();
        TreeSet<Integer> second = new TreeSet<>();
        TreeSet<Integer> third = new TreeSet<>();

        for (int i=1; i<n; i++){
            int currentSum = L[i]+arr[i];

            if (currentSum==total/4){
                first.add(i);
            }
            if (currentSum==total/2){
                second.add(i);
            }
            if (currentSum==total*3/4){
                third.add(i);
            }
        }

        ArrayList<Integer> firstArr = new ArrayList<>(first);
        ArrayList<Integer> secondArr = new ArrayList<>(second);
        ArrayList<Integer> thirdArr = new ArrayList<>(third);
        int lastSize = thirdArr.size();

        int ans = 0;
        for (int i=0; i<firstArr.size(); i++){
            int nextJ = secondArr.indexOf(second.higher(firstArr.get(i)));
            if (nextJ == -1) continue;

            for (int j=nextJ; j<secondArr.size();j++){
                int nextK = thirdArr.indexOf(third.higher(secondArr.get(j)));
                if (nextK != -1) ans += (lastSize - nextK);
                
            }
        }

        System.out.println(ans);


    }
}