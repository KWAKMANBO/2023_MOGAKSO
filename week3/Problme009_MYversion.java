import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problme009_MYversion {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // DNA문자열의 길이와 비밀번호로 사용할 문자열의 길이를 입력 받음
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // DNA문자열 입력받기
        st = new StringTokenizer(bf.readLine());
        String dna = st.nextToken();

        st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int cnt = 0;

        // java에서 문자열 접근을 위해서는 chartAt()을 사용해야함
        for (int i = 0; i <= S - P; i++) {
            int j = 0;

            int Acnt = 0;
            int Ccnt = 0;
            int Gcnt = 0;
            int Tcnt = 0;

            while (j != P) {
                if (dna.charAt(i + j) == 'A') {
                    Acnt++;

                } else if (dna.charAt(i + j) == 'C') {
                    Ccnt++;

                } else if (dna.charAt(i + j) == 'G') {
                    Gcnt++;

                } else if (dna.charAt(i + j) == 'T') {
                    Tcnt++;
                }
                j++;
            }
            System.out.println();
            if (Acnt >= A && Ccnt >= C && Gcnt >= G && Tcnt >= T)
                cnt++;
        }

        System.out.println("\n" + cnt);
    }
}
