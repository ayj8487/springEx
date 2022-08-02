package hello.core.beanfind;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class ApplicationContextInfoBasicFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 이름으로 조회")

	void findBeanByName() {
	MemberService memberService = ac.getBean("memberService", MemberService.class);
	System.out.println("memberService = " + memberService);
	System.out.println("memberService.getClass() = " + memberService.getClass());
	
	Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("이름 없이 타입으로만 조회")

	void findBeanByType() {
	MemberService memberService = ac.getBean( MemberService.class);
	
	Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

	}
	
	@Test
	@DisplayName("구체 타입으로만 조회")

	void findBeanByName2() {
	MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
	
	Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

	}

//	@Test
//	@DisplayName("빈 이름으로 조회x")
//
//	void findBeanByNameX() {
//		MemberService xxx = ac.getBean("xxx", MemberService.class);
//		// NoSuchBeanDefinitionException: 없는 빈 이름이기 때문에 Junit 에러가 터짐
//		assertThrows(NoSuchBeanDefinitionException.class, 
//				() -> ac.getBean("xxx", MemberService.class));
//		// 오른쪽 로직을 실행하면 왼쪽 로직이 실행이 되야 한다
//	}	

}
