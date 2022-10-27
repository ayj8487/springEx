package hello.core.discount;

import org.springframework.stereotype.Component;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

@Component
@MainDiscountPolicy // 만든 어노테이션

public class RateDiscountPolicy implements DiscountPolicy{
// 고정할인 정책에서 => 정률할인으로 변경시 

	//정률 할인
	
	private int discountPercent = 10;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		} else {
			return 0;
		} 
}
	
}
