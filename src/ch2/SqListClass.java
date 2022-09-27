package ch2;

public class SqListClass<E> {       //顺序表泛型类
    final int initcapacity = 10;    //顺序表的初始容量(常量)
    public E[] data;                //存放顺序表中元素
    public int size;                //存放顺序表的长度
    private int capacity;           //存放顺序表的容量

    public SqListClass() {  //构造方法，实现data和length的初始化
        data = (E[]) new Object[initcapacity];  //强制转换为E类型数组
        capacity = initcapacity;
        size = 0;
    }

    //线性表的基本运算算法
    public void CreateList(E[] a) { //由a整体建立顺序表
        size = 0;
        for (E e : a) {
            if (size == capacity) { //出现上溢出时
                updateCapacity(2 * size);   //扩大容量
            }
            data[size] = e;
            size++;     //添加的元素个数增加1
        }
    }

    public void Add(E e) {      //在线性表的末尾添加一个元素e
        if (size == capacity) { //顺序表空间满时倍增容量
            updateCapacity(2 * size);
        }
        data[size] = e;
        size++; //长度增1
    }

    public int size() { // 求线性表长度
        return size;
    }

    public void Setsize(int nlen) {    //设置线性表的长度
        if (nlen < 0 || nlen > size) {
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        }
        size = nlen;
    }

    public E GetElem(int i) {    //返回线性表中序号为i的元素
        if (i < 0 || i > size - 1) {
            throw new IllegalArgumentException("查找:位置i不在有效范围内");
        }
        return (E) data[i];
    }

    public void SetElem(int i, E e) {    //设置序号i的元素为e
        if (i < 0 || i > size - 1) {
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        }
        data[i] = e;
    }

    public int GetNo(E e) { //查找第一个为e的元素的序号
        int i = 0;
        while (i < size && !data[i].equals(e)) {
            i++;            //查找元素e
        }
        if (i >= size) {    //未找到时返回-1
            return -1;
        } else {
            return i;       //找到后返回其序号
        }
    }

    public void swap(int i, int j) {    //交换data[i]和data[j]
        E tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public void Insert(int i, E e) {    //在线性表中序号i位置插入元素e
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

    public void Delete(int i) {         //在线性表中删除序号i位置的元素
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

    @Override
    public String toString() {    //将线性表转换为字符串
        String ans = "";
        for (int i = 0; i < size; i++) {
            ans += data[i].toString() + " ";
        }
        return ans;
    }

    private void updateCapacity(int newCapacity) {  //改变顺序表的容量为newCapacity
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i <size; i++) {
            newData[i] = data[i];
        }
        capacity = newCapacity; //设置新容量
        data = newData;         //仍由data标识数组
    }

}
