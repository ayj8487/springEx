package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {

	
	@Test
	@DisplayName("스프링 없는 순수한 DI 컨테이너")

	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		// 1. 조회 : 호출할 때 마다 객체를 생성
		MemberService memberService1 = appConfig.memberService();
		
		// 2. 조회 : 호출할 때 마다 객체를 생성
		MemberService memberService2 = appConfig.memberService();
		
		// 참조값이 다른것을 확인
		// 문제 : AppConfig에 MemberService를 요청하면 다른객체 즉 계속해서 객체를 만들어냄 
		System.out.println("memberService1 = "+ memberService1);
		System.out.println("memberService1 = "+ memberService2);
		
		// memberService1 과 memberService1 는 서로 다른 객체이다 
		Assertions.assertThat(memberService1).isNotSameAs(memberService2);
		// 테스트가 성공하면 다른객체라는 것을 검증 하는 것 
	}

}
