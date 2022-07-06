package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {

	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다")
	
	void vip_o() { // 성공test
		//given
		Member member = new Member(1L,"memberVIP",Grade.VIP); //임의의 맴버 생성
		//when
		int discount = discountPolicy.discount(member, 10000); // 회원=>회원등급 과 가격을 넘김
		//then
		Assertions.assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
	void vip_x() { // 실패 test
 		Member member = new Member(2L,"memberBASIC",Grade.BASIC); //임의의 맴버 생성

		int discount = discountPolicy.discount(member, 10000); // 회원=>회원등급 과 가격을 넘김
	
		Assertions.assertThat(discount).isEqualTo(0);
//		Assertions.assertThat(discount).isEqualTo(1000); //BASIC등급 회원은 할인정책이 적용되지 않지만 1000원을 할인해서 오류 
	}
}
