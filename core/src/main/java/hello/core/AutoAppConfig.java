package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration

//자동으로 스프링빈에 등록
@ComponentScan(
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
		)// filter로 뺄 타입만 지정, @Bean으로 수동으로 등록한 AppConfig와 충돌을 막기위해 임의로 설정

public class AutoAppConfig {
	
	
	
}
