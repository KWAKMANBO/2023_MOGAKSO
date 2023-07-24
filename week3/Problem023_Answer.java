import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem023_Answer {
    static ArrayList<Integer>[] A;
    static boolean visited[];

 public static void main(String args[]) throws IOException{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A =  new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i < N +1; i++){
            A[i] = new ArrayList<Integer>(); // 연결 리스트 초기화하기
        }
        
        for(int i=0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        for (int i = 1; i < A.length; i++) {
            System.out.print("Node " + i + ": ");
            for (int j : A[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        int count =0;
        for(int i= 1 ; i < N +1; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : A[v]){
            if(visited[i] == false){// 연결 노드중 방문x 노드만 탐색하기
                DFS(i);
            }
        }
    }
}
