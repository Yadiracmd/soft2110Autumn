package ch2.sqllist;



public class Example2_1 {
    public static void reverse(SqListClass<Integer> L) {
        int i = 0, j = L.size() - 1;
        while (i < j) {
            L.swap(i, j);
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        //1,创建一个顺序表对象
        Integer[] a = {1, 2, 3, 4, 5};
        SqListClass<Integer> sqList = new SqListClass<>();
        sqList.CreateList(a);
        System.out.println("sqllist：" + sqList);

        //2,逆置
        reverse(sqList);
        System.out.println("逆置后的sqlList：" + sqList);
    }
}
