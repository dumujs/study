# springboot项目配置
## 各种配置方式优先级
    命令行参数 > java系统属性 > application.properties > application.yml > application.yaml
## 属性配置格式
    1 java系统属性
        -Dserver.port=9000
    2 命令行参数
        --server.port=10010
    3 application.properties 全属性路劲书写方式
        server.port=8080
    4 application.yml 层级展示
        server:
            port: 8001
    5 application.yaml
        server:
            port: 8001
    

## java系统属性和命令行参数jar包测试
    1 执行maven的package打包
        项目打包必须插件spring-boot-maven-plugin(官网骨架创建项目会自动添加)
    2 java -Dserver.port=9000 -jar 名称.jar --server.port=10010
## springboot项目配置项自动注入成员变量
```properties
        # file: application.properties
        # 自定义阿里云oss配置
        aliyun.oss.endpoint=https://oss-cn-beijing.aliyuncs.com
        aliyun.oss.accessKeyId=***
        aliyun.oss.accessKeySecret=***
        aliyun.oss.bucketName=***
```
    1. @Value("${属性全路径}") 为指定成员变量注入配置属性值
```java
        // file: AliOssProperties.java
        @Data
        @Component
        public class AliOssProperties {
            @Value("${aliyun.oss.endpoint}")
            private String endpoint;
            @Value("${aliyun.oss.accessKeyId}")
            private String accessKeyId;
            @Value("${aliyun.oss.accessKeySecret}")
            private String accessKeySecret;
            @Value("${aliyun.oss.bucketName}")
            private String bucketName;
        }
```
    2. @ConfigurationProperties(prefix = "属性路径前面的部分")
        注意：类上需要@Component注解 成员变量和配置属性名要一致（成员变量使用驼峰命名规范， 配置属性可以和成员变量名字一样或者驼峰处改为小写并且用短横线分割）
        例：
```java
        // file: AliOssProperties.java
        @Data
        @Component
        @ConfigurationProperties(prefix = "aliyun.oss")
        public class AliOssProperties {
            private String endpoint;
            private String accessKeyId;
            private String accessKeySecret;
            private String bucketName;
        }
```




