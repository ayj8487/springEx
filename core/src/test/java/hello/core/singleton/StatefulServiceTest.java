package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 =  ac.getBean(StatefulService.class);
		StatefulService statefulService2 =  ac.getBean(StatefulService.class);

		// 쓰레드A : A사용자 10000원 주문
		statefulService1.order("userA", 10000);
		// 쓰레드B : B사용자 20000원 주문
		statefulService2.order("userB", 20000);

		// 쓰레드A : 사용자A 주문 금액 조회
		int price = statefulService1.getPrice();
		System.out.println("price = "+ price);
		
		// ==> 사용자A 의 주문금액을 조회시 사용자B의 주문금액이 출력 됨.

		Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
		// A와B의 같은 인스턴스 이기때문에 
	}
	
	static class TestConfig{
		
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}
