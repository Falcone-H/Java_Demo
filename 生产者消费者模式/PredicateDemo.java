package Demo4;

import java.util.function.Predicate;

/*
java.util.function.Predicate<T>
Predicate接口中包含一个抽象方法：
boolean test(T t) : 用来对某种数据类型的数据进行判断，结果返回一个boolean值
结果：符合条件，返回true
    不符合，返回false

and, or, negate
 */
public class PredicateDemo {
    public static boolean method(String s, Predicate<String> predicate) {
        return predicate.test(s);
    }

    public static boolean method2(String s, Predicate<String> pre1, Predicate<String> pre2) {
        //return pre1.test(s) && pre2.test(s);
        return pre1.and(pre2).test(s);
    }

    public static void main(String[] args) {
        boolean flag = method("aaa", (s) -> {
            return s.equals("bbb");
        });
        System.out.println(flag);
        flag = method2("bbb", (s) -> {
            return s.length() > 2;
        }, (s) -> {
            return s.contains("b");
        });
        System.out.println(flag);
    }
}
