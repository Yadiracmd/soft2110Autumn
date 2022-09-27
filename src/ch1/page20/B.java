package ch1.page20;

public class B {//类B
    private int n;
    public B(int n1){//重载构造方法
        n=n1;
    }
    public void add(){//方法add()
        n++;
    }
    public int getn(){//方法getn()
        return n;//返回n
    }

}
class tmp{
    public static void fun(B o){
        o.add();
    }

    public static void main(String[] args) {
        B a=new B(1);
        System.out.printf("a.n=%d\n",a.getn());//输出a.n=1
        fun(a);
        System.out.printf("a.n=%d\n",a.getn());//输出a.n=2
    }
}
