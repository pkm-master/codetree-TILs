import java.io.*;
import java.util.*;


// class LinePoint{
//     int x,index,isSt;
    
//     public LinePoint(int x, int index, int isSt){
//         this.x = x;
//         this.index = index;
//         this.isSt = isSt
//     }
// }
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // n개의 점과 m개의 선분, 각 선분위에 몇개의 점이 있는지
    

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int[] points = new int[n];
        HashSet<Integer> pointsContain = new HashSet<>();

        for(int i=0; i<n; i++){
            int point = Integer.parseInt(stk.nextToken());
            points[i] = point;
            pointsContain.add(point);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        HashMap<Integer,Integer> Line = new HashMap<>();
        int[] lines = new int[m];


        for (int j=0; j<m; j++){
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            q.add(st);
            q.add(end);
            Line.put(st,end);
            lines[j] = st;
        }

        HashMap<Integer,Integer> point_n = new HashMap<>();

        int i=0;
        while (!q.isEmpty()){
            int value = q.poll();
            while ( i<n && points[i]<value){
                i++;
            }
            point_n.put(value,i);
        }

        for (int j=0; j<m; j++){
            int st = lines[j];
            int end = Line.get(st);
            int ans = point_n.get(end)-point_n.get(st);
            if (pointsContain.contains(end)) ans +=1;
            System.out.println(ans);

        }

        // System.out.println(point_n);

    }
}