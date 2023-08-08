package week6;
import java.io.*;
import java.util.*;

public class Problem061_MYversion {
    static int INF = 1000000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시 개수
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 노선 개수

        int dist[][] = new int[n + 1][n + 1]; // 거리 배열

        // 거리배열 초기화
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (dist[start][end] > w) {
                dist[start][end] = w;
            }
        }

        for (int k = 1; k < n + 1; k++) {
            for (int s = 1; s < n + 1; s++) {
                for (int e = 1; e < n + 1; e++) {
                    dist[s][e] = Math.min(dist[s][e], dist[s][k] + dist[k][e]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(dist[i][j] == INF){
                    //System.out.println("0");
                    bw.write("0 ");
                }else{
                //System.out.print(dist[i][j] + " ");
                bw.write(dist[i][j] + " ");
                }
            }
            bw.flush();
            System.out.println();
        }
        bw.close();
    }
}
