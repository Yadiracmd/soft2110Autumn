package ch1.page21;

class B {//类B
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

public class tmpChange {
    public static void fun(B o){//改变o.n
        o=new B(1);//为对象o重新分配指向的实例
        o.add();
    }

    public static void main(String[] args) {
        B a=null;
        fun(a);
        System.out.printf("a.n=%d",a.getn());
    }
}
