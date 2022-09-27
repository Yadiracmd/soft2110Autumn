package ch1.experimentalSubject;

import java.util.Scanner;

public class CountSecond {
    public static void t(int n){
        int sum1=0,sum2=0;int p=0;
        for (int i = 1; i <=n ; i++) {
            p++;
            sum1+=i;
            sum2+=sum1;
        }//O(n)
        System.out.println("执行次数："+p);
        System.out.print("计算结果："+sum2);
    }

    public static void main(String[] args) {
        System.out.print("请输入n的值：");
        Scanner input=new Scanner(System.in);
        int number=input.nextInt();
        t(number);
    }
}
