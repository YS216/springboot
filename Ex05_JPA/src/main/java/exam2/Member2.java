package exam2;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="JpaMember2")
public class Member2 {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	public Member2() {} // 필수
	
	public Member2(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}






