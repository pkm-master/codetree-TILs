import java.io.*;
import java.util.*;

class Node{
    int book_id, shelf_id, book_numbers;
    Node prev,next;

    public Node(int book_id, int shelf_id){
        this.book_id = book_id;
        this.shelf_id = shelf_id;
        this.book_numbers = 0;
        this.prev = null;
        this.next = null;
    }

}

public class Main {

    public static void connect(Node i, Node j){
        if (i!=null) i.next = j;
        if (j!=null) j.prev = i;
    }

    public static void disconnect(Node i, Node j){
        if (i!=null) i.next = null;
        if (j!=null) j.prev = null;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // 1번부터 K번까지 K개의 책꽂이
        // 1번부터 N번까지 N개의 책
        // N개의 책은 모두 1번 책꽂이에 꽂혀있음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int Q = Integer.parseInt(br.readLine());

        Node[] shelves = new Node[K+1];
        Node[] tails = new Node[K+1];

        for (int i=1 ; i<=K ; i++){
            Node shelf = new Node(0,i);
            shelves[i] = shelf;
            tails[i] = shelf;
            
        }

        for (int i=1 ; i<=N ; i++){
            Node book = new Node(i,0);
            connect(tails[1],book);
            tails[1] = book;
            shelves[1].book_numbers += 1;

        }

        for(int i=0 ; i<Q ; i++){
            stk = new StringTokenizer(br.readLine());
            int method = Integer.parseInt(stk.nextToken());
            int indexI = Integer.parseInt(stk.nextToken());
            int indexJ = Integer.parseInt(stk.nextToken());

            if (shelves[indexI].next == null){
                continue;
            }


            if (method == 1){
                Node tmp_first = shelves[indexI].next;
                Node tmp_second = tmp_first.next;
                disconnect(shelves[indexI], tmp_first);
                disconnect(tmp_first, tmp_second);

                if (tmp_second == null ) tails[indexI] = shelves[indexI];

                connect(shelves[indexI], tmp_second);
                connect(tails[indexJ],tmp_first);
                tails[indexJ] = tmp_first;
                shelves[indexI].book_numbers -= 1;
                shelves[indexJ].book_numbers += 1;

            }else if (method == 2){
                Node tmp_last = tails[indexI];
                tails[indexI] = tmp_last.prev;
                if(shelves[indexJ] == tails[indexJ]) tails[indexJ] = tmp_last;
                disconnect(tmp_last.prev, tmp_last);
                Node tmp_first = shelves[indexJ].next;
                connect(shelves[indexJ],tmp_last);
                connect(tmp_last,tmp_first);
                shelves[indexI].book_numbers -= 1;
                shelves[indexJ].book_numbers += 1;
              
            }else if (method == 3){
                Node books = shelves[indexI].next;
                disconnect(shelves[indexI], books);

                Node tmp_first = shelves[indexJ].next;
                connect(shelves[indexJ], books);
                connect(tails[indexI], tmp_first);
                
                int book_num = shelves[indexI].book_numbers;
                shelves[indexI].book_numbers -= book_num;
                shelves[indexJ].book_numbers += book_num;

                if(indexI != indexJ){
                    tails[indexI] = shelves[indexI];
                }

            }else{
                Node books = shelves[indexI].next;
                disconnect(shelves[indexI], books);
                Node tmp_end = tails[indexI];
                tails[indexI] = shelves[indexI];
                connect(tails[indexJ], books);
                tails[indexJ] = tmp_end;

                int book_num = shelves[indexI].book_numbers;
                shelves[indexJ].book_numbers += book_num;
                shelves[indexI].book_numbers -= book_num;
            }
        }
        for (int i=1 ; i<=K ; i++){
            System.out.print(shelves[i].book_numbers);
            System.out.print(" ");
            Node curr = shelves[i].next;
            while (curr != null){
                System.out.print(curr.book_id + " ");
                curr = curr.next;
            }
            System.out.println();

        }
        
    }
}