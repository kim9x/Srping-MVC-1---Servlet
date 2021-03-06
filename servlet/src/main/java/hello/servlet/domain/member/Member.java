package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
	
	private Long id;
	private String username;
	private int age;
	
	public Member() {
		super();
	}
	
	public Member(String username, int age) {
		super();
		this.username = username;
		this.age = age;
	}
	
}
