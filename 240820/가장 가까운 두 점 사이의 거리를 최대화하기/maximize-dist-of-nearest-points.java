import java.io.*;
import java.util.*;

// Line class - start / end / compare (start기준)
// 정렬된 Line[] -> 하나씩 뽑아서 점을 하나씩 둠
// dist 가 value 이상이 되도록 둘 수 있으면 true 아니면 false return 함수


class Line implements Comparable<Line>{
    int st,end;
    public Line(int st, int end){
        this.st = st;
        this.end = end;
    }

    @Override
    public int compareTo(Line l){
        return this.st - l.st;
    }
}

public class Main {
    public static int n,m;
    public static Line[] arr;

    public static boolean is_possible(int value){
        int start = arr[0].st;
        int dist = start+value;

        for (int i=1; i<n; i++){
            Line curr = arr[i];
            if (dist <= curr.st){
                dist = curr.st + value;
            } else if (dist>curr.st && dist<=curr.end){
                dist = dist + value;
            } else{
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        arr = new Line[n];

        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            arr[i] = new Line(st,end);

        }
        
        Arrays.sort(arr);

        int st = 1;
        int end = (int)Math.pow(10,9);
        int ans = 0;

        while (st<=end){
            int mid = (st+end)/2;
            if (is_possible(mid)){
                st = mid+1;
                ans = Math.max(ans,mid);
            } else{
                end = mid-1;
            }
        }

        System.out.println(ans);    
    }
}