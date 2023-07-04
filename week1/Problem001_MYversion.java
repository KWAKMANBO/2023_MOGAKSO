// 문제 001 숫자의 합 구하기
// 내가 작성한 코드

import java.util.Scanner;

public class Problem001_MYversion {
    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       double input_num =0;

       input_num = sc.nextDouble();
    
        double num =0;
        long sum =0;
       double res = 0;

       if( input_num > 0 && input_num < 101){
            num = sc.nextDouble();
            if( num/ Math.pow(10, input_num-1) > 9){
                System.out.println("error");
            }else{
                for(int i=0; i <=input_num; i++){
                    System.out.println("input_num - i : " +Math.pow(10, input_num -(i+1)));
                    System.out.println("num/Math.pow(10, input_num - i): " + num / Math.pow(10, input_num -(i+1)));
                    sum += num / Math.pow(10, input_num -i);
                    System.out.println("sum:" +sum);
                    num  = num % Math.pow(10, input_num - i);
                    System.out.println("num: "+ num);
                }
            }
       }else{
        System.out.println("error");
       }
       System.out.println(sum);
    }
}
