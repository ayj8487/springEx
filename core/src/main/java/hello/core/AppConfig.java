package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
	//환경 구성 총괄
	
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
		// 생성자 주입 
	}
	private MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

//	사용영역 OrderServiceImpl 의 코드를 손 대지 않고 
//	구성영역 AppConfig만 수정해서 할인률을 변경할 수있게 되었다.

	public DiscountPolicy discountPolicy() { // 고정할인 => 정률할인 변경시 밑 코드만 변경하면 된다.
		return new RateDiscountPolicy();
//		return new FixDiscountPolicy();

	}
}
