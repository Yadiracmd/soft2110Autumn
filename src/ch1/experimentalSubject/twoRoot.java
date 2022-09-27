package ch1.experimentalSubject;

import java.util.Scanner;

public class twoRoot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入方程的系数a、b、c：");
        int a, b, c;
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        int delta;
        double x1, x2;
        delta = b * b - 4 * a * c;
        if (a == 0 && b == 0 && c == 0) {
            System.out.println("方程有无限根。");
            return;
        }
        if (a == 0 && b == 0 & c != 0) {
            System.out.println("方程无解。");
            return;
        }
        if (delta == 0) {
            x1 = b / -2.0 / a;
            x2 = b / -2.0 / a;
            System.out.println("方程有两个相同实根, x1 =  "
                    + x1 + ",  x2 = " + x2);
        }
        if (delta > 0) {
            x1 = (-b + Math.sqrt(delta)) / 2.0 / a;
            x2 = (-b - Math.sqrt(delta)) / 2.0 / a;
            System.out.println("方程有两个不同实根, x1 = "
                    + x1 + ",  x2 = " + x2);
        }
        if (delta < 0) {
            double s, x;
            s = -b / 2.0 / a;
            x = Math.sqrt(-delta) / 2.0 / a;
            System.out.println("方程有虚根, x1 = "
                    + s + " + " + x+ "i,  x2 = "
                    + s + " - " + x + "i");
        }
    }
}
