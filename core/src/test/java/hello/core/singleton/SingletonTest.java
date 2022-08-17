package hello.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

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

	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")

	void singletonServiceTest() {
	// new SingletonService() 이 로직을 실행해 객체를 생성하려면 private 싱글톤 패턴으로 지정해 놨기에 오류가 실행된다. 
		SingletonService singletonService1 = SingletonService.getInstance();
		SingletonService singletonService2 = SingletonService.getInstance();
		
		System.out.println("singletonService1 = " + singletonService1);
		System.out.println("singletonService2 = " + singletonService2);
		
		assertThat(singletonService1).isSameAs(singletonService2);

		// 싱글톤 패턴 적용시 같은 객체를 불러온다 .
	
	 // 위와같이 싱글톤을 적용하여 로직을 일일히 짜야하지만 스프링을 사용하면 스프링은 알아서 싱글톤을 잡아준다
	}
}
