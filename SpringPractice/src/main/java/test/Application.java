package test;

import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import test.second.SecondTestBean;

@Configuration
@ComponentScan(basePackages = "test")
public class Application {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		// System.out.println(ctx.getBean(SecondTestBean.class));
		System.out.println(ctx.getBean(TestBean.class));
		Arrays.asList(ctx.getBeanDefinitionNames()).stream().forEach(a -> {
			System.out.println(a + ":" + ctx.getBean(a).getClass());
		});
	}
	@Bean
	@Qualifier("main")
	public TestBean testBean() {
		TestBean bean = new TestBean();
		bean.setA("c");
		return bean;
	}
 
}
