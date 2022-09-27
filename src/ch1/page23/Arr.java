package ch1.page23;

//class A<E>{//定义泛型类A
//    public E n;//数组成员n为E类型
//    public void add(E m){//add方法
//        n+=m;//实际上泛型类A是错误的,因为在编译时泛型参数E被替换Object,无法直接Object变量n和m执行n+=m;
//    }
//    public void disp(){//输出所有元素
//        System.out.println("n="+n);
//    }
//}

public class Arr<E> {//定义数组泛型类
    public E[] data;//存放数组中的元素
    public int size;//存放长度
    public Arr(int n){//构造方法
        data=(E[]) new Object[n];//强制转换为E类型数组
        size=0;
    }
    public void add(E e){//末尾添加一个元素
        data[size]=e;
        size++;
    }
    public void disp(){//输出所有元素
        for (int i = 0; i < size; i++) {
            if(i==0) System.out.print(data[i]);
            else System.out.print(" "+data[i]);
        }
        System.out.println();
    }
}
class tmp{
    public static void main(String[] args) {
        Arr<Integer> arr1=new Arr<Integer>(5);//创建整数数组arr1
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        System.out.print("arr1:");arr1.disp();
        Arr<String> arr2=new Arr<String>(3);//创建字符串数组arr2
        arr2.add("Mary");
        arr2.add("John");
        arr2.add("Smith");
        System.out.print("arr2:");arr2.disp();
    }
}