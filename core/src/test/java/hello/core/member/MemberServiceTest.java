package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
// junit 테스트 , 배포시 test클래스는 배포되지 않는다.

	MemberService memberService = new MemberServiceImpl();
	
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
