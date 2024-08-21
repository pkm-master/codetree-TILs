import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[] L = new long[n];
        long total = 0;

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
            long currentSum = L[i]+arr[i];

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

        // System.out.println(first);
        // System.out.println(second);
        // System.out.println(third);

        long ans = 0;
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