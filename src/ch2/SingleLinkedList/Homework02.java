package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/17
    @Description
*/

public class Homework02 {
    public static void remove(LinkListClass<Integer> l) {
        LinkNode<Integer> aPoint = l.head, p = l.head.next, pre;
        while (aPoint != null && p.data < 0) {
            aPoint = aPoint.next;
            p = p.next;
        }
        pre = aPoint;
        while (p != null) {
            if (p.data < 0) {
                pre.next = p.next;
                p.next = aPoint.next;
                aPoint.next = p;
                aPoint = p;
                p = pre.next;
            } else {
                pre = pre.next;
                p = pre.next;
            }
        }
    }


    public static void main(String[] args) {
        LinkListClass<Integer> L = new LinkListClass<>();
        Integer[] elements = {1, 2, -1, -2, 3, -3, 4};
        L.CreateListR(elements);
        remove(L);
        System.out.println(L);
    }
}
