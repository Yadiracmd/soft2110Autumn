package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/22
    @Description：IntelliJ IDEA
*/

public class Insert {
    public static boolean insert(LinkListClass<Integer> L, Integer i, Integer x) {
        if (i < 0 || i > L.size()) {
            return false;
        }
        LinkNode<Integer> p = L.head, q = L.head.next;
        for (int j = 0; j < i; j++) {
            p = p.next;
            q = q.next;
        }
        LinkNode<Integer> s = new LinkNode<Integer>(x);
        if(q!=null)
            s.next = q;
        p.next = s;
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 2, 3, 1};
        LinkListClass<Integer> L = new LinkListClass<>();
        L.CreateListR(a);
        System.out.println("L:" + L);
        insert(L, 5, 6);
        System.out.println("L:" + L);
    }
}
