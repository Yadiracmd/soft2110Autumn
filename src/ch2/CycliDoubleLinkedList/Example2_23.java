package ch2.CycliDoubleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_23 {
    public static CDLinkListClass<Integer> Conb(CDLinkListClass<Integer> A, CDLinkListClass<Integer> B) {
        DLinkNode<Integer> ta = A.dhead.prior;//ta指向A的尾结点
        DLinkNode<Integer> tb = B.dhead.prior;//tb指向A的尾结点
        ta.next = B.dhead.next;//尾首相连
        B.dhead.next.prior = ta;
        tb.next = A.dhead;
        A.dhead.prior = tb;
        return A;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 5, 8, 7, 5};
        Integer[] b = {4, 3, 4, 8, 7};
        CDLinkListClass<Integer> L1 = new CDLinkListClass<>();
        L1.CreateListR(a);
        System.out.println("L1:" + L1);
        CDLinkListClass<Integer> L2 = new CDLinkListClass<>();
        L2.CreateListR(b);
        System.out.println("L:" + L2);
        CDLinkListClass<Integer> L3 = Conb(L1, L2);
        System.out.println("L3:" + L3);
    }
}