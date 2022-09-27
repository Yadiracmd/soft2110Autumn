package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/17
    @Description：IntelliJ IDEA
*/

public class Homework03 {
    //时间复杂度O(m*n)  空间复杂度O(m)
    public static LinkListClass<Integer> differenceSet(LinkListClass<Integer> A, LinkListClass<Integer> B) {
        LinkListClass<Integer> C = new LinkListClass<>();
        LinkNode<Integer> p = A.head.next, cPoint = C.head, s;
        while (p != null) {
            if (B.GetNo(p.data) == -1) {//查看每一个A数组中的元素是否在数组B中存在
                s = new LinkNode<>(p.data);//将数组A中的元素封装成一个结点
                cPoint.next = s;//使用尾插法插入元素
                cPoint = s;//
            }
            p = p.next;
        }
        cPoint.next = null;
        return C;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 2};
        Integer[] b = {5, 1, 4, 2};
        LinkListClass<Integer> A = new LinkListClass<>();
        LinkListClass<Integer> B = new LinkListClass<>();
        LinkListClass<Integer> C;
        A.CreateListR(a);
        B.CreateListR(b);
        System.out.println("A:" + A);
        System.out.println("B:" + B);
        C = differenceSet(A, B);
        System.out.println("C:" + C);
    }
}
