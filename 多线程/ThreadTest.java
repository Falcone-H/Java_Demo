import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
线程池：一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁创建线程对象的操作，无需反复创建线程而消耗过多的资源
使用：程序启动时，创建多个线程，保存到一个集合中，当要使用时再取出，remove()
    当使用完毕之后，归还线程到线程池，add()
创建：java.util.concurrent.Executors ---> static ExecutorService newFixedThreadPool(int nThreads)
    返回 ExecutorServive 接口的实现类对象
使用步骤：
1、创建线程池的工厂类Executor提供的方法newFixedThreadPool()，生产一个指定线程数量的线程池
2、创建一个类，实现Runnable接口，重写run()方法
3、调用ExecutorService中的方法submit()，传递线程任务（实现类），开启线程，执行run()方法
4、调用ExecutorService中的方法shutdown()，销毁线程池
 */
public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new Person());
        service.submit(new Person());
        service.submit(new Person());
        service.shutdown();
    }
}
