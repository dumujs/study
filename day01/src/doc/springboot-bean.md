# springboot bean对象
    springboot项目启动时自动创建bean放到ioc容器
## bean对象声明
    开发项目本地类 注解 @Component 以及其衍生注解 @Controller @Repository @Service
    @Bean注解 可以在@Component和@Configuration注解的类下使用
    如果要把第三方bean注入ioc容器 只能使用@Bean注解
```java
@Configuration
public class CommonConfig {
    // springboot将创建bean对象的过程交给开发者 默认bean的名称是方法名（deptController1）
    // @Bean注解的方法参数中可以直接获取IOC容器的bean对象 无需@Autowired
    @Bean
    DeptController1 deptController1(DeptController deptController){
        return new DeptController1();
    }
}
```
## 获取方式 
    1 根据name获取bean Object getBean(String var1)
    2 根据类型获取bean <T> T getBean(Class<T> var1)
    3 根据name获取bean（带类型转换） <T> T getBean(String var1, Class<T> var2)
    4 Object getBean(String var1, Object... var2)
    5 <T> T getBean(Class<T> var1, Object... var2)
## bean作用域
    作用于注解 @Scope("prototype")
    1. singleton 单例模式（默认模式）
    2. prototype 每次使用bean时创建新对象
    3. request web环境 每次请求范围内创建bean新对象 
    4. session web环境 每次回话范围内创建bean新对象 
    5. application web环境 每个应用内创建bean新对象 
```java
@RestController
@Lazy // 可以延迟到第一次使用时创建bean对象
@Scope("singleton")
public class DeptController {
}
```
```java
// file: SpringbootApplicationTests.java
@SpringBootTest
class SpringbootApplicationTests {
	@Autowired
	Gson gson;
	@Autowired
	ApplicationContext applicationContext;
    
	@Test
	void testGetBean() {
		// 获取bean
		DeptController bean1 = (DeptController) applicationContext.getBean("deptController");
		System.out.println(bean1);
        DeptController deptController1 = (DeptController) applicationContext.getBean("deptController1");
        System.out.println(deptController1);

		DeptController bean2 = applicationContext.getBean(DeptController.class);
		System.out.println(bean2);

		DeptController bean3 = applicationContext.getBean("deptController",DeptController.class);
		System.out.println(bean3);
	}

}
```

