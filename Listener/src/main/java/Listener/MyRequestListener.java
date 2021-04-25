package Listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("请求销毁...");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("创建请求...");
    }
}
