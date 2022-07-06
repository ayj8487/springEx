package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

public class MemberServiceTest {
// junit 테스트 , 배포시 test클래스는 배포되지 않는다.

//	MemberService memberService = new MemberServiceImpl();

	MemberService memberService;
	
	@BeforeEach //테스트를 실행하기전에 무조건 실행
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}
	
	
	@Test
	void join() {
		//given : 이렇게 환경이 주어졌을 때
		Member member = new Member(1L,"memberA",Grade.VIP);
		
		//when : 이렇게 했을 때
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		//then : 이렇게 된다. 
		Assertions.assertThat(member).isEqualTo(findMember);

	}
}
