package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_16 {
    public static LinkListClass<Integer> Merge2(LinkListClass<Integer> A, LinkListClass<Integer> B) {
        LinkNode<Integer> p = A.head.next;//p指向A的首结点
        LinkNode<Integer> q = B.head.next;//q指向B的首结点
        LinkListClass<Integer> C = new LinkListClass<Integer>();
        LinkNode<Integer> t = C.head;//t为C的尾结点
        while (p != null && q != null) {//两个单链表都没有遍历完
            if (p.data < q.data) {//将较小结点p链接到C的末尾
                t.next = p;
                t = p;
                p = p.next;
            } else {//将较小结点q链接到C的末尾
                t.next = q;
                t = q;
                q = q.next;
            }
        }//将尾结点的next设置为空
        t.next = p;
        if (q != null) t.next = q;
        return C;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 5, 7};
        LinkListClass<Integer> A = new LinkListClass<>();
        A.CreateListR(a);
        System.out.println("A:" + A);

        Integer[] b = {1, 2, 3, 7, 9, 10, 20};
        LinkListClass<Integer> B = new LinkListClass<>();
        B.CreateListR(b);
        System.out.println("B:" + B);

        System.out.println("二路归并");
        LinkListClass<Integer> C = Merge2(A, B);
        System.out.println("A:" + A);
        System.out.println("B:" + B);
        System.out.println("C:" + C);
    }
}