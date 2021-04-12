package Annotation;

/*
注解
可以被其他程序读取

内置注解
@Override   重写注解
@Deprecated 废弃注解，可以使用，但不推荐使用
@SupressWarnings() 抑制警告，用来抑制编译时的警告信息

元注解
作用：负责注解其他注解
@Target()   描述注解的使用范围（即：被描述的注解可以使用在什么地方）
@Retention  表示需要在什么级别保存该注释信息，用于描述注解的生命周期，表示注解在什么地方有效（SOURCE < CLASS < RUNTIME）（源码、类、运行时）
@Documented 说明该注解将被生成在JavaDoc中
@Inherited  说明子类可以继承父类中的该注解

使用@interface自定义注解时，自动继承java.lang.annotation.Annotation接口
格式：
@interface 注解名 { 参数类型 参数名() default 默认值; }
其中每一个方法实际上是声明了一个配置参数，方法的名称就是参数的名称
返回值类型就是参数的类型，返回值只能是基本类型、Class、String、enum
可以通过default来声明参数的默认值

 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class annotation {
    @MyInnotation
    public void method() {

    }
}

// 定义注解
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyInnotation {
    String name() default "";
    String[] names() default {"123", "456"};
}