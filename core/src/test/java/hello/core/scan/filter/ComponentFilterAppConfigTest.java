package hello.core.scan.filter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

	@Test
	void filterScan() {
	ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);	

	BeanA beanA = ac.getBean("beanA", BeanA.class);
	assertThat(beanA).isNotNull(); //값이 조회가 되야 테스트 성공

	Assertions.assertThrows(
		NoSuchBeanDefinitionException.class, () -> ac.getBean("beanB", BeanB.class));
	}	// beanB를 찾을수 없다는 에러가 나와야 테스트 성공
	
	@Configuration
	@ComponentScan(
			includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
			excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
			)
	
	static class ComponentFilterAppConfig{
	}
	
}
