package ch1.page19;

public class exchangeSimple {
    static int x1,y1;
    public static void swap(int x,int y){
        x1=y;
        y1=x;
    }

    public static void main(String[] args) {
        int a=1,b=2;
        swap(a,b);
        a=x1;b=y1;
        System.out.printf("a=%d,b=%d",a,b);//输出a=2,b=1
    }
}
