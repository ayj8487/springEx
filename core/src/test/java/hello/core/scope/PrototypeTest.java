package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import hello.core.scope.SingletonTest.singletonBean;

public class PrototypeTest {

	@Test
	void prototypeBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);
		System.out.println("find prototypeBean1");

		prototypeBean prototypeBean1 = ac.getBean(prototypeBean.class);
		System.out.println("find prototypeBean2");
		
		prototypeBean prototypeBean2 = ac.getBean(prototypeBean.class);
		System.out.println("prototypeBean1 = "+ prototypeBean1);
		System.out.println("prototypeBean2 = "+ prototypeBean2);
		
		assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
	
		ac.close(); // prototype은 소멸메서드가 호출 되지 않는다.
	}
	
	@Scope("prototype")
	static class prototypeBean{
		@PostConstruct
		public void init() {
			System.out.println("prototypeBean.init");
		}
		
		@PreDestroy
		public void destroy() {
			System.out.println("prototypeBean.destroy");
		}
	}
}
