package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_11 {
    public static int Maxcount(LinkListClass<Integer> L) {//时间复杂度O(n) 空间复杂度O(1)
        int cnt = 1;
        Integer maxe;
        LinkNode<Integer> p = L.head.next;//p指向首结点
        maxe = p.data;//maxe置为首结点值
        while (p.next != null) {//循坏到p结点为尾结点
            if (p.next.data > maxe) {//找到更大的结点
                maxe = p.next.data;
                cnt = 1;
            } else if (p.next.data.equals(maxe))//p结点为当前最大值结点
                cnt++;
            p = p.next;
        }
        return cnt;
    }

    public static void main(String[] args) {
        //创建单链表
        LinkListClass<Integer> list = new LinkListClass<>();
        Integer[] a = {1, 5, 8, 4, 8, 7, 5, 6};
        list.CreateListR(a);    //用尾插法插入元素
        System.out.println("list" + list);


        System.out.println("****最大值结点的个数****");
        int maxValue = Maxcount(list);
        System.out.println("最大元素的个数" + maxValue);

    }
}