package ch2.sqllist;


public class Example2_7 {
    public static int Middle(SqListClass<Integer> A, SqListClass<Integer> B) {
        int i = 0, j = 0, k = 0;//i：遍历A的序号，j：遍历B的序号，k：记录循环的次数
        while (i < A.size() && j < B.size()) {//两个有序顺序表均没有扫描完
            k++;//当前归并的元素个数增1
            if (A.GetElem(i) < B.GetElem(j)) {//归并A中较小的元素
                if (k == A.size())//若当前归并的元素是第n个元素
                    return A.GetElem(i);//返回A中的当前元素
                i++;
            } else {//归并B中较小的元素
                if (k == B.size())//若当前归并的元素是第n个元素
                    return B.GetElem(j);//返回B中的当前元素
                j++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //1，创建顺序表A
        SqListClass<Integer> A=new SqListClass<>();
        Integer [] a={11,13,15,17,19};
        A.CreateList(a);
        System.out.println("A:"+A);
        //2,创建顺序表B
        SqListClass<Integer> B=new SqListClass<>();
        Integer [] b={2,4,6,8,20};
        B.CreateList(b);
        System.out.println("B:"+B);
        //3,求中位数
        System.out.println("求中位数x");
        Integer x=Middle(A,B);
        System.out.println("x="+x);
    }
}
