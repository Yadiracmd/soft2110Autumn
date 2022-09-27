package ch1.page26and27;

import java.util.Iterator;
import java.util.TreeSet;

public class Diedaiqi {
    public static void main(String[] args) {
        TreeSet<Integer> myset=new TreeSet<>();//定义集合对象myset
        myset.add(3);
        myset.add(1);
        myset.add(4);
        myset.add(2);
        myset.add(5);
        Iterator<Integer> it=myset.iterator();//定义myset迭代器
        while (it.hasNext())//顺序遍历
            System.out.print(it.next()+" ");//输出：1 2 3 4 5
        System.out.println();
    }
}
