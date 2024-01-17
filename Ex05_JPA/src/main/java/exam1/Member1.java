package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// 필수
@Entity
public class Member1 {
	@Id	   // 필수 : primary key
	@GeneratedValue		// 시퀀스 사용
	private Long id;
	private String username;
	
	/*
	 * @Column 에서 사용하는 속성
	 * - name : 컬럼이름 지정(생략시 변수명과 동일하게 매핑)
	 * - unique : unique제약조건 추가(기본값 false)
	 * - nullable : null상태 허용 여부(기본값 false)
	 * - insertable : insert를 할 때 이컬럼을 포함할 것인지 결정(기본값 true)
	 * - updateable : update를 할 때 이컬럼을 포함할 것인지 결정(기본값 true)
	 * - length : 문자열 타입의 컬럼의 길이 지정(기본값:255)
	 * - columnDefinition : 컬럼에 대한 ddl문을 직접 기술할 수 있음 ex) @Column(columnDefinition="verchar2(200) default 'Y'")
	 */
	@Column(name="create_date")
	private LocalDate createDate;
	/*
	LocalDateTime
	
	@Temporal(TemporalType.TIMESPAMT)
	private Date createDate;
	*/

	public Member1() {} // 필수
	
	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}
