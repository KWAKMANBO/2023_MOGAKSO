import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

import java.io.IOException;

// 실패한 버전
public class Problem010_MYversion {
   static int Arr[];
   static int SubArr[];

    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken()); 

        Arr = new int[N];
        SubArr = new int[N];

        st = new StringTokenizer(bf.readLine());

        // 수열 전체를 입력 
        for(int i = 0; i < N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        int  min = Arr[0];

        for(int i = 0; i < A; i++){
            SubArr[i] = Arr[i] ;
            if(SubArr[i] < min){
                min = SubArr[i];
            }
            System.out.println((min));
        
        }

       for(int i = A  ; i < N; i++){
             int sub[] = new int[A];
            for(int  j = i - A + 1; j < i; j++ ){
               
                
                for(int k = 0; k< A; k++){
                 
                sub[k] = Arr[j + k ]; 
                if(k == N)break;    
                }
                Arrays.sort(sub);
               
            }
            System.out.println(sub[0]);
        }
   }
}
