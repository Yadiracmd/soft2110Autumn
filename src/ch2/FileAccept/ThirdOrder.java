package ch2.FileAccept;/*
    @Author:***
    @Date:2022/9/11
    @Description：带头结点的循环单链表

*/

public class ThirdOrder<E> {
    LinkNode<E> head;//存放头结点

    public ThirdOrder() {//构造方法
        head = new LinkNode<E>();//创建头结点
        head.next = head;//置为空的循环单链表
    }

    //线性表的基本运算算法


    public void CreateListR(E[] a) {//尾插法：由数组a整体建立单链表
        LinkNode<E> s, t;//
        t = head;//t始终指向尾结点，开始时指向头结点
        for (int i = 0; i < a.length; i++) {//循环建立数据结点s
            s = new LinkNode<E>(a[i]);//新建存放a【i】元素的结点s
            t.next = s;//将s结点插入t结点之后
            t = s;
        }
        t.next = head;//将尾结点的next成员置为null
    }


    public E getElement(int i) {//查找序号为i(0≤i≤n-1)的元素
        int len = size();
        if (i < 0 || i > len - 1) {
            throw new IllegalArgumentException("查找：i不在有效范围内");
        }
        LinkNode<E> p = geti(i);//找到序号为i的结点p
        return p.data;
    }

    public int findAnyElem(E e) {//查找第一个值为x的元素的序号
        int j = 0;
        LinkNode<E> p = head.next;
        while (p != null && !p.data.equals(e)) {
            j++;//查找元素e
            p = p.next;
        }
        if (p == null) return -1;//未找到时返回-1
        else return j;//找到后返回其序号
    }

    public void insertAny(int i, E e) {    //在线性表中序号i位置插入元素e
        if (i < 0 || i > size()) {
            throw new IllegalArgumentException("插入：i不在有效范围内");
        }
        LinkNode<E> s = new LinkNode<E>(e);//建立新结点s
        LinkNode<E> p = geti(i - 1);//找到序号为i-1的结点p
        s.next = p.next;//在p结点后面插入s结点
        p.next = s;
    }

    public void insertFirst(E e) {//插入第一个元素
        LinkNode<E> s;
        s = new LinkNode<E>(e);//新建存放a[i]元素的结点s
        s.next = head.next;//将s结点插入开始结点之前、头结点之后
        head.next = s;
    }

    public void insertFinal(E e) {//插入最后一个元素
        LinkNode<E> p = head;//获取位置
        while (p.next != head) {
            p = p.next;//将next的位置一直往后移
        }
        LinkNode<E> s = new LinkNode<>(e);
        p.next = s;
        p = s;
        p.next = head;
    }

    public void deleteAny(int i) {//在线性表中删除序号i位置的元素
        if (i < 0 || i > size() - 1) {//参数错误抛出异常
            throw new IllegalArgumentException("删除：i不在有效范围内");
        }
        LinkNode<E> p = geti(i - 1);
        p.next = p.next.next;
    }

    public void deleteFirst() {//删除第一个元素
        deleteAny(0);
    }

    public void deleteFinal() {//删除最后一个元素
        LinkNode<E> p = geti(size() - 2);
        p.next = p.next.next;
    }

    public String toString() {//将线性表转化成字符串
        String ans = "{";
        LinkNode<E> p = head.next;
        while (p != head) {
            ans += p.data + " ";
            p = p.next;
        }
        ans += "}";
        return ans;
    }

    public int size() {//求线性表的长度
        LinkNode<E> p = head;
        int cnt = 0;
        while (p.next != head) {//找到尾结点为止
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    private LinkNode<E> geti(int i) {//返回序号为i的结点
        LinkNode<E> p = head;
        int j = -1;
        while (j < i) {
            j++;
            p = p.next;
        }
        return p;
    }
}

class Test05 {
    public static void main(String[] args) {
        ThirdOrder<Integer> list = new ThirdOrder<>();
        Integer[] array = {1, 5, 7, 5, 3, 8};
        int x = 0;
        list.CreateListR(array);
        System.out.println("数据列表：" + list);
        //查找元素
        x = 5;
        System.out.println("在第" + x + "位置的元素是" + list.getElement(x));
        //查找第一个值为 x的元素的序号
        x = 3;
        System.out.print("查找：" + x);
        int ele = list.findAnyElem(x);
        if (ele != -1)
            System.out.println("\t\t找到了：" + x + "在数组" + ele + "的位置");
        else {
            System.out.println("未找到该元素");
        }
        //插入第一个元素
        x = 15;
        list.insertFirst(x);
        System.out.println("插入第一个元素" + x + "->" + list + "容量" + list.size());
        //插入最后一个元素
        x = 20;
        list.insertFinal(x);
        System.out.println("插入最后一个元素" + x + "->" + list + "容量" + list.size());
        //插入第i(0≤i≤n-1)个元素
        x = 4;
        int value = 17;
        list.insertAny(x, value);
        System.out.println("插入第" + x + "个元素" + value + "->" + list + "容量" + list.size());

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

