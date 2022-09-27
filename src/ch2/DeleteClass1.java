package ch2;/*
    @Author:***
    @Date:2022/9/9
    @Description：有一个整数顺序表L。设计一个尽可能高效的算法删除其中所有值为负整数的元素
    (假设L中值为负整数的元素可能有多个)，删除后元素的相对次序不改变。并给出算法的时间和空间复杂度。
    例如，L=(1，2，-1，-2，3，-3)，删除后L=(1，2，3)。


*/

public class DeleteClass1 {
    public static void deleteMinus(SqListClass<Integer> e){
        int k=0;
        for (int i = 0; i < e.size; i++) {
            if(e.GetElem(i)>0){
                e.SetElem(k,e.GetElem(i));
                k++;
            }
        }
        e.Setsize(k);
    }
    public static void main(String[] args) {
        SqListClass<Integer> l = new SqListClass<>();
        Integer[] elements = {1,2,-1,-2,3,-3};
        l.CreateList(elements);
        System.out.println("l:" + l);
        deleteMinus(l);
        System.out.println("删除后元素：");
        System.out.println("l:" + l);
    }
}
