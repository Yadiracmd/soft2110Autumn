package ch2.Cyclicsinglelinkedlist;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_21 {
    static CLinkListClass<Integer> Comb(CLinkListClass<Integer> A, CLinkListClass<Integer> B) {
        LinkNode<Integer> ta = A.head, tb = B.head;
        while (ta.next != A.head)//ta指向A的尾结点
            ta = ta.next;
        ta.next = B.head.next;//A和B尾首相连
        while (ta.next != B.head)//tb指向B的尾结点
            tb = tb.next;
        tb.next = A.head;//ta的next指向A的头结点
        return A;
    }

}