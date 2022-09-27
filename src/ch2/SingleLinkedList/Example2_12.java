package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_12 {
    public static void Delmaxnodes(LinkListClass<Integer> L) {
        Integer maxe;
        LinkNode<Integer> p = L.head.next, pre;//p指向首结点
        maxe = p.data;//maxe置为首结点值
        while (p.next != null) {//查找最大结点值maxe
            if (p.next.data > maxe)
                maxe = p.next.data;
            p = p.next;
        }
        pre = L.head;//pre指向头结点
        p = pre.next;//p指向pre的后续结点
        while (p != null) {//p遍历所有结点
            if (p.data == maxe) {//p结点为最大值结点
                pre.next = p.next;//删除p结点
            } else {
                pre = pre.next;//pre后移一个结点
            }
            p = pre.next;//让p指向pre的后续结点
        }
    }

    public static void main(String[] args) {
        //创建单链表
        LinkListClass<Integer> L=new LinkListClass<>();
        Integer[] a={1,5,8,4,8,7,5,6};
        L.CreateListR(a);//用尾插法插入元素
        System.out.println("L:"+L);

        Delmaxnodes(L);
        System.out.println("L:"+L);


    }
}