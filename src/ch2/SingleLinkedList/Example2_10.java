package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_10 {
    public static int Middle1(LinkListClass<Integer> L) {//时间复杂度O(n) 空间复杂度O(1)
        int j = 1, n = L.size();
        LinkNode<Integer> p = L.head.next;//p指向首结点
        while (j <= (n - 1) / 2) {//找中间位置的p结点
            j++;
            p = p.next;
        }
        return p.data;
    }

    public static int Middle2(LinkListClass<Integer> L) {//时间复杂度O(n) 空间复杂度O(1)
        LinkNode<Integer> slow = L.head.next;
        LinkNode<Integer> fast = L.head.next;//均指向首结点
        while (fast.next != null && fast.next.next != null) {//找中间位置的p结点
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        //创建单链表
        LinkListClass<Integer> L=new LinkListClass<>();
        Integer[] a={1,5,8,4,8,7,5,6};
        L.CreateListR(a);//用尾插法插入元素
        System.out.println("L:"+L);

        //算法1
        System.out.println("***算法1***");
        int middle=Middle1(L);
        System.out.println("中间元素"+middle);
        //算法2
        System.out.println("***算法2***");
        middle=Middle2(L);
        System.out.println("中间元素"+middle);
    }
}