package ch1.page21;

public class example1point8 {
    public static void swap(String x, String y) {//交换x和y
       String tmp=x;
       x=y;
       y=tmp;
       System.out.printf("x=%s,y=%s\n",x,y);
    }

    public static void main(String[] args) {
        String a="Hello";
        String b="World";
        System.out.printf("a=%s,b=%s\n",a,b);
        swap(a,b);
        System.out.printf("a=%s,b=%s\n",a,b);
    }
}
