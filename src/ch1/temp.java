package ch1;

class A {
    int n;
    public A(){};//无参构造方法
    public A(int n1){//有参构造方法
        n=n1;
    }
}

public class temp{
    public static void main(String[] args) {
        A a=new A();
        A B=new A(2);
    }
}

