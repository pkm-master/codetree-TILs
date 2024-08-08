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
    int x, index, IsStart;
    public Point(int x, int index, int IsStart){
        this.x = x;
        this.index = index;
        this.IsStart = IsStart;
    }

    @Override
    public int compareTo(Point p){
        return this.x-p.x;
    }
}
public class Main {
    
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Segment[] segments = new Segment[N];
        ArrayList<Point> points = new ArrayList<>();

        for (int i=0; i<N; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            segments[i] = new Segment(s,e);
            points.add(new Point(s,i,1));
            points.add(new Point(e,i,-1));

        }
        Collections.sort(points);

        int sums = 0;
        int start = 0;
        int length = 0;

        for (int i=0; i<points.size(); i++){
            int point = points.get(i).x;
            int tmp_sum = sums;
            sums += points.get(i).IsStart;
            if (tmp_sum == 0 && sums == 1){
                start = point;
            }else if (tmp_sum == 1 && sums == 0){
                int tmp_length = point-start;
                if (tmp_length>length){
                    length=tmp_length;
                }

            }
        }

        System.out.println(length);
    }
}