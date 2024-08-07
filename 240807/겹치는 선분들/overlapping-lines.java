import java.io.*;
import java.util.*;

class Segment{
    int s,e;
    public Segment(int s, int e){
        this.s = s;
        this.e = e;

    }
}

class Point implements Comparable<Point> {
    int x, index, isStart;
    public Point(int x, int index, int isStart){
        this.x=x;
        this.index=index;
        this.isStart=isStart;
    }

    @Override
    public int compareTo(Point p){
        return this.x - p.x;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int start = 0;

        Segment[] lines = new Segment[N];
        ArrayList<Point> points = new ArrayList<>();

        for (int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(stk.nextToken());
            String Method = stk.nextToken();
            int end;

            if (Method.equals("L")){
                end = start-value;
                lines[i] = new Segment(end, start);
                points.add(new Point(end, i, 1));
                points.add(new Point(start, i, -1));

            }else{
                end = start+value;
                lines[i] = new Segment(start, end);
                points.add(new Point(start, i, 1));
                points.add(new Point(end, i, -1));
            }

            start = end;
        }

        Collections.sort(points);

        int length = 0;

        HashSet<Integer> hash = new HashSet<>();

        int st=0;

        for (int i=0; i<points.size(); i++){

            if (points.get(i).isStart == 1){
                hash.add(points.get(i).index);
                if (hash.size()==K){
                    st=points.get(i).x;
                }
            } else{
                hash.remove(points.get(i).index);
                if (hash.size()+1==K){
                    length+=(points.get(i).x - st);
                }
            }
        }
        System.out.println(length);

    }
}