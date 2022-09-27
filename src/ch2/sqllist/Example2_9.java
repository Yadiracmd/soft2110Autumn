package ch2.sqllist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example2_9 {
    public static void main(String[] args) {
        List<Stud> L = new ArrayList<Stud>();
        L.add(new Stud("John", 18));
        L.add(new Stud("Mary", 17));
        L.add(new Stud("Smith", 20));
        L.add(new Stud("Tom", 18));
        System.out.println("初始序列：\n" + L);
        Collections.sort(L);//排序方法1
        System.out.println("按年龄递增排序：\n" + L);
        Collections.sort(L, new Comparator<Stud>() {//排序方法2
            @Override
            public int compare(Stud o1, Stud o2) {//用于按姓名递增排序
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("按姓名递增排序：\n" + L);
        L.sort(Comparator.comparing(Stud::getName).reversed());//排序方法3
        System.out.println("按姓名递减排序：\n" + L);
    }

    static class Stud implements Comparable<Stud> {
        private final String name;//姓名
        private final Integer age;//年龄

        public Stud(String na, int ag) {//构造方法
            name = na;
            age = ag;
        }

        public String toString() {
            String ans;
            ans = "[" + name + "," + age + "]";
            return ans;
        }

        public String getName() {//取name的属性
            return name;
        }

        @Override
        public int compareTo(Stud o) {//用于按age递增排序
            return this.age.compareTo(o.age);
        }
    }
}
