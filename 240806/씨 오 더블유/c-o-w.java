import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        // O를 기준으로해서 왼쪽의 C의 개수를 저장하는 Cs리스트
        // O를 기준으로해서 오른쪽의 W의 개수를 저장하는 Ws리스트

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String value = br.readLine();
        
        int o_cnt = 0;
        for (int i=0; i<N; i++){
            char alpha = value.charAt(i);
            if (alpha == 'O'){
                o_cnt +=1;
            } 
        }

        int[] Cs = new int[o_cnt];
        int[] Ws = new int[o_cnt];

        int c_cnt = 0;
        int o_idx = 0;
        for (int i=0; i<N; i++){
            char alpha = value.charAt(i);
            if (alpha == 'C'){
                c_cnt +=1;
            }else if(alpha == 'O'){
                if(o_idx>=1) Cs[o_idx] = Cs[o_idx-1] + c_cnt;
                else Cs[o_idx] = c_cnt;
                o_idx += 1;
                c_cnt = 0;
            }
        }

        int w_cnt = 0;
        o_idx = o_cnt-1;
        for (int i=N-1; i>=0; i--){
            char alpha = value.charAt(i);
            if (alpha == 'W'){
                w_cnt +=1;
            }else if(alpha == 'O'){
                if(o_idx<=o_cnt-2) Ws[o_idx] = Ws[o_idx+1] + w_cnt;
                else Ws[o_idx] = w_cnt;
                o_idx -= 1;
                w_cnt = 0;
            }
        }

        long total=0;
        for (int i=0; i<o_cnt; i++){
            total+=Cs[i]*Ws[i];
        }
        System.out.println(total);

    }
}