package hello.core.common;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

	private String uuid;
	private String requestURL;
	
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL; // 이 빈은 생성되는 시점에는 알 수 없으므로 외부에서 setter 로 받는다
	}
	
	public void log(String message) {
		System.out.println("[[" + uuid + "]]" + "[" + requestURL + "]" + "[" + message + "]");
	}
	
	@PostConstruct // 연결. 초기화 메서드와 유니크한 아이디 생성
	public void init() {
		uuid = UUID.randomUUID().toString();
		System.out.println("[" + uuid + "]" + "request scope bean create " + this);
	}
	
	@PreDestroy // 종료. 소멸 메서드
	public void close() {
		System.out.println("[" + uuid + "]" + "request scope bean close " + this);
	}
}
