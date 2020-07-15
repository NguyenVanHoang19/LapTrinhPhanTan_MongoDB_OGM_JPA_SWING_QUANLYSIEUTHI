package impls;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SieuThiEntityManager {
	private static SieuThiEntityManager instance = null;
	private EntityManager entityManager;
	public SieuThiEntityManager() {
		// TODO Auto-generated constructor stub
		entityManager = Persistence.createEntityManagerFactory("ogm-QuanLySieuThi").createEntityManager();
	}
	public synchronized static SieuThiEntityManager getInstance() {
		if(instance == null) {
			instance = new SieuThiEntityManager();
		}
		return instance;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
