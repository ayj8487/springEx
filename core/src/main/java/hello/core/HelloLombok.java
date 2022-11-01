package hello.core;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Getter
//@Setter
//
//@ToString
public class HelloLombok {

	// getter / setter 자동 완성/ 롬복
	private String name;
	private int age;

	public static void main(String[] args) {
		
		HelloLombok helloLombok = new HelloLombok();
//		helloLombok.setName("youngjun");
		
//		String name = helloLombok.getName();
		// To String 자동완성
		
		System.out.println("name = "+ helloLombok);

		
	}
	
	
}
