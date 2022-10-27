package hello.core.lifecycle;

public class NetworkClient {

	private String url; //접속해야할 서버의 가상 url
	
	public NetworkClient() { //default 생성자
		 System.out.println("생성자 호출 , url = "+ url);
		 
		 connect();
		 call("초기화 연결 메시지");
	}
	
	public void setUrl (String url) {
		this.url = url; // url은 외부에서 setter로 넣을수 있도록 생성
	}
	
	// 서비스 시작시 호출 하는 메서드
	public void connect () {
		System.out.println("connect : " + url); //시작시 호출 되어야함
	}
	
	public void call (String message) { //연결된 서버에 메세지를 던질수 있어야함
		System.out.println("call : " + url + "message = "+ message);
	}
	
	//서비스 종료시 호출
	public void disconnect () {
		System.out.println("close :" + url);
	}
	
}
