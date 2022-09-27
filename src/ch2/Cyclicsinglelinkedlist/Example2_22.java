package ch2.Cyclicsinglelinkedlist;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

import java.io.FileNotFoundException;

class Child {//小孩结点类型
    int no;//小孩编号
    Child next;//指向下一个结点指针

    public Child(int nol) {//重载构造方法
        no = nol;
        next = null;
    }
}

class Joseph {//求解Joseph问题类
    int n, m;
    Child first;//首结点指针

    public Joseph(int n1, int m1) {//构造方法建立n1个结点的循环单链表
        Child p, t;//t指向新建循环单链表的尾结点
        n = n1;
        m = m1;//设置数据成员值
        first = new Child(1);//先建立no为1的首结点
        t = first;
        for (int i = 2; i <= n; i++) {
            p = new Child(i);//建立一个编号为i的新结点p
            t.next = p;
            t = p;//将p结点链接到末尾
        }
        t.next = first;//构成一个首结点为first的循环单链表
    }

    public String Jsequence() {//求解Joseph序列
        String ans = "";
        int i, j;
        Child p, q;
        for (i = 1; i <= n; i++) {//共n个小孩出列
            p = first;
            j = 1;
            while (j < m - 1) {//从first结点开始报数，报到第m-1个结点
                j++;//报数递增
                p = p.next;//报到下一个结点
            }
            q = p.next;//q指向第m个结点
            ans += q.no + " ";//该结点的小孩出列
            p.next = q.next;//删除q结点
            first = p.next;//从下一个结点重新开始
        }
        return ans;
    }
}

public class Example2_22 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("********测试1***********");
        int n = 6, m = 3;
        Joseph L = new Joseph(n, m);
        System.out.println("n=" + n + ",m=" + m + "的Joseph序列");
        System.out.println(L.Jsequence());
        System.out.println("********测试2***********");
        n = 8;
        m = 4;
        L = new Joseph(n, m);
        System.out.println("n=" + n + ",m=" + m + "的Joseph序列");
        System.out.println(L.Jsequence());
    }
}