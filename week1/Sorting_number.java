import java.util.Scanner;

public class Sorting_number {
    public static  void main(String args[]){
        int a = 0;
        int ran_num[] = new int[100000];
        System.out.print("입력:");
        Scanner sc = new Scanner(System.in); 
        a = sc.nextInt();
        
        //System.out.println("a:" + a);
        for(int i =0; i < a; i++){
            ran_num[i] = (int)((Math.random())*1000000);
        }


        for(int i = 0; i < a-1; i ++){
            for(int j = i + 1 ;  j < a; j++){
                if(ran_num[i] > ran_num[j]){
                    int tmp = ran_num[j];
                    ran_num[j] = ran_num[i];
                    ran_num[i] = tmp;
                }
            }
        }

        for(int i=0; i < a; i ++){
            System.out.println(ran_num[i]);
        }
    }
}
