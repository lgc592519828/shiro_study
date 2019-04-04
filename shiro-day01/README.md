# shiro-day01

## ssm框架集成shiro框架

* 提供配置文件  
   web.xml 、spring-shiro-web、ehcache以及log等集成。
* web.xml中filter-name 为什么一定要与spring-shiro-web中过滤器id一致呢?  
   深入源码解析  
   解决方案写在自己的blog中  
   相关连接 ：
   
   
 * 记录遇到的问题  
   1. org.springframework.web.context.ContextLoaderListener 异常    
   ```
   Error configuring application listener of class org.springframework.web.context.ContextLoaderListener     
   java.lang.ClassNotFoundException: org.springframework.web.context.ContextLoaderListener  
   ```  
   解决方案写在自己的blog中  
   相关连接 ：https://blog.csdn.net/lgc592519828/article/details/88581752  
   
   2. spring 集成 shiro时遇到shiroFilter Bean加载异常  
   ```
   org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'shiroFilter' is defined  
   ```  
   解决方案写在自己的blog中  
   相关连接 ：https://blog.csdn.net/lgc592519828/article/details/88582695  

