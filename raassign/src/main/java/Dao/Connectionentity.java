package Dao;

import jakarta.persistence.*;

public class Connectionentity {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("Raushan2");
	}
	
	static EntityManager getAnEntityManager() {
		return emf.createEntityManager();
	}
}
