import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int g = Integer.parseInt(stk.nextToken());

        // 각 사람이 어디에 속하는지
        ArrayList<Integer>[] whatGroups = new ArrayList[n+1];

        // 그룹내에서 초대받지 못한 사람은 누구누구인지
        HashSet<Integer>[] uninvited = new HashSet[g];

        // 초대받은 사람을 관리
        HashSet<Integer> invited = new HashSet<>();

        // 각멤버가 초대받았는지 여부 관리
        boolean[] isInvited = new boolean[n+1];

        for (int i=0; i<n+1; i++){
            whatGroups[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<g; i++){
            uninvited[i] = new HashSet<Integer>();
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<g; i++){
            stk = new StringTokenizer(br.readLine());
            int mem_n = Integer.parseInt(stk.nextToken());

            for (int j=0; j<mem_n; j++){
                int member = Integer.parseInt(stk.nextToken());
                if (j==0) {
                    q.add(member);
                    isInvited[member] = true;
                } 
                uninvited[i].add(member);
                whatGroups[member].add(i);
            }
        }

        while (!q.isEmpty()){
            int curr = q.poll();
            invited.add(curr);

            for (int i=0; i<whatGroups[curr].size(); i++){
                int group = whatGroups[curr].get(i);
                uninvited[group].remove(curr);

                if (uninvited[group].size() == 1){
                    int pNum = new ArrayList<>(uninvited[group]).get(0);
                    if (!isInvited[pNum]){
                        isInvited[pNum] = true;
                        q.add(pNum);
                    }
                }
            }
        }
        System.out.println(invited.size());
        
        
    }
}