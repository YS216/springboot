package exam4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test02_select {

	public static void main(String[] args) {
		// 무조건 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		/*
		 * 검색시 find() 메소드 사용
		 *  - 아무 지정을 하지 않으면 @Id가 붙은 primary key를 이용해 검색한다 
		 */
		Member4 user = em.find(Member4.class, "test@test.com");
		System.out.println(user);
		
		if(user != null) {
			System.out.println("이름 : " + user.getName());
			System.out.printf("생성 날짜 : %ty-%<tm-%<td\n", user.getCreateDate());
			/*
			 * 't' or 'T' : 날짜, 시간(날짜 및 시간 서식 문자 앞에 지정)
			 *   ex)  %tH, %tM, %tS ...
			 *   'Y' : 년(4자리)
			 *   'y' : 년(2자리)
			 *   'm' : 월(01~12)
			 *   'd' : 일(01~31)
			 *   'e' : 일(1~31)
			 *   'H' : 24시간 형식의 시(00~23)
			 *   'I' : 12시간 형식의 시(01~12)
			 *   'M' : 분(00~60)
			 *   'S' : 초(00~60) 
			 *   
			 *   %< 로 상대 인덱스 지정하여 직전의 인수와 같은 인덱스를 이용
			 */
		} else {
			System.out.println("존재하지 않습니다");
		}

	}

}
