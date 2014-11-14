package br.com.unipar.estagio.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;

/**
 * @author Juliano Ramos
 * 
 */
public final class JpaUtil {
	/**
	 * Nome da persistence unit que está configurado o banco de dados.
	 */
	private static final String PERSISTENCE_UNIT_NAME = "default";

	/**
	 * Gerencia as ThreadLocal.
	 */
	private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();

	/**
	 * Entidade Gerente de Fabrica.
	 */
	private static EntityManagerFactory factory;

	/** 
	 * Construtor vaziu.
	 */
	private JpaUtil() {
	}

	public static boolean isEntityManagerOpen() {
		return JpaUtil.manager.get() != null && JpaUtil.manager.get().isOpen();
	}

	/**
	 * Pega a Entidade Gerente.
	 * 
	 * @return Entidade Gerente.
	 */
	public static EntityManager getEntityManager() {
		if (JpaUtil.factory == null) {
			JpaUtil.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		EntityManager em = JpaUtil.manager.get();
		if (em == null || !em.isOpen()) {
			em = JpaUtil.factory.createEntityManager();
			JpaUtil.manager.set(em);
		}
		return em;
	}

	/**
	 * Limpa o Cache.
	 * 
	 * @param em Entidade Gerente.
	 * @param region Região.
	 */
	public static void evictCache(EntityManager em, String region) {
		((Session) em.getDelegate()).getSessionFactory().getCache().evictQueryRegion(region);
	}

	/**
	 * Fecha a Entidade Gerente.
	 */
	public static void closeEntityManager() {
		EntityManager em = JpaUtil.manager.get();
		if (em != null) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) {
				tx.commit();
			}
			em.close();
			JpaUtil.manager.set(null);
		}
	}

	/**
	 * Fecha a Entidade Gerente de Fabrica.
	 */
	public static void closeEntityManagerFactory() {
		closeEntityManager();
		JpaUtil.factory.close();
	}
}
