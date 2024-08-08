import java.io.*;
import java.util.*;

class Segment{
    int s,e;
    public Segment(int s, int e){
        this.s = s;
        this.e = e;
    }
}

class Point implements Comparable<Point>{
    int x, index, is_start;
    public Point(int x, int index, int is_start){
        this.x = x;
        this.index = index;
        this.is_start = is_start;

    }

    @Override
    public int compareTo(Point p){
        return this.x - p.x;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // n명의 사람이 컴퓨터
        // 컴퓨터에는 1~n까지 번호
        // 이용시 남아있는 자리 중 번호가 가장 작은 자리에 앉는 것이 규칙
        // n명의 사람에 대해 각자가 사용한 컴퓨터 번호
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Segment[] segments = new Segment[n];
        ArrayList<Point> points = new ArrayList<>();

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            points.add(new Point(s,i,1));
            points.add(new Point(e,i,-1));
        }

        Collections.sort(points);
        int[] pc_num = new int[n];
        
        PriorityQueue<Integer> left_computer = new PriorityQueue<>();
        for (int i=1; i<=n; i++){
            left_computer.add(i);
        }

        for (int i=0; i<points.size(); i++){
            
            int point = points.get(i).x;
            if (points.get(i).is_start == 1){
                pc_num[points.get(i).index] = left_computer.poll();
            }else{
                left_computer.add(pc_num[points.get(i).index]);
            }
        }

        for (int i=0; i<n; i++){
            System.out.print(pc_num[i]+" ");
        }
    }
}