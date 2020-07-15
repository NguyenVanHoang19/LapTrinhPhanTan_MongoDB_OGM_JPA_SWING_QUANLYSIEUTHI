package impls;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.bson.Document;
import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import Entities.HangHoa;
import Entities.HoaDon;
import Entities.NhanVien;

public class HoaDonDAOImpl {
	private EntityManager em;
	public HoaDonDAOImpl() throws java.rmi.RemoteException{
		em = SieuThiEntityManager.getInstance().getEntityManager();
	}
	public void addHoaDon(HoaDon hoaDon) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(hoaDon);
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
	}
	public List<HoaDon> getDsHoaDon() throws RemoteException{
		return em.createNativeQuery("db.HoaDon.find({})", HoaDon.class).getResultList();
	}
}
