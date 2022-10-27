package hello.core.autowired;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;

public class AllBeanTest {

	@Test
	void findAllBean() {
		AnnotationConfigApplicationContext ac =	new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
		
	}
	
	static class DiscountService {
		private final Map<String, DiscountPolicy> policyMap;
		private final List<DiscountPolicy> policies;

		public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
			this.policyMap = policyMap;
			this.policies = policies;
			System.out.println("policyMap = "+ policyMap);
			System.out.println("policies = "+ policies);
			
		}
	}
}
