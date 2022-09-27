package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/17
    @Description：最简算法求差集
*/

public class Homework04 {
    //时间复杂度o(m+n) 空间复杂度O(min(m,n))
    public static LinkListClass<Integer> differenceSet(LinkListClass<Integer> A, LinkListClass<Integer> B) {
        LinkListClass<Integer> C = new LinkListClass<>();
        LinkNode<Integer> aPoint = A.head.next;
        LinkNode<Integer> bPoint = B.head.next;
        LinkNode<Integer> cPoint = C.head, s;
        while (aPoint != null && bPoint != null) {
            if (aPoint.data > bPoint.data) {
                bPoint = bPoint.next;
            } else if (aPoint.data.equals(bPoint.data)) {
                aPoint = aPoint.next;
                bPoint = bPoint.next;
            } else {
                s = new LinkNode<>(aPoint.data);
                cPoint.next = s;
                cPoint = s;
                aPoint = aPoint.next;
            }
        }
        if (aPoint != null) {
            s = new LinkNode<>(aPoint.data);
            cPoint.next = s;
            cPoint = s;
        }
        cPoint.next = null;
        return C;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 5, 7};
        Integer[] b = {1, 2, 4, 5, 9};
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
