package ch1.experimentalSubject;

import java.util.Scanner;

public class CountFirst {
    public static void t(int n){
        int sum=0;int evenlyCount;
        for (int i = 1; i <= n; i++) {//n+1次
             evenlyCount=0;
            for (int j = 1; j <= i; j++) {//n*（n+1）/2
                evenlyCount+=j;
            }
            sum+=evenlyCount;
        }
        System.out.print("计算结果："+sum);//O(n的平方)
    }

    public static void main(String[] args) {
        System.out.print("请输入n的值：");
        Scanner input=new Scanner(System.in);
        int number=input.nextInt();
        t(number);
    }
}
