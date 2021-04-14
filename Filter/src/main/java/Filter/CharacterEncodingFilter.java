package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("enter the Filter");     // web服务器启动时，就开始初始化
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
//        System.out.println("change the charset");
        chain.doFilter(request, response);  // 让请求和返回继续正常流程，如果没有这行代码，请求和返回会被拦截停止
    }

    @Override
    public void destroy() {
        System.out.println("leave the Filter");
    }
}
