package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration // 설정정보라는 명시 어노테이션
public class AppConfig {
	//환경 구성 총괄

	
	@Bean // 스프링 컨테이너에 등록 어노테이션
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
		// 생성자 주입 
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

//	사용영역 OrderServiceImpl 의 코드를 손 대지 않고 
//	구성영역 AppConfig만 수정해서 할인률을 변경할 수있게 되었다.
	@Bean
	public DiscountPolicy discountPolicy() { // 고정할인 => 정률할인 변경시 밑 코드만 변경하면 된다.
		return new RateDiscountPolicy();
//		return new FixDiscountPolicy();

	}
}
