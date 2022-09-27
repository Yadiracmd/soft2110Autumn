package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/22
    @Description：IntelliJ IDEA
*/
@SuppressWarnings("")
public class Exam27 {
    public static boolean isOrder(LinkListClass<Integer> L) {
        LinkNode<Integer> pre = L.head, p = L.head.next;
        while (p != null) {
            if (pre.data > p.data)
                return false;
            p = p.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 2};
        LinkListClass<Integer> L = new LinkListClass<>();
        L.CreateListR(a);
        System.out.println("L:" + L);

        System.out.println("L:" + isOrder(L));
    }

}
