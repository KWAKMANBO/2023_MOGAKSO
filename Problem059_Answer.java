import java.io.*;
import java.util.*;

public class Problem059_Answer {
    
    static class Edge{
        int start;
        int end;
        int w;

        Edge(int start, int end, int w){
            this.start= start;
            this.end = end;
            this.w = w;
        }
    }

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int dist[] = new int[N+1];
        Edge edges[] = new Edge[N+1];

        Arrays.fill(dist,Integer.MAX_VALUE );

        for(int i =0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
        
            edges[i] = new Edge(s,e,w);
        }

        // 벨만-포드 알고리즘 수행
        dist[1] = 0; // 출발점을 0으로 초기화
        for(int i = 0; i < N -1; i++){
            for(int j =0; j< M; j++){
                Edge edge = edges[j];//노드를 불러오기

                if(dist[edge.start] != Integer.MAX_VALUE && dist[edge.start] + edge.w < dist[edge.end]){
                    dist[edge.end] = dist[edge.start] + edge.w;
                }
            }
        }

        boolean mCycle = false;

        for(int i = 0; i < M; i++){
            Edge edge = edges[i];
            if(dist[edge.start] != Integer.MAX_VALUE && dist[edge.start] + edge.w < dist[edge.end]){
                mCycle =true;
            }
        }

        if(!mCycle){
            for(int i = 1; i <= N ; i++){
                if(dist[i] == Integer.MAX_VALUE){
                    System.out.println("-1");
                }else{
                    System.out.println(dist[i]);
                }
            }
        }else{
            System.out.println("-1");
        }
    }
}
