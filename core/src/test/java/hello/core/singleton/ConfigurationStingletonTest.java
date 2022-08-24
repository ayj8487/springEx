package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

public class ConfigurationStingletonTest {

	// @Configuration 과 바이트 조작 
	@Test
	void ConfigurationDeep() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig bean = ac.getBean(AppConfig.class);

		System.out.println("bean = " + bean.getClass());
// bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$e54804fe
// 출력시 위와 같은 경로가 출력된다
// 하지만 순수한 클래스라면 다음과 같이 출력되어야 한다.
// class hello.core.AppConfig
		
// 따라서 이것은 내가 만든 클래스가 아니라 스프링이 CGBLB라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를
// 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한 것이다.
	}
	
	
}
