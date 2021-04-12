/*
Lambda表达式的格式：
一些参数，一个箭头，一段代码
格式： （接口中方法的参数列表）-> {一些重写方法的代码}
 */
public class LambdaDemo {
    public static void main(String[] args) {
        invoke(1, 2, (a, b) -> {return a + b;});
    }

    public static void invoke(int a, int b, Calculate calculate) {
        System.out.println(calculate.cal(a, b));
    }

    public interface Calculate {
        public abstract int cal(int a,int b);

    }
}
