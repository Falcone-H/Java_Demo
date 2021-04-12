package Demo3;

// 函数式接口：有且仅有一个抽象方法的接口（Lambda）
// 语法糖：指使用方便，但原理不变的代码语法。例如for-each语法和迭代器。
//    从应用层面来讲，Lambda可以被当作匿名内部类的”语法糖“，但二者在原理上式不同的

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 函数式接口的使用，一般作为方法的参数和返回值
public class LamdbaDemo {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("abc");
        arrayList.add("bcde");
        arrayList.add("cdeef");
        Collections.sort(arrayList, (o1, o2) -> o1.length() - o2.length());
        for(String s : arrayList) {
            System.out.println(s);
        }
    }
}
