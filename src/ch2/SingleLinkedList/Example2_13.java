package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_13 {
    public static void Reverse(LinkListClass<Integer> L) {
        LinkNode<Integer> p = L.head.next, q;//p指向首结点
        L.head.next = null;//将L设置为一个空表
        while (p != null) {
            q = p.next;//q临时保存p结点的后续结点
            p.next = L.head.next;//将p结点插入表头
            L.head.next = p;
            p = q;
        }
    }

    public static void main(String[] args) {
        Integer[] array={1,5,7,4,3};
        LinkListClass<Integer> L=new LinkListClass<>();
        L.CreateListR(array);
        System.out.println("L："+L);
        System.out.println("逆序后");
        Reverse(L);
        System.out.println("L："+L);
    }
}
