import java.io.*;
import java.util.*;

public class Main {
    public static int[] people;
    public static TreeSet<Integer> peopleTime = new TreeSet<>();
    // 해당 버스가 출발하기 까지 가장 오래 기다린 사람이 몇시간 기다렸는지
    public static int[] bus;

    public static int n,m,k;

    public static boolean isPossible(int value){
        bus = new int[m];
        int st_idx = 0;

        int i = 0;
        while (st_idx<n){
            int st = people[st_idx];
            int timeupperbound = peopleTime.floor(st+value);
            int idx = st_idx;
            while (idx<n && idx < st_idx + k && people[idx] <= timeupperbound){
                idx ++;
            }
            if (i>=m) return false;
            bus[i] = people[idx-1]-st;
            st_idx = idx;
            i++;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        people = new int[n];
        

        stk = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            people[i] = Integer.parseInt(stk.nextToken());
            peopleTime.add(people[i]);
        }

        Arrays.sort(people);

        int st = 0;
        int end = (int)Math.pow(10,9);
        int ans = end;

        while (st<=end){
            int mid = (st+end)/2;
            if (isPossible(mid)){
                ans = Math.min(ans,mid);
                end = mid-1;
            } else{
                st = mid+1;
            }
        }

        System.out.println(ans);

    }
}