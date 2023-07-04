import java.util.Scanner;

public class Problem002_MYversion {
    public static void main(String args[]){
        Scanner sc =  new Scanner(System.in);
        
        int N = sc.nextInt();
        double Score[] = new double[100];
        double M =0;
        double Sum =0;

        // 점수 입력
        for(int i = 0 ; i < N; i++){
            Score[i] = sc.nextDouble();
        }
        // max 값을 도출
        for(int i = 0 ; i < N - 1; i++){
            if(Score[i] > Score[i+1]){
                M = Score[i];
            }else{
                M = Score[i+1];
            }
        }

        // 점수 변형
        for(int i=0; i < N ; i++){
            Sum += (Score[i]/M)*100;
        }
        System.out.println(Sum/N);
        }
}
