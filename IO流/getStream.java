package Demo5;

import java.util.*;
import java.util.stream.Stream;

public class getStream {
    List<String> list = new ArrayList<>();
    Stream<String> stream = list.stream();

    Set<String> set = new HashSet<>();
    Stream<String> stream1 = set.stream();

    Map<Integer, String> map = new HashMap<>();
    // 获取键
    Set<Integer> key_set = map.keySet();
    Stream<Integer> stream2 = key_set.stream();
    // 获取值
    Collection<String> value = map.values();
    Stream<String> stream3 = value.stream();
    // 获取键值对的映射关系
    Set<Map.Entry<Integer, String>> entries = map.entrySet();
    Stream<Map.Entry<Integer, String>> stream4 = entries.stream();
    // 数组转化为Stream流
    Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5);

    // 可变参数传递数组
    Integer[] arr = {1, 2, 3, 4, 5};
    Stream<Integer> stream6 = Stream.of(arr);

}
