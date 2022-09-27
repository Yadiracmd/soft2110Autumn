package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/17
    @Description：IntelliJ IDEA
*/

public class Homework05 {
    //时间复杂度O(m*n) 空间复杂度O(n)
    public static LinkListClass<Integer> sameSet(LinkListClass<Integer> A, LinkListClass<Integer> B) {
        LinkListClass<Integer> C = new LinkListClass<>();//创建c结点
        LinkNode<Integer> aPoint = A.head.next;//访问A的数据区域
        LinkNode<Integer> cPoint = C.head, s;//访问C的区域
        while (aPoint != null) {
            if (B.GetNo(aPoint.data) != -1) {//查看每一个A数组中的元素是否在数组B中存在
                s = new LinkNode<>(aPoint.data);//将数组A中的元素封装成一个结点
                cPoint.next = s;//使用尾插法插入元素
                cPoint = s;//
            }
            aPoint = aPoint.next;
        }
        cPoint.next = null;
        return C;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 2, 5};
        Integer[] b = {5, 1, 4, 2};
        LinkListClass<Integer> A = new LinkListClass<>();
        LinkListClass<Integer> B = new LinkListClass<>();
        LinkListClass<Integer> C;
        A.CreateListR(a);
        B.CreateListR(b);
        System.out.println("A:" + A);
        System.out.println("B:" + B);
        C = sameSet(A, B);
        System.out.println("C:" + C);
    }
}
