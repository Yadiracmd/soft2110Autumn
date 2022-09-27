package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/
class LinkNode<E> {//单链表结点泛型类
    E data;//数据域
    LinkNode<E> next;//指针域

    public LinkNode() {//构造方法
        next = null;
    }

    public LinkNode(E d) {//重载构造方法
        data = d;
        next = null;
    }
}

public class LinkListClass<E> {//单链表泛型类
    LinkNode<E> head;           //存放头结点

    public LinkListClass() {    //构造方法
        head = new LinkNode<E>();//创建头结点
        head.next = null;        //头结点的next成员置为null
    }

    public void CreateListF(E[] a) {//头插法：由数组a整体建立单链表
        LinkNode<E> s;//
        for (int i = 0; i < a.length; i++) {//循环建立数据结点s
            s = new LinkNode<E>(a[i]);//新建存放a[i]元素的结点s
            s.next = head.next;//将s结点插入开始结点之前、头结点之后
            head.next = s;
        }
    }

    public void CreateListR(E[] a) {//尾插法：由数组a整体建立单链表
        LinkNode<E> s, t;//
        t = head;//t始终指向尾结点，开始时指向头结点
        for (int i = 0; i < a.length; i++) {//循环建立数据结点s
            s = new LinkNode<E>(a[i]);//新建存放a【i】元素的结点s
            t.next = s;//将s结点插入t结点之后
            t = s;
        }
        t.next = null;//将尾结点的next成员置为null
    }

    private LinkNode<E> geti(int i) { //返回序号为i的结点
        LinkNode<E> p = head;
        int j = -1;
        while (j < i) {
            j++;
            p = p.next;
        }
        return p;
    }

    public void Add(E e) {
        //在线性表的末尾添加一个元素e
        LinkNode<E> s = new LinkNode<E>(e);//新建结点s
        LinkNode<E> p = head;
        while (p.next != null)//查找尾结点p
            p = p.next;
        p.next = s;//在尾结点之后插入结点s
    }

    public int size() {//求线性表的长度
        LinkNode<E> p = head;
        int cnt = 0;
        while (p.next != null) {//找到尾结点为止
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    public void Setsize(int nlen) {//设置线性表的长度
        int len = size();
        if (nlen < 0 || nlen > len) {
            throw new IllegalArgumentException("设置长度：n不在有效范围内");
        }
        if (nlen == len)
            return;
        LinkNode<E> p = geti(nlen - 1);//找到序号为nlen-1的结点p
        p.next = null;//将结点p置为尾结点
    }

    public E getElem(int i) {//返回线性表中序号为i的元素
        int len = size();
        if (i < 0 || i > len - 1) {
            throw new IllegalArgumentException("设置长度：n不在有效范围内");
        }
        LinkNode<E> p = geti(i);//找到序号为i的结点p
        return p.data;
    }

    public void SetElem(int i, E e) {//设置序号为i的元素为e
        if (i < 0 || i > size() - 1) {
            throw new IllegalArgumentException("设置长度：n不在有效范围内");
        }
        LinkNode<E> p = geti(i);//找到序号为i的结点p
        p.data = e;
    }

    public int GetNo(E e) {//查找第一个为e的元素的序号
        int j = 0;
        LinkNode<E> p = head.next;
        while (p != null && !p.data.equals(e)) {
            j++;//查找元素e
            p = p.next;
        }
        if (p == null) return -1;//未找到时返回-1
        else return j;//找到后返回其序号
    }

    public void swap(int i, int j) {//交换序号为i和序号j的元素
        LinkNode<E> p = geti(i);
        LinkNode<E> q = geti(j);
        E tmp = p.data;
        p.data = q.data;
        q.data = tmp;
    }

    public void Insert(int i, E e) {//在线性表中序号i的位置上插入元素e
        if (i < 0 || i > size()) {
            throw new IllegalArgumentException("设置长度：n不在有效范围内");
        }
        LinkNode<E> s = new LinkNode<E>(e);//建立新结点s
        LinkNode<E> p = geti(i - 1);//找到序号为i-1的结点p
        s.next = p.next;//在p结点后面插入s结点
        p.next = s;
    }

    public void Delete(int i) {
        if (i < 0 || i > size() - 1) {//参数错误抛出异常
            throw new IllegalArgumentException("设置长度：n不在有效范围内");
        }
        LinkNode<E> p = geti(i - 1);
        p.next = p.next.next;
    }

    public String toString() {//将线性表转化成字符串
        String ans = "";
        LinkNode<E> p = head.next;
        while (p != null) {
            ans += p.data + " ";
            p = p.next;
        }
        return ans;
    }
}

class TestLink {
    public static void main(String[] args) {
        //测试1：数据为整形
        System.out.println("*****测试1****");
        Integer[] a = {1, 2, 3, 4, 5};
        LinkListClass<Integer> L1 = new LinkListClass<>();

        //1,尾插法创建链表
        L1.CreateListR(a);
        System.out.println("L1" + L1);
        System.out.println("l1长度：" + L1.size());
        //2，在末尾添加元素
        L1.Add(10);
        System.out.println("L1" + L1);

        //遍历每个元素
        System.out.println("求每个序号的元素值");
        for (int i = 0; i < L1.size(); i++) {
            System.out.println("  序号" + i + "的元素值：" + L1.getElem(i));
        }
        //重置长度
        System.out.println("重新置长度为5");
        L1.Setsize(5);
        System.out.println("L1" + L1);

        //在指定位置插入元素
        int i = 0;
        Integer x = 20;
        System.out.println("在序号" + i + "位置插入" + x);
        L1.Insert(i, x);
        System.out.println("L1" + L1);

        //删除指定位置的元素
        i = 3;
        System.out.println("删除序号" + i + "的元素");
        L1.Delete(i);
        System.out.println("L1" + L1);

        //替换指定位置的元素的值
        i = 2;
        x = 16;
        System.out.println("设置序号" + i + "的元素值为" + x);
        L1.SetElem(i, x);
        System.out.println("L1" + L1);

        //获取值为5的元素的序号
        x = 5;
        System.out.println("值为" + x + "的元素序号为" + L1.GetNo(x));



    }
}

