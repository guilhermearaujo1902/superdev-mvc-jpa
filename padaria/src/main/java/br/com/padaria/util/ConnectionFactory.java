package br.com.padaria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory factory = null;

	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("padaria");
		}
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
