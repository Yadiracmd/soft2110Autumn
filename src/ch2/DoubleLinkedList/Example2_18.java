package ch2.DoubleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_18 {
    public static void Delx(DLinkListClass<Integer> L, Integer x) {
        DLinkNode<Integer> p = L.dhead.next;//p首结点
        while (p != null && p.data != x)//查找第一个值为x的结点p
            p = p.next;
        if (p != null) {//找到值为x的结点p
            if (p.next != null)
                p.next.prior = p.prior;//删除p结点
            p.prior.next = p.next;
        }
    }

    public static void main(String[] args) {
        DLinkListClass<Integer> A =new DLinkListClass<>();
        Integer[] a={1,5,7,5,3};
        A.CreateListR(a);
        System.out.println("A:"+A);
        Delx(A,5);
        System.out.println("A:"+A);
    }
}

