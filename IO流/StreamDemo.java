package Demo5;

import java.util.ArrayList;
import java.util.List;
/*
获取流的两种方式：
1、所有的Collection集合都可以通过stream默认方法获取流
    default Stream<E> stream()
2、Stream接口的静态方法of可以获取数组对应的流
    static <T> Stream<T> of (T ... values)
*/

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbbbb");
        list.add("ccccccccccc");
        list.stream()
                .filter(name -> name.startsWith("b"))
                .filter(name -> name.length() > 4)
                .forEach(name -> System.out.println(name));
    }

}
