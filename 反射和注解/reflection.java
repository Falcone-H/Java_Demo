package Reflection;

/*
Reflection
反射机制允许程序在执行期借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性及方法
Class c = Class.forName("java.lang.String")

加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（一个类只有一个Class对象）
这个对象就包含了完整的类结构信息

可以通过实例化对象，然后用getClass()方法，得到完整的“包类”名称

获取方式：
（1）若已知具体的类，通过类的class属性获取
    Class c1 = Person.class;
（2）一致某个类的实例，调用该实例的getClass()方法获取Class对象
    Class c2 = person.getClass();
（3）已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取，
    可能抛出ClassNotFoundException
    Class c3 = Class.forName("demo.Student");
（4）内置基本数据类型可以直接用类名.Type
（5）还可以利用ClassLoader


获取对象的属性
c1.getField(String fieldName)   获取特定属性名的public属性
c1.getFields()                  获取所有public属性

c1.getDeclaredField(String fieldName)   获取特定属性名的属性
c1.getDeclaredFields()                  获取所有属性

获取对象的方法
c1.getMethods()         获取本类及其父类的所有public方法
c1.getDeclaredMethods() 获取本类的所有方法

获取对象的构造器
c1.getConstructors();

动态构造对象
c1.newInstance();   实质是调用了类的无参构造方法
也可以使用带参数的构造器来构造一个对象

通过反射调用方法
invoke(对象, 参数值)

Method setName = c1.getMethods("setName", String.class);
setName.invoke(c1.newInstance, "name");


若原方法声明为private，则需要在调用invoke()方法前，需要显示调用方法对象的setAccessible(true)方法
Method, Field, Constructor都有setAccessible()方法，这是启用和禁用安全检查的开关，可以提高反射的效率
 */

public class reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();

        // 通过对象获得
        Class c1 = person.getClass();

        // 通过包名获得
        Class c2 = Class.forName("Reflection.Person");

        // 通过类名.class获得
        Class c3 = Person.class;

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(Student.class.hashCode());
        System.out.println(Teacher.class.hashCode());
    }
}

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        System.out.println("This is Person");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {
    public Student() {
        System.out.println("This is Student");
    }
}

class Teacher extends Person {
    public Teacher() {
        System.out.println("This is Teacher");
    }
}