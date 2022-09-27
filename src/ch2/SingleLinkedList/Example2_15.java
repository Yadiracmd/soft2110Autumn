package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_15 {
    public static void Split(LinkListClass<Integer> L, LinkListClass<Integer> A, LinkListClass<Integer> B) {
        LinkNode<Integer> p = L.head.next;//p指向L的首结点
        LinkNode<Integer> q = null, t;
        t = A.head;//t始终指向A的尾结点
        while (p != null) {//遍历L的所有数据结点
            t.next = p;
            t = p;//用尾插入法建立A
            p = p.next;//p后移一个结点
            if (p != null) {
                q = p.next;//临时保存p结点的后续结点
                p.next = B.head.next;//用头插法建立B
                B.head.next = p;
                p = q;//p指向q结点
            }
        }
        t.next = null;//将尾结点的next设置为空
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        LinkListClass<Integer> A = new LinkListClass<>();
        A.CreateListR(a);
        System.out.println("A:" + A);

        Integer[] b = {10, 20, 30, 40, 50, 60, 70};
        LinkListClass<Integer> B = new LinkListClass<>();
        B.CreateListR(b);
        System.out.println("B:" + B);

        LinkListClass<Integer> C = new LinkListClass<>();

        System.out.println("***合并***");
        Split(A, B, C);
        System.out.println("C:" + C);
    }
}
