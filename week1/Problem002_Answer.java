import java.util.Scanner;

public class Problem002_Answer {
    public static void main(String args[]){
        Scanner sc =  new Scanner(System.in);
        
        int N = sc.nextInt();
        int Score[] = new int[N];
        double M =0;
        double Sum =0;

        // 점수 입력
        for(int i = 0 ; i < N; i++){
            Score[i] = sc.nextInt();
        }
        // max 값을 도출
        for(int i = 0 ; i < N ; i++){
            Sum += Score[i];
            if(Score[i] > M){
                M = Score[i];
            }
        }

        System.out.println(Sum*100/M/N);
        }
}
