package ch2.sqllist;


public class Example2_3 {
    public static boolean Deletek1(SqListClass<Character> L, int i, int k) {
        if (i < 0 || k < 1 || i + k < 1 || i + k > L.size())
            return false;//i和K参数不合法时返回false
        for (int j = i; j <= i + k - 1; j++)
            L.Delete(i);
        return true;//成功删除返回true
    }

    //解法2
    public static boolean Deletek2(SqListClass<Character> L, int i, int k) {
        if (i < 0 || k < 1 || i + k < 1 || i + k > L.size())
            return false;//i和K参数不合法时返回false
        for (int j = i + k; j < L.size(); j++)//将元素前移k个位置
            L.SetElem(j - k, L.GetElem(j));
        L.Setsize(L.size() - k);//长度减k
        return true;//成功删除返回true
    }

    public static void main(String[] args) {
        //测试1
        Character[] a = {'a', 'b', 'c', 'd', 'e'};
        SqListClass<Character> L1 = new SqListClass<>();
        L1.CreateList(a);
        System.out.println("L1:" + L1);
        int i = 1, k = 2;
        System.out.println("删除从" + i + "序号开始的" + k + "个元素");
        Deletek1(L1, i, k);
        System.out.println("L1:" + L1);

        //测试2
        Character[] b = {'1', '2', '3', '4', '5', '6'};
        SqListClass<Character> L2 = new SqListClass<>();
        L2.CreateList(b);
        System.out.println("L2:" + L2);
        i = 2;
        k = 3;
        System.out.println("删除从" + i + "序号开始的" + k + "个元素");
        Deletek2(L2, i, k);
        System.out.println("L2:" + L2);
    }
}
