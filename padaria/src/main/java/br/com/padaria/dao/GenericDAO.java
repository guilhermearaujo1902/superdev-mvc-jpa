package br.com.padaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.padaria.util.ConnectionFactory;

public class GenericDAO<E> {

	private static EntityManager manager = ConnectionFactory.getEntityManager();

	public E buscarPorId(Class<E> entidade, int id) {
		return manager.find(entidade, id);
	}

	@SuppressWarnings("unchecked")
	public List<E> buscarTodos(String jpql) {
		Query query = manager.createQuery(jpql);
		return query.getResultList();
	}

	public void salvar(E e) {
		try {
			manager.getTransaction().begin();
			manager.persist(e);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			manager.getTransaction().rollback();
		}
	}

	public void alterar(E e) {
		try {
			manager.getTransaction().begin();
			manager.merge(e);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			manager.getTransaction().rollback();
		}
	}

	public void deletar(Class<E> entidade, int id) {
		E e = buscarPorId(entidade, id);

		try {
			manager.getTransaction().begin();
			manager.remove(e);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			manager.getTransaction().rollback();
		}
	}

}
