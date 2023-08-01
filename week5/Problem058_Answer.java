import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Problem058_Answer {
    static final int INF = 100000000;

    static class Node implements Comparable<Node> {
        int node;
        int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost < o.cost ? -1 : 1;
            // 내림차순으로 정렬
            // return 값이 -1이면 비교하는 객체의 cost가 뒤에 있어야함
            // return 값이 1이면 비교하는 객체의 cost가 앞에 있어야함
            // 이 코드의 경우 오름차순으로 정렬함
        }
    }

    public static void main(String args[]) throws IOException{
        int N,M,K;
        
        // 인정햅령 선언
        int [][] W = new int[1001][1001];
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

         //N(노드의 개수), M(에지의 개수), K(k번째 도시를 입력)) 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> distQueue[] = new PriorityQueue[N+1];


        Comparator<Integer> cp = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 < o2 ? 1: -1;
                // o1 이 o2보다 작다면 1을 반환 
                // return 이 1이면 선행객체가 앞에 위치
                // return 이 -1 이면 후행객체가 뒤에 위치
            }
        };

        for (int i = 0 ; i < N + 1 ; i++){
             distQueue[i] = new PriorityQueue<>(K, cp);
            // Priority Queue를 초기화
            // N + 1로 하는 이유는? --> 인접행렬에서 노드에 해당하는 인덱스를 사용하기 위해서
            // 각 priority queue당 사이즈는 K
            // k번째 경로의 도시를 구하기 위해서는 Prirority Queue 사이즈를 명시해줘야함
            // 비교 근거는 cp이다.
        }

        for(int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());

            W[a][b] = c;
            // a에서 b로가는 가중치는 c
        }   

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(1,0));
        // priority queue에 출발지인 노드 1을 add
        distQueue[1].add(0);
        // 노드 1의 경로 순위를 저장하는 큐에 0을 삽입

        while(!pq.isEmpty()){ //Priority Queue가 빌때까지 반복
            Node u = pq.poll(); // u에 pq에 있는 가장 가까운 노드의 값을 저장
            for(int adjNode = 1; adjNode <= N; adjNode++){
                if(W[u.node][adjNode] != 0){
                    // 저장된 경로가 k개 이하이면 경로를 그냥 추가
                    if(distQueue[adjNode].size() < K){
                        // 최단 거리 큐에 k개 이하의 값이 들어있다면
                        distQueue[adjNode].add(u.cost + W[u.node][adjNode]);
                        //  해당 인덱스 최단 거리 큐에 노드 값을 저장 
                        pq.add(new Node(adjNode, u.cost + W[u.node][adjNode]));
                        // pq에도 값을 추가 
                    }else if(distQueue[adjNode].peek() > u.cost + W[u.node][adjNode]){
                        // 저장된 경로가 k개 이고, 현재 가장 큰 값보다 작을때만 추가
                        distQueue[adjNode].poll(); //큐에서 Max값을 삭제
                        distQueue[adjNode].add(u.cost + W[u.node][adjNode]);// 새로운 값을 최단 거리 큐에 삽입
                        pq.add(new Node(adjNode, u.cost + W[u.node][adjNode])); // qp에 노드 추가 
                    } 
                }
            }
        }

        for(int  i =1; i <=N; i++){//K번째 경로 출력
           if(distQueue[i].size() == K){ 
            // 최단 거리 큐의 사이즈가 k라면
            // 사이즈가 k이기 때문에 바로 poll하면 k번째 경로의 가중치가 출력됨
            bw.write(distQueue[i].peek() + "\n");           
           }else{
            // 최단 거리 큐의 사이즈가 k보다 작다면
            // 사이즈가 보다 작으므로 k번째 경로가 없으므로 -1을 출력함.
            bw.write(-1 + "\n");
        }
        }
       bw.flush();
       bw.close();
       br.close();
    }
}
