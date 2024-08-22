import java.io.*;
import java.util.*;

class Segment implements Comparable<Segment>{
    int st, end, length;
    public Segment(int st, int end){
        this.st = st;
        this.end = end;
        this.length = 0;
    }

    @Override 
    public int compareTo(Segment s){
        return this.length - s.length;
    }
}

class Point implements Comparable<Point>{
    int x, idx;
    boolean isSt;
    public Point(int x, int idx, boolean isSt){
        this.x = x;
        this.idx = idx;
        this.isSt = isSt;
    }

    @Override
    public int compareTo(Point p){
        return this.x - p.x;

    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 수평선 위에 N개의 선분
        // 각 선분의 양 끝점은 선분마다 상이
        // 선분이 그어진 영역의 길이가 최대가 되도록 선분 하나를 제거
        // 선분 제거 후 선분이 그어진 영역의 총 길이를 구하는 프로그램

        // 하나만 제거하다보니 겹치는 영역은 신경쓰지 않아도됨
        // 자기만 있는 영역이 제일 적은 선분을 제거

        // st면 넣고 end면 빼기를 하다가
        // 작업을 하고 보니까 Set에 선분 하나만 남은 상황부터 
        // 다음 시점까지
        // 해당 선분의 맡은 어쩌구를 추가 
        // 전체 길이 : Set에 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Segment[] lines = new Segment[n];
        PriorityQueue<Point> points = new PriorityQueue<>();

        for (int i=0; i<n; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            lines[i] = new Segment(st,end);
            points.add(new Point(st,i,true));
            points.add(new Point(end,i,false));

        }

        int lineSt=0;
        int lineEnd=0;
        int one = 0;

        int partSt=0;
        int partEnd=0;
        int totalL = 0;

        TreeSet<Integer> currLines = new TreeSet<>();
        int beforeN = 0;

        while (!points.isEmpty()){
            Point curr = points.poll();

            if (curr.isSt){
                currLines.add(curr.idx);
            } else{
                currLines.remove(curr.idx);
            }

            int currN = currLines.size();
            if (currN == 1 && beforeN < currN){
                lineSt = curr.x;
            } else if (currN == 0 ){
                lineEnd = curr.x;
                totalL += (lineEnd-lineSt);
            }

            if (currN == 1){
                partSt = curr.x;
                one = currLines.first();
            } else if (beforeN == 1 && currN != 1){
                partEnd = curr.x;
                lines[one].length += (partEnd-partSt);
            }

            beforeN = currN;
        }

        Arrays.sort(lines);

        System.out.println(totalL-lines[0].length);


    }
}