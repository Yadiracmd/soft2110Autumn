package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_14 {
    public static LinkListClass<Integer> Comb(LinkListClass<Integer> A, LinkListClass<Integer> B) {
        LinkListClass<Integer> C = new LinkListClass<Integer>();
        LinkNode<Integer> p, q, t;
        p = A.head.next;//p指向A的首结点
        q = B.head.next;//q指向b的首结点
        t = C.head;//t始终指向C的尾结点
        while (p != null && q != null) {//当两个表均未遍历完时
            t.next = p;
            t = p;//将p结点插入c的末尾
            p = p.next;//p后移一个结点
            t.next = q;
            t = q;//将q结点插入C的末尾
            q = q.next;//q后移一个结点
        }//将尾结点的next设置为空
        if (p != null) t.next = p;//A未遍历完，将余下结点链接到C的尾部
        if (q != null) t.next = q;//B未遍历完，将余下结点链接到C的尾部
        return C;
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

        System.out.println("***合并***");
        LinkListClass<Integer> C = Comb(A, B);
        System.out.println("C" + C);

    }


}
