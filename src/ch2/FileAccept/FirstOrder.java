package ch2.FileAccept;/*
    @Author:***
    @Date:2022/9/9
    @Description：IntelliJ IDEA
*/

public class FirstOrder<E> {//顺序表
    final int initcapacity = 10;    //顺序表的初始容量(常量)
    public E[] data;                //存放顺序表中元素
    public int size;                //存放顺序表的长度
    private int capacity;           //存放顺序表的容量

    public FirstOrder() {  //构造方法，实现data和length的初始化
        data = (E[]) new Object[initcapacity];  //强制转换为E类型数组
        capacity = initcapacity;
        size = 0;
    }

    public void createList(E[] a) { //由a整体建立顺序表
        size = 0;
        for (E e : a) {
            if (size == capacity) { //出现上溢出时
                updateCapacity(2 * size);   //扩大容量
            }
            data[size] = e;
            size++;     //添加的元素个数增加1
        }
    }

    private void updateCapacity(int newCapacity) {  //改变顺序表的容量为newCapacity
        E[] newData = (E[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        capacity = newCapacity; //设置新容量
        data = newData;         //仍由data标识数组
    }

    public int size() { // 求线性表长度
        return size;
    }


    public E getElement(int i) {//查找序号为i(0≤i≤n-1)的元素
        if (i < 0 || i > size - 1) {
            throw new IllegalArgumentException("查找:位置i不在有效范围内");
        }
        return data[i];
    }

    public Object findAnyElem(int x) {//查找第一个值为x的元素的序号
        for (int i = 0; i < size; i++) {
            if (data[i] == (Object) x) {
                return i;
            }
        }
        return false;
    }

    public void insertAny(int i, E e) {    //在线性表中序号i位置插入元素e
        if (i < 0 || i > size) {        //参数错误抛出异常
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        }
        if (size == capacity) {         //满时倍增容量
            updateCapacity(2 * size);
        }
        for (int j = size; j > i; j--) {    //data[i]及后面元素后移一个位置
            data[j] = data[j - 1];
        }
        data[i] = e;    //插入元素e
        size++;         //顺序表长度增1
    }

    public void insertFirst(E e) {//插入第一个元素
        insertAny(0, e);
    }

    public void insertFinal(E e) {//插入最后一个元素
        insertAny(size, e);
    }

    public void deleteAny(int i) {         //在线性表中删除序号i位置的元素
        if (i < 0 || i > size - 1) {    //参数错误抛出异常
            throw new IllegalArgumentException("删除:位置i不在有效范围内");
        }
        for (int j = i; j < size - 1; j++) {    //将data[i]之后的元素前移一个位置
            data[j] = data[j + 1];
        }
        size--; //顺序表长度减1
        if (capacity > initcapacity && size == capacity / 4) {
            updateCapacity(capacity / 2);   //满足要求容量减半
        }
    }

    public void deleteFirst() {
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--; //顺序表长度减1
        if (capacity > initcapacity && size == capacity / 4) {
            updateCapacity(capacity / 2);   //满足要求容量减半
        }
    }

    public void deleteFinal() {
        size--; //顺序表长度减1
        if (capacity > initcapacity && size == capacity / 4) {
            updateCapacity(capacity / 2);   //满足要求容量减半
        }
    }


    public String toString() {    //将线性表转换为字符串
        String ans = "{";
        for (int i = 0; i < size; i++) {
            ans += data[i].toString() + " ";
        }
        ans+="}";
        return ans;
    }

}

class Test {
    public static void main(String[] args) {
        FirstOrder<Integer> list = new FirstOrder<>();
        Integer[] array = {1, 5, 7, 5, 3, 8};
        int x = 0;
        list.createList(array);
        System.out.println("数据列表：" + list);
        //查找元素
        x = 5;
        System.out.println("在第"+x+"位置的元素是"+list.getElement(x));
        //查找第一个值为 x的元素的序号
        x=3;
        System.out.print("查找：" + x);
        Object ele = list.findAnyElem(x);
        if (ele.equals(true))
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