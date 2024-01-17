package exam5;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test03_Parameter {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
	
		try {
			em.getTransaction().begin();
			TypedQuery<Member5> query = em.createQuery(
						  "select m from Member5 m"
					    + " where m.name = :name"
					    + " order by m.name"
					    , Member5.class)
						.setParameter("name", "이순신");
			
			List<Member5> result = query.getResultList();
			
			em.getTransaction().commit();
			
			if(result.isEmpty()) {
				System.out.println("테이블이 비어 있습니다");
			} else {
				result.forEach(user ->
						System.out.printf("| %s | %s | %tY-%<tm-%<td |\n", 
								user.getEmail(), user.getName(), user.getCreateDate()));
			}

		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
}
