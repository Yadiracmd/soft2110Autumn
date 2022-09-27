package ch2.Cyclicsinglelinkedlist;/*
    @Author:***
    @Date:2022/9/10
    @Description：IntelliJ IDEA
*/

public class Example2_20 {
    public static int Count(CLinkListClass<Integer> L,Integer x){
        int cnt=0;//cnt置为0
        LinkNode<Integer> p=L.head.next;//p指向首结点
        while (p != L.head) {//遍历循环单链表
             if(p.data==x)
                cnt++;//找到一个值为x的结点cnt增1
            p=p.next;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Integer[] number={1,5,8,9,71,3,5,5};
        CLinkListClass<Integer> ls = new CLinkListClass<>();
        ls.CreateListR(number);
        System.out.println(ls+"长度："+ls.size());
        System.out.println("x的个数");
        int nb=Count(ls,5);
        System.out.println(nb);
    }

}
