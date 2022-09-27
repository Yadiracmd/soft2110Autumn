package ch1.experimentalSubject;

import java.util.Scanner;

public class CountThird {
    public static void t(int n){
        int sum=n*(n+1)*(n+2)/6;
        System.out.println("算出的结果："+sum);//O（1）
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        t(input.nextInt());
    }
}
