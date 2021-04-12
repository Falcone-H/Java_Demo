package Demo4;
/*
常用函数式接口：
java.util.function.Supplier<T>接口仅包含一个无参的方法：T get()。用来获取一个泛型参数指定类型的对象数据。
Supplier<T>接口被称之为生产型接口，指定接口的泛型是什么类型，那么接口中的get方法就会生产什么类型的数据。
 */

import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierDemo {
    public static int getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(100);
        arrayList.add(-2);
        arrayList.add(101);
        System.out.println(getMax(() -> {
            int maxv = 0;
            for(Integer i : arrayList) {
                if(i > maxv)
                    maxv = i;
            }
            return maxv;
        }));
    }
}
