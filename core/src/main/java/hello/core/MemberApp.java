package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
	
	//	AppConfig appConfig = new AppConfig();
	//	MemberService memberService = appConfig.memberService();

		//스프링으로 전환
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = 
				applicationContext.getBean("memberService", MemberService.class);
		
//		MemberService memberService = new MemberServiceImpl();
		Member member = new Member(1L,"memberA",Grade.VIP);
		//데이터 임의로 넣기
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);

		System.out.println("newMember = "+ member.getName());
		System.out.println("findMember = "+ findMember.getName());
		
	}
}
