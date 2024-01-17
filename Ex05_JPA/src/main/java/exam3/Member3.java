package exam3;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="JpaMember3")
public class Member3 {
	@Id
	@SequenceGenerator (
		name="mySequence01",			// 시퀀스의 고유한 이름
		sequenceName="JpaMember3_seq",	// 실제 DB에서의 시퀀스 명
		initialValue=1,			// 초기값
		allocationSize=1		// 1씩 증가
	)
	@GeneratedValue(generator="mySequence01")
	private Long id;
	
	@Access(AccessType.FIELD)	// 필드를 통해서 데이터 접근(기본값)
	private String username;
	
	@Access(AccessType.PROPERTY)  // get/set메소드를 통해 데이터 접근
	private String password;
	
	@Transient			// 영속 대상에서 제외(DB에 없으므로 제외)
	private String addr;
	transient private String addr2;
	
	public Member3() {
	}

	public Member3(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}