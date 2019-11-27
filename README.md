## A simple APT
例子只是展示了如何实现自定义注解处理器，并处理自定义注解，
具体用法可以参考《疯狂Java讲义(第3版)》14.4章节的内容或其他博客文章

## 实现步骤
1. 新建一个简单的maven项目，如custom-annotation-processor
2. 新建注解类，如top.hzfq.annotation.CustomAnnotation，指定Retention和Target
3. 新建注解处理器类，如top.hzfq.annotation.processor.CustomProcessor，
需要继承javax.annotation.processing.AbstractProcessor类并实现process()方法
4. 在resources目录下新建META-INF/services/avax.annotation.processing.Processor文件，
文件内容为3中注解处理器的全类名，若添加多个注解处理器，则每个处理器占一行
5. 编译、打包和安装，在pom.xml文件中添加maven-compiler-plugin插件，并指定proc属性为none，
在项目根目录下运行mvn clean compile package install完成剩余操作
6. 使用注解，在需要使用自定义注解的项目中，引入jar包(pom依赖或lib库)，
在需要使用注解的代码处添加注解，使用注解的方法或类被调用并编译运行后可以看到注解的效果，
本例中将生成D:/temp/anno.txt文件
