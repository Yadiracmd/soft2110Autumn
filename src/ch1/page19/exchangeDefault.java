package ch1.page19;

public class exchangeDefault {//交换x和y
    public static int[] swap(int x, int y) {
        int[] tmp = new int[2];
        tmp[0] = y;
        tmp[1] = x;
        return tmp;
    }

    public static void main(String[] args) {
        int a=1,b=2;
        int [] tmp=swap(a,b);
        a=tmp[0];b=tmp[1];
        System.out.printf("a=%d,b=%d",a,b);//输出a=2,b=1
    }
}
