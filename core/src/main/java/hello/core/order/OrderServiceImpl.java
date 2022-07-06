package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
	//1. 주문생성 요청
	private final MemberRepository memberRepository = new MemoryMemberRepository(); //회원 찾기 
	//2. 회원정보 조회
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정 할인 정책
	
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId); //회원찾기 
		int discountPrice =	discountPolicy.discount(member, itemPrice);
	//3. 할인 정책에 회원 넘기기 	
		return new Order(memberId, itemName, itemPrice, discountPrice);
	//4. 최종 생성된 주문 반환
	}


}
