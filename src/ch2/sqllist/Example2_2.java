package ch2.sqllist;/*
 *@write:周添峰
 */



public class Example2_2 {
    public static void swapMaxMin(SqListClass<Integer> L) {
        int maxi, mini;
        maxi = mini = 0;
        for (int i = 1; i < L.size(); i++) {
            if (L.GetElem(i) > L.GetElem(maxi)) {
                maxi = i;
            } else if (L.GetElem(i) < L.GetElem(mini)) {
                mini = i;
            }
        }
        L.swap(maxi, mini);
    }

    public static void main(String[] args) {
        //1,创建一个顺序表对象
        Integer[] a = {1, 2, 3, 4, 5};
        SqListClass<Integer> sqList = new SqListClass<>();
        sqList.CreateList(a);
        System.out.println("sqllist：" + sqList);
        //2，交换做大值和最小值
        swapMaxMin(sqList);
        System.out.println("sqllist：" + sqList);

    }
}
