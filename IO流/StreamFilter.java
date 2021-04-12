package Demo5;

import java.util.stream.Stream;
/*
filter: 用于对Stream流中的数据进行过滤
Stream<T> filter(Predicate<? super T> predicate);
filter方法的参数Predicate是一个函数式接口，可以用Lambda表达式
 */

/*
Stream流属于管道流，只能被消费一次，
第一个Stream流调用完方法之后，数据就会流转到下一个Stream上
而这时第一个Stream流使用完毕，会自动关闭，因此不能再调用其他方法
 */

public class StreamFilter {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三丰", "张无忌", "张老六", "郭靖");
        Stream<String> stream1 = stream.filter((name) -> name.startsWith("张"));
        stream1.forEach((name) -> System.out.println(name));
    }
}
