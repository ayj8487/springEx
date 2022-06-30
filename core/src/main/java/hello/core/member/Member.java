package hello.core.member;

public class Member {

	private Long id; //데이터를 저장하는 엔티티
	private String name;
	private Grade grade;
	
	
	public Member(Long id, String name, Grade grade) { //생성자
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}


	public Long getId() { //getter/setter
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Grade getGrade() {
		return grade;
	}


	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
	
	
	
	
	
}
