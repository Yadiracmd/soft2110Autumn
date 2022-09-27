package ch1.page17and18;

public class A {//类A
    final int MAXN=5;//常量
    private int size;//私有成员变量
    private int[] a;//私有成员数组
    public A(){//默认构造方法
        size=MAXN;
        a=new int[MAXN];
    }
    public A(int n){//重载构造方法
        size=n;
        a=new int[MAXN];

    }public int getsize(){//方法
        return size;//放回size
    }
}
class example{
    public static void main(String[] args) {
        A a=new A();
        A b=new A(10);
        System.out.println(a.getsize());
        System.out.println(b.getsize());
    }
}