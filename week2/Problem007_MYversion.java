import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem007_MYversion {
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        int ingredient[] = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i < N; i++){
            
            ingredient[i] =  Integer.parseInt(st.nextToken());
        }

        int start_index = 0;
        int end_inedx =1;
        int cnt =0;

        while(start_index!=N-1){
            while(end_inedx != N-1){
            if(ingredient[start_index] + ingredient[end_inedx] == M){
                cnt++;
                start_index += 1;
                end_inedx +=1;
                
            }else{
                end_inedx++;
            }
        }
        start_index++;
        end_inedx=start_index+1;
        
        }
        System.out.println(cnt);
    }
}
