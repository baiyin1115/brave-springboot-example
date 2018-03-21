## spring boot  brave example

### 这个是通过brave接入到zipkin的例子  写brave的哥们只给了spring mvc怎么接入的例子，用不到springboot的项目中。
### 这个例子只是根据他的项目做的一些小改造。

### 原始项目地址见：https://github.com/openzipkin/brave-webmvc-example

### zipkin基础知识：http://www.cnblogs.com/java-zhao/p/5835545.html

### zipkin官网：https://zipkin.io/pages/quickstart.html

通过以下命令，把zipkin下下来，直接运行就可以测试。

wget -O zipkin.jar 'https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec'
java -jar zipkin.jar
