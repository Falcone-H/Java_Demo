package Demo7;
/*
数据库连接池
概念：
    一个容器（集合），存放数据库连接的容器
    当系统初始化好以后，容器被创建，容器中会申请一些连接对象，当用户来访问数据库时，
    从容器中获取连接对象，用户访问完之后，会将连接对象归还给容器。
好处：
    1、节约资源
    2、访问高效
实现：
    1、标准接口
        interface DataSource
    2、方法
        getConnection()
    3、一般不去手动实现，有数据库厂商实现
        数据库连接池技术：C3P0、Druid
    4、先导入jar包
    5、定义配置文件 c3p0.properties 或者 c3p0-config.xml
       路径：默认在src目录下

 */
public class ConPool {
}
