package exam4;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test01_Insert {
	public static void main(String[] args) {
		// 무조건 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		// EntityTransaction transaction = em.getTransaction();
		
		try {
			em.getTransaction().begin();
			
			Member4 user = new Member4("test@test.com","홍길동",LocalDate.now());
			System.out.println("sql문 출력~~~");
			
			em.persist(user);
			System.out.println("영속 컨텍스트에 반영");
			
			em.getTransaction().commit();
			System.out.println("실제 DB에 sql문 처리");
			System.out.println("가입요청을 처리 했습니다");
			
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
}
