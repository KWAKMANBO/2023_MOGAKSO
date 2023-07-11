import java.util.Scanner;

public class Problem006_Answer {
    public static void main(String args[]){
            // 수 입력받기
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            
            // 사용할 변수 초기화
            int count = 1;
            int start_index = 1;
            int end_index=1;
            int sum = 1;

            // end_index가 N이 될때까지 반복
            while(end_index !=N){
                if(sum == N){ // sum과 N이 같을 경우
                    count++;
                    end_index++;
                    sum = sum + end_index;
                }else if(sum < N){ // sun이 N보다 작을 경우
                    end_index++;
                    sum = sum + end_index; 
                }else{ // sum이 N보다 클 경우
                    sum = sum - start_index;
                    start_index++;
                }
            }
            System.out.println(count);
    }   
}
