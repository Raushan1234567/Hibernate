package dao;

import jakarta.persistence.*;

public class ConnectionC {
	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("raush");

	}

	static EntityManager getConnection() {
		return emf.createEntityManager();
	}
}
