import java.util.Scanner;

public class Problem003_MYversion {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] Num = new long[N+1];
        long[] Sum = new long[N+1];

        Num[0] = 0;
        Sum[0] = 0;

        for(int i = 1 ; i<= N; i++){
            Num[i] = sc.nextLong();
            if(i== 1){
                Sum[1] = Num[1];
            }else{
                Sum[i] +=  Sum[i-1] + Num[i];
            }
        }

        for(int i =0; i<M;i ++){
        int first = sc.nextInt();
        int last = sc.nextInt();
        if(first == 1){
        System.out.println(Sum[last]);
        }else{
        System.out.println(Sum[last] - Sum[first-1]);
        }
        }
    }
}