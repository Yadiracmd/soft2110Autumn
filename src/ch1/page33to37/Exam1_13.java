package ch1.page33to37;

class Set <E>{//集合泛型类
    final int MaxSize=100;//集合中最多元素个数
    E[] data;//存放集合元素
    int size;
    public Set(){//构造方阿飞
        data= (E[]) new Object[MaxSize];//强制转换为E类型数组
        size=0;
    }

    public int getsize(){//返回集合长度
        return size;
    }
    public E get(int i){//返回集合的第i歌元素
        return (E) data[i];
    }
    public boolean IsIn(E e){//判断e是否在集合中
        for (int i = 0; i < size; i++)
         if(data[i]==e)
             return true;
        return false;
    }
    public boolean add(E e){//将元素e添加到集合中
        if (IsIn(e)) return false;//元素一直在集合中返回false
        else {//否则插入末尾并返回true
            data[size]=e;
            size++;
            return true;
        }
    }
    public boolean delete(E e){//从集合中删除元素e
        int i=0;
        while (i<size&&data[i]!=e)i++;
        if(i>=size) return false;//未找到元素e返回false
        for (int j = i+1; j < size; j++) {
            data[j-1]=data[j];
        }
        size--;
        return true;//成功删除元素e返回true
    }
    public void display(){//输出集合中的元素
        for (int i = 0; i < size; i++) {
            if(i==0) System.out.print(data[i]);
            else System.out.print(" "+data[i]);
        }
        System.out.println();
    }
}
class TwoSet<E>{
    public Set<E> Union (Set<E> s1,Set<E> s2){//求s3=s1并s2
        Set<E> s3=new Set<E>();
        for (int i = 0; i < s1.getsize(); i++) {//将集合s1中所有元素复制到s3中
            s3.add(s1.get(i));
        }
        for (int i = 0; i < s2.getsize(); i++) {//将s2中不在是s1中出现的元素复制到s3中
            if(!s1.IsIn(s2.get(i)))
                s3.add(s2.get(i));
        }
        return s3;//返回s3
    }
    public Set<E> Intersection(Set<E> s1,Set<E> s2){//求s3=s1交s2
        Set<E> s3=new Set<E>();
        for (int i = 0; i < s1.getsize(); i++) {//将s1中出现在s2中的元素复制到s3中
            if(s2.IsIn(s1.get(i)))
                s3.add(s1.get(i));
        }
        return s3;//返回s3
    }
    public Set<E> Different(Set<E> s1,Set<E> s2){//求s3=s1-s2
        Set<E> s3=new Set<E>();
        for (int i = 0; i < s1.getsize(); i++) {
            if(!s2.IsIn(s1.get(i)))
                s3.add(s1.get(i));
        }
        return s3;//返回s3
    }
}
public class Exam1_13{
    public static void main(String[] args) {
        Set<Integer> s1,s2,s3,s4,s5;
        TwoSet<Integer> t=new TwoSet<Integer>();
        s1=new Set<Integer>();
        s1.add(1);
        s1.add(4);
        s1.add(2);
        s1.add(6);
        s1.add(8);
        System.out.print("集合s1:");
        s1.display();
        s2=new Set<Integer>();
        s2.add(2);
        s2.add(5);
        s2.add(3);
        s2.add(6);
        System.out.print("集合s2：");
        s2.display();
        System.out.println("集合s1和s2的并集->s3");
        s3=t.Union(s1,s2);
        System.out.print("集合s3:");s3.display();
        System.out.println("集合s1和s2的差集->s4");
        s4=t.Different(s1,s2);
        System.out.print("集合s4：");s4.display();
        System.out.println("集合s1和s2的交集->s5");
        s5=t.Intersection(s1,s2);
        System.out.print("集合s5：");s5.display();
    }
}