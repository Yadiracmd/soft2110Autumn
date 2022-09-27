package ch2.sqllist;



public class Example2_5 {
    public static void Delsame(SqListClass<Integer> L) {
        int k = 1;//k用于记录不重复的个数，因为第一个数肯定会暴保留，所有k开始
        for (int i = 1; i < L.size(); i++)
            if (L.GetElem(i) != L.GetElem(k - 1)) {//将不是相邻重复的元素插入
                L.SetElem(k, L.GetElem(i));
                k++;
            }
        L.Setsize(k);//重置长度
    }

    public static void main(String[] args) {
        //测试1
        //1,创建顺序表对象l1
        SqListClass<Integer> l1=new SqListClass<>();
        //2，使用对象数组创建顺序表
        Integer [] a={1,2,2,2,1};
        l1.CreateList(a);
        System.out.println("l1:"+l1);

        System.out.println("删除所有相邻重复的元素");
        Delsame(l1);
        System.out.println("l1:"+l1);

    }
}
