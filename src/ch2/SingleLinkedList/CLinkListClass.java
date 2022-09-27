package ch2.SingleLinkedList;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/



public class CLinkListClass<E> {//循环单链表泛型类
    LinkNode<E> head;//存放头结点
    public CLinkListClass(){//构造方法
        head=new LinkNode<E>();//创造头结点
        head.next=head;//置为空的循环单链表
    }
    //线性表的基本运算算法
}
