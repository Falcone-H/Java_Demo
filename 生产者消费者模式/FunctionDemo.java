package Demo4;
/*
java.util.function.Function<T,R> 接口用来根据一个类型的数据得到另一个类型的数据，前者称之为前置条件，后者称之为后置条件
最主要的抽象方法： R apply(T t)，根据类型T的参数获取类型R的结构
andThen
 */

import java.util.function.Function;

public class FunctionDemo {
    public static void method(String s, Function<String, Integer> func) {
        Integer num = func.apply(s);
        System.out.println(num);
    }
    public static void main(String args[]) {
        method("1234", (str) -> {
            return Integer.parseInt(str);
        });
    }

}
