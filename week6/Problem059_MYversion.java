import java.io.*;
import java.util.*;

public class Problem059_MYversion {
    static class node{
        int start;
        int end;
        int cost;

        node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

        static int INF = 100000000;
        
       static ArrayList<node> edges = new ArrayList<>();
        
    // 벨만 포드 함수
    public static int BellmanFord(int n, int m, int start){

        int dist[] = new int[n+1];
        Arrays.fill(dist, INF); // 그래프를 INF 값으로 초기화 
       
        // 출발점은 0으로 초기화
        dist[start] = 0;

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < m; j++){
                node node = edges.get(j);

                if(dist[node.start] != INF && dist[node.end] > dist[node.start] + node.cost ){
                    dist[node.end] = dist[node.start] + node.cost;
                }
            }
        }

        for(int i=0; i < m; i ++){
            node node =  edges.get(i);
            if(dist[node.start] != INF && dist[node.end] > dist[node.start] + node.cost ){
                    System.out.println("-1");
                    return -1;
                }
        }

        for(int i = 2; i < dist.length; i++){
            if(dist[i] != INF){
             System.out.println(dist[i] +" ");
            }else{
             System.out.println("-1");
            }
        }
        return 1;
    }

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new node(a,b,c));
        }

        BellmanFord(N,M,1);
    }

    
}
