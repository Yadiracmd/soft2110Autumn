package ch2.DoubleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

class DLinkNodel<E> {//双链表结点泛型类
    E data;//结点中的元素值
    int freq;//结点访问频度
    DLinkNodel<E> prior;//前驱结点指针
    DLinkNodel<E> next;//后驱结点指针

    public DLinkNodel() {//构造方法
        freq = 0;
        prior = null;
        next = null;
    }

    public DLinkNodel(E d) {//重载构造方法
        freq = 0;
        data = d;
        prior = null;
        next = null;
    }
}

class DLinkListClass1<E> {//双链表泛型类
    DLinkNodel<E> dhead;//存放头结点

    public DLinkListClass1() {//构造方法
        dhead = new DLinkNodel<E>();//创建头结点
        dhead.prior = null;
        dhead.next = null;
    }

    //线性表的基本运算算法
    public void CreateListR(E[] a) {//尾插法：用数组a整体建立双链表
        DLinkNodel<E> s, t;
        t = dhead;//t始终指向尾结点，开始时指向头结点
        for (int i = 0; i < a.length; i++) {//循环建立数据结点s
            s = new DLinkNodel<E>(a[i]);//新建存放a[i]元素的结点s
            t.next = s;//将s结点插入t结点之后
            s.prior = t;
            t = s;
        }
        t.next = null;//将尾结点的next成员设置为null
    }

    public String toString() {//将线性表转换为字符串
        String ans = "";
        DLinkNodel<E> p = dhead.next;
        while (p != null) {
            ans += p.data + "[" + p.freq + "]";
            p = p.next;
        }
        return ans;
    }
}

public class Example2_19 {

    private static void swap(DLinkNodel<Integer> p, DLinkNodel<Integer> q) {//交换p和q的结点的值
        int tmp = p.data;
        p.data = q.data;
        q.data = tmp;
        tmp = p.freq;
        p.freq = q.freq;
        q.freq = tmp;
    }

    public static boolean LocateElem(DLinkListClass1<Integer> L, Integer x) {//查找值为x的结点
        DLinkNodel<Integer> p, pre;
        p = L.dhead.next;//p指向开始结点
        while (p != null && !p.data.equals(x))
            p = p.next;
        if (p == null)
            return false;//未找到值为x的结点，返回false
        p.freq++;//找到值为x的结点p
        pre = p.prior;
        while (pre != L.dhead && pre.freq < p.freq) {//若p结点的freq比前驱大，两者的值交换
            swap(pre, p);
            p = pre;
            pre = p.prior;//p、pre同步前移
        }
        return true;//成功找到值为x的结点，则返回true
    }

    public static void Find(DLinkListClass1<Integer> L, Integer x) {//测试结果输出算法
        System.out.println("查找值为" + x + "的结点");
        if (LocateElem(L, x))
            System.out.println("查找成功，双链表L：" + L);
        else
            System.out.println("查找失败");
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        DLinkListClass1<Integer> L = new DLinkListClass1<Integer>();
        L.CreateListR(a);
        System.out.println("L:" + L);
        Find(L, 5);
        Find(L, 1);
        Find(L, 4);
        Find(L, 5);
        Find(L, 2);
        Find(L, 4);
        Find(L, 5);
    }
}