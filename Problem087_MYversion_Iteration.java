import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem087_MYversion_Iteration {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

       long D[] = new long[1001];

        D[1] = 1;
        D[2] = 2;

        // 반복버전
        for (int i = 3; i <= n; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % 10007;
        }

        System.out.println(D[n]);

    }
}
