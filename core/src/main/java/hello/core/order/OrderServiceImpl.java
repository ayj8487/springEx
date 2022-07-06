package hello.core.order;

import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
	//1. 주문생성 요청
	private final MemberRepository memberRepository = new MemoryMemberRepository(); //회원 찾기 
	//2. 회원정보 조회
		
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정 할인 정책 
//	private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //정률 할인 정책 
	
	// *** 문제점 : 할인을 고정 => 정률 로 변경시 
	//  추상 인터페이스 뿐만아니라 구현클래스에도 의존하고 있다
	// orderServiceImpl이 discountPolicy 인터페이스 뿐만아니라 FixDiscountPolicy인 구체 클래스도 함께 의존하고 있기때문에 
	// 객체지향 설계인 DIP 위반이다 
	
	// 인터페이스에만 의존해야하는데 구현체인 클래스에도 의존하기 때문에
	// 고정할인을 정률할인으로 변경하는순간 orderServiceImpl의 소스 코드도 변경되기 때문에 
	// 객체지향 설계인 OCP 위반이기도 하다 .

	// *** 해결 방법
//	private DiscountPolicy discountPolicy;
	// final은 값이 할당 되야 하므로 지우고 인터페이스만 의존 하도록 설계
	// 하지만 이 로직은 구현체가 없기때문에 nullPoint 오류가 발생한다.

	// 이 문제를 해결 하려면 누군가가 클라이언트 OrderServiceImpl에 DiscountPolicy 의 구현 
	// 객체를 대신 생성하고 주입 해 주어야 한다 (스프링)
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId); //회원찾기 
		int discountPrice =	discountPolicy.discount(member, itemPrice);
	//3. 할인 정책에 회원 넘기기 	
		return new Order(memberId, itemName, itemPrice, discountPrice);
	//4. 최종 생성된 주문 반환
	}


}
