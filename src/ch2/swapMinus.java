package ch2;/*
    @Author:***
    @Date:2022/9/9
    @Description：有一个整数顺序表L，设计一个尽可能高效算法将所有负整数的元素移到其他元素的前面。
    并给出算法的时间和空间复杂度。
    例如，L=(1，2，-1，-2，3，-3，4)，移动后L=(-1，-2，-3，2，3，1，4)。
*/



public class swapMinus {
    public static void swap(SqListClass<Integer> e){
        int i = -1, j = 0;
        while (j < e.size()) {
            if (e.GetElem(j) <0 ) {
                i++;
                if (i != j)
                    e.swap(i, j);
            }
            j++;//算法时间复杂度O(n)
        }
    }

    public static void main(String[] args) {
        SqListClass<Integer> l = new SqListClass<>();
        Integer[] elements = {1,2,-1,-2,3,-3,4};
        l.CreateList(elements);
        System.out.println("l:" + l);
        swap(l);
        System.out.println("移动后元素：");
        System.out.println("l:" + l);
    }
}
