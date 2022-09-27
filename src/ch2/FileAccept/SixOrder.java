package ch2.FileAccept;/*
    @Author:***
    @Date:2022/9/11
    @Description：IntelliJ IDEA
*/

public class SixOrder<E> {
    DLinkNode<E> dhead;//存放头结点

    public SixOrder() {//构造方法
        dhead = new DLinkNode<E>();//创建头结点
        dhead.prior = dhead;
        dhead.next = dhead;
    }

    public void CreateListF(E[] a) {//头插法：用数组a整体建立双链表
        DLinkNode<E> s;
        for (int i = 0; i < a.length; i++) {//循环建立数据结点s
            s = new DLinkNode<E>(a[i]);//新建存放a[i]元素的结点s，将其插入表头
            s.next = dhead.next;//修改s结点的next成员
            if (dhead.next != dhead)//修改头结点的非空后继结点的prior成员
                dhead.next.prior = s;
            dhead.next = s;//修改头结点的next成员
            s.prior = dhead;//修改s结点的prior成员
        }
    }

    public void CreateListR(E[] a) {//尾插法：由数组a整体建立双链表
        DLinkNode<E> s, t;
        t = dhead;//t始终指向尾结点，开始时指向头结点
        for (int i = 0; i < a.length; i++) {//循环建立数据结点s
            s = new DLinkNode<E>(a[i]);//新建存放a【i】元素的结点s
            t.next = s;//将s结点插入t结点之后
            s.prior = t;
            t = s;
        }
        t.next = dhead;//将尾结点的next成员设置为dhead
    }

    public E getElement(int i) {//查找序号为i(0≤i≤n-1)的元素
        int len = size();
        if (i < 0 || i > len - 1) {
            throw new IllegalArgumentException("查找元素不在范围内");
        }
        DLinkNode<E> p = geti(i);//找到序号为i的结点p
        return p.data;
    }

    public int findAnyElem(E e) {//查找第一个值为x的元素的序号
        int j = 0;
        DLinkNode<E> p = dhead.next;
        while (p != dhead && !p.data.equals(e)) {
            j++;//查找元素e
            p = p.next;
        }
        if (p == dhead) return -1;//未找到时返回-1
        else return j;//找到后返回其序号
    }

    public void insertAny(int i, E e) {    //在线性表中序号i位置插入元素e
        if (i < 0 || i > size())
            throw new IllegalArgumentException("插入：位置i不在有效范围内");//参数错误抛出异常
        DLinkNode<E> s = new DLinkNode<E>(e);//建立新节点s
        DLinkNode<E> p = geti(i - 1);//找到序号为i-1的结点p，在其后插入s结点
        s.next = p.next;//修改s结点的next成员
        if (p.next != dhead) {//修改p结点的非空后继结点的prior成员
            p.next.prior = s;
        }
        p.next = s;//修改p结点的next成员
        s.prior = p;//修改s结点的prior成员
    }

    public void insertFirst(E e) {//插入第一个元素
        insertAny(0, e);
    }

    public void insertFinal(E e) {//插入最后一个元素
        DLinkNode<E> s, t;
        t = dhead;
        s = new DLinkNode<E>(e);
        while (t.next != dhead) {
            t = t.next;
        }
        t.next = s;
        s.prior = t;
        t = s;
        t.next = dhead;

    }

    public void deleteAny(int i) {//在线性表中删除序号i位置的元素
        if (i < 0 || i > size() - 1)//参数错误抛出异常
            throw new IllegalArgumentException("删除：位置i不在有效范围内");
        DLinkNode<E> p = geti(i);//找到序号为i的结点p，删除该结点
        if (p.next != dhead)//修改p结点的非空后继结点的perior成员
            p.next.prior = p.prior;
        p.prior.next = p.next;//修改p结点的前驱结点的next成员
    }

    public void deleteFirst() {//删除第一个元素
        deleteAny(0);
    }

    public void deleteFinal() {//删除最后一个元素
        DLinkNode<E> p=geti(size()-1);
        if(p.next!=dhead)
            p.next.prior=p.prior;
        p.prior.next=p.next;

    }


    ///以下的代码同LinkListClass,只需把head改成dhead
    public int size() {//求线性表的长度
        DLinkNode<E> p = dhead;
        int cnt = 0;
        while (p.next != dhead) {//找到尾结点为止
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    private DLinkNode<E> geti(int i) {//返回序号为i的结点
        DLinkNode<E> p = dhead;
        int j = -1;
        while (j < i) {
            j++;
            p = p.next;
        }
        return p;
    }


    public String toString() {//将线性表转化成字符串
        String ans = "{";
        DLinkNode<E> p = dhead.next;
        while (p != dhead) {
            ans += p.data + " ";
            p = p.next;
        }
        ans += "}";
        return ans;
    }
}



class test6{
    public static void main(String[] args) {
        SixOrder<Integer> list = new SixOrder<>();
        Integer[] array = {1, 5, 7, 5, 3, 8};
        int x = 0;
        list.CreateListR(array);
        System.out.println("数据列表：" + list);
        //查找元素
        x = 5;
        System.out.println("在第"+x+"位置的元素是"+list.getElement(x));
        //查找第一个值为 x的元素的序号
        x=3;
        System.out.print("查找：" + x);
        int ele = list.findAnyElem(x);
        if (ele != -1)
            System.out.println("\t\t找到了：" + x + "在数组" + ele + "的位置");
        else {
            System.out.println("未找到该元素");
        }
        //插入第一个元素
        x=15;
        list.insertFirst(x);
        System.out.println("插入第一个元素"+x +"->"+ list + "容量" + list.size());
        //插入最后一个元素
        x=20;
        list.insertFinal(x);
        System.out.println("插入最后一个元素"+x+"->" + list + "容量" + list.size());
        //插入第i(0≤i≤n-1)个元素
        x = 4;
        int value=17;
        list.insertAny(x, value);
        System.out.println("插入第" + x +"个元素"+value+ "->" + list + "容量" + list.size());

        //删除第一个元素
        list.deleteFirst();
        System.out.println("删除第一个元素->" + list + "容量" + list.size());
        //删除最后一个元素
        list.deleteFinal();
        System.out.println("删除最后一个元素->" + list + "容量" + list.size());
        //删除第i(0≤i≤n-1)个元素
        x = 5;
        list.deleteAny(x);
        System.out.println("删除第" + x + "个元素->" + list + "容量" + list.size());
    }
}

