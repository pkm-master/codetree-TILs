import java.io.*;
import java.util.*;


class Line{
    long s,e;
    
    public Line(long s, long e){
        this.s = s;
        this.e = e;

    }
}
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        ArrayList<Long> points = new ArrayList<>();
        HashSet<Long> pointsContain = new HashSet<>();

        for(int i=0; i<n; i++){
            long point = Long.parseLong(stk.nextToken());
            points.add(point);
            pointsContain.add(point);
        }

        Collections.sort(points);

        PriorityQueue<Long> q = new PriorityQueue<>();
        Line[] lines = new Line[m];

        for (int j=0; j<m; j++){
            stk = new StringTokenizer(br.readLine());
            long st = Long.parseLong(stk.nextToken());
            long end = Long.parseLong(stk.nextToken());
            q.add(st);
            q.add(end);
            lines[j] = new Line(st,end);
        }

        HashMap<Long,Integer> point_n = new HashMap<>();

        int i=0;
        while (!q.isEmpty()){
            long value = q.poll();
            while ( i<n && points.get(i)<value){
                i++;
            }
            point_n.put(value,i);
        }

        for (int j=0; j<m; j++){
            long st = lines[j].s;
            long end = lines[j].e;
            long ans = point_n.get(end)-point_n.get(st);
            if (pointsContain.contains(end)) ans +=1;
            System.out.println(ans);

        }

        // System.out.println(point_n);

    }
}