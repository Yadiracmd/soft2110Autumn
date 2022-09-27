package ch2.sqllist;

/*
 *
 *
 * */

public class Example2_4 {
    public static void Deletex1(SqListClass<Integer> L, Integer x) {
        int i, k = 0;
        for (i = 0; i < L.size(); i++)
            if (L.GetElem(i) != x) {//将不为x的元素插入data中
                L.SetElem(k, L.GetElem(i));
                k++;
            }
        L.Setsize(k);//重置长度
    }

    //解法二
    public static void Deletex2(SqListClass<Integer> L, Integer x) {
        int i, k = 0;
        for (i = 0; i < L.size(); i++)
            if (L.GetElem(i) != x)//将不为x的元素前移k个位置
                L.SetElem(i - k, L.GetElem(i));
            else//累计删除的元素个数k
                k++;
        L.Setsize(L.size() - k);//重置长度
    }

    //解法三
    public static void Deletex3(SqListClass<Integer> L, Integer x) {
        int i = -1, j = 0;
        while (j < L.size()) {//j遍历所有元素
            if (L.GetElem(j) != x) {//找到不为x的元素a[j]
                i++;//扩大不为x的区间
                if (i != j)
                    L.swap(i, j);//将data[i]与data[j]交换
            }
            j++;//继续扫描
        }
        L.Setsize(i + 1);//重置长度
    }

    public static void main(String[] args) {
        //测试1
        SqListClass<Integer> L1=new SqListClass<>();
        Integer[] a={1,2,1,5,1};
        L1.CreateList(a);
        System.out.println("L1:"+L1);

        Integer x =1;
        System.out.println("删除所有"+x+"的元素");
        Deletex1(L1,x);
        System.out.println("L1:"+L1);
        //测试2
        SqListClass<Integer> L2=new SqListClass<>();
        Integer[] b={1,2,1,5,1,8,7,9,3,2,2};
        L2.CreateList(b);
        System.out.println("L2:"+L2);
        x =2;
        System.out.println("删除所有"+x+"的元素");
        Deletex1(L2,x);
        System.out.println("L1:"+L2);
        //测试3
        SqListClass<Integer> L3=new SqListClass<>();
        Integer[] c={8,4,6,7,5};
        L3.CreateList(c);
        System.out.println("L3:"+L3);
        x =5;
        System.out.println("删除所有"+x+"的元素");
        Deletex1(L3,x);
        System.out.println("L3:"+L3);
    }
}
