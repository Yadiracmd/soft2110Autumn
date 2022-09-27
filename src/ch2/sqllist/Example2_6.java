package ch2.sqllist;


public class Example2_6 {
    public static SqListClass<Integer> Merge2(SqListClass<Integer> A, SqListClass<Integer> B) {
        SqListClass<Integer> C = new SqListClass<Integer>();
        int i = 0, j = 0;//i用于遍历A,j用于遍历B
        while (i < A.size() && j < B.size()) {//两个表均没有遍历完毕
            if (A.GetElem(i) < B.GetElem(j)) {
                C.Add(A.GetElem(i));//将较小的A中元素添加到C中
                i++;
            } else {
                C.Add(B.GetElem(j));//将较小的B中元素添加到C中
                j++;
            }
        }
        while (i < A.size()) {//若A没有遍历完毕
            C.Add(A.GetElem(i));
            i++;
        }
        while (j < B.size()) {//若B没有遍历完毕
            C.Add(B.GetElem(j));
            j++;
        }
        return C;
    }

    public static void main(String[] args) {
        //1,创建顺序表a
        Integer[] a = {1, 3, 5, 7};
        SqListClass<Integer> A = new SqListClass<>();
        A.CreateList(a);
        System.out.println("A:" + A);

        //2.创建顺序b
        Integer[] b = {1, 2, 5, 7, 9, 10, 20};
        SqListClass<Integer> B = new SqListClass<>();
        B.CreateList(b);
        System.out.println("B:" + B);
        //输出二路归并的方法
        System.out.println("二路归并");
        SqListClass<Integer> C = Merge2(A, B);
        System.out.println("C:" + C);


    }
}
