import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Problem023_MYversion {
    static int[] parent;


    public static boolean union(int x, int  y){
        x = find(x);
        y = find(y);
        if(x == y)return false;

        if(x <= y)parent[y] =x;
        else parent[x] =y;
        return true;
    }
    
    public static int find(int x){
        if(parent[x]==x)return x;
        return find(parent[x]);
        }
        
    public static void main(String args[]) throws IOException{
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        int arr[] = new int[N+1];
       
        for(int i = 2; i <= N; i++){
             st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            parent[x] = x;
            int y = Integer.parseInt(st.nextToken());
            parent[y] = y;
            union(x,y);
        }
        
        int cnt=0;
        int first =1;
        int index=0;
        
        arr[0] = parent[first];
        for(int i = 2; i <=N; i++){

            if(find(parent[first]) != find(parent[i])){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

 }