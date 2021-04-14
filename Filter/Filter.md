# Filter

过滤器：用来过滤网站的数据

如：

* 处理中文乱码
* 登录验证
* 处理垃圾请求



## 一、导入依赖

```xml
<dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>javax.servlet.jsp-api</artifactId>
      <version>2.3.3</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>javax.servlet.jsp.jstl</groupId>
      <artifactId>jstl-api</artifactId>
      <version>1.2</version>
    </dependency>
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
</dependency>
```



## 二、编写过滤器

比如要创建一个处理字符编码的Filter

```java
import javax.servlet.*;
import java.io.IOException;
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
    }
    @Override
    public void destroy() {
    }
}
```

**注意：** 导入的是`javax.servlet.Filter`接口



## 三、配置拦截路径

加上注解`@WebFilter(urlPatterns = "/*")`

```java
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
        chain.doFilter(request, response);  // 让请求和返回继续正常流程，如果没有这行代码，请求和返回会被拦截停止
    }
    @Override
    public void destroy() {
        System.out.println("leave the Filter");
    }
}
```


## Filter 登录拦截
拒绝没有权限或者没有登录的用户访问页面
```java
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String username = (String) req.getSession().getAttribute("username");
        if(username == null) {
            resp.sendRedirect("/error.jsp");
        }
        chain.doFilter(request, response);
}

```
