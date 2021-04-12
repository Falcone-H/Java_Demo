package Demo4;


import java.util.function.Consumer;

/*
java.util.function.Consumer<T>接口与Supplier相反
用于消费数据，其数据类型由泛型决定
Consumer接口中包含抽象方法void accept(T t)，以为消费一个指定泛型的数据

andThen()，需要两个Consumer接口，可以把两个Consumer接口组合到一起，对数据进行消费
con1.andTHen(con2).accept(s)    谁写前面，谁先消费

Consumer接口是一个消费型的接口，泛型执行什么类型，就可以使用accept方法消费什么类型的数据
至于具体怎么消费，需要自定义操作
 */
public class ConsumerDemo {
    public static void method(String name, Consumer<String> con1, Consumer<String> con2) {
        con1.andThen(con2).accept(name);
    }

    public static void main(String[] args) {
        String arr[] = {"aaa,1","bbb,2","ccc,3"};
        for(String s : arr) {
            method(s, (str) -> {
                System.out.print("name: " + str.split(",")[0]);
            }, (str) -> {
                System.out.println(" sex: " + str.split(",")[1]);
            });
        }
    }
}
