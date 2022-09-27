package ch1.page24and25;

class Person{
    public String name;
    public String gender;
    public void disp(){
        System.out.print(",姓名:"+name+",性别:"+gender);
    }
}
class Teacher extends Person{
    public String no;//编号
    public String job;//职称
    public void Teaching(){//授课方法
        System.out.println("给学生授课");
    }
    public void research(){//科研方法
        System.out.println("做科研");
    }
    public void disp(){//输出教师信息,重写Person的disp()方法
        System.out.println("输出一个教师信息");
        System.out.print("  编号:"+no);
        super.disp();//调用父类的disp()方法
        System.out.println(",职称:"+job);
    }
}
class Student extends Person{//学生类从Person继承
    public String id;//学号
    public String profession;//专业
    public double fraction;//分数
    public void Learning(){//上课方式
        System.out.println("上课");
    }
    public void disp(){//输出学生信息,重写Person的disp()方法
        System.out.println("输出一个学生信息");
        System.out.print("  学生:"+id);
        super.disp();//调用父类的disp()方法
        System.out.println(",专业:"+profession+",分数"+fraction);
    }
}

public class N {
    public static void main(String[] args) {
        Teacher t=new Teacher();
        t.no="0020012";t.name="王华";
        t.gender="女";t.job="副教授";
        t.disp();
        Student s=new Student();
        s.id="2019002";s.name="陈晶";
        s.gender="男";s.profession="计算机";
        s.fraction=86.5;
        s.disp();
    }
}

