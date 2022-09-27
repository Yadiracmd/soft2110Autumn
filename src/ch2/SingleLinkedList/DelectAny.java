package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/22
    @Description：IntelliJ IDEA
*/

public class DelectAny {
    public static void delete(LinkListClass<Integer> A, Integer x) {
        LinkNode<Integer> p = A.head.next, pre = A.head;
        while (p != null) {
            if (p.data == x) {
                pre.next=p.next;
                p=pre.next;

            } else {
                pre=pre.next;
                p = p.next;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 2, 3, 1};
        LinkListClass<Integer> L = new LinkListClass<>();
        L.CreateListR(a);
        System.out.println("L:" + L);
        delete(L, 2);
        System.out.println("L:" + L);
    }
}
