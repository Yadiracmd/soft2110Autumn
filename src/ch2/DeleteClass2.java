package ch2;
/*
    @Author:***
    @Date:2022/9/9
    @Description：有一个整数顺序表L。设计一个尽可能高效的算)法删除表中值大于等于x且小于等于y的所有元素(x≤y)，
    删除后元素的相对次序不改变。并给出算法的时间和空间复杂度。
    例如，L=(4，2，1，5，3，6，4)，x=2，y=4，删除后L=(1，5，6)。
    算法时间复杂度O(n)
*/



public class DeleteClass2 {
    public static void deleteRange(SqListClass<Integer> e, int x, int y) {
        if (x > y) {
            throw new RuntimeException("x的值大于y,必须x的值小于等于y");
        }
        int i = -1, j = 0;
        while (j < e.size()) {
            if (e.GetElem(j) < x || e.GetElem(j) > y) {
                i++;
                if (i != j)
                    e.swap(i, j);
            }
            j++;//算法时间复杂度O(n)
        }
        e.Setsize(i + 1);
    }

    public static void main(String[] args) {
        SqListClass<Integer> l = new SqListClass<>();
        Integer[] elements = {4, 2, 1, 5, 3, 6, 4};
        l.CreateList(elements);
        System.out.println("l:" + l);
        deleteRange(l, 2, 4);
        System.out.println("删除后元素：");
        System.out.println("l:" + l);
    }
}
