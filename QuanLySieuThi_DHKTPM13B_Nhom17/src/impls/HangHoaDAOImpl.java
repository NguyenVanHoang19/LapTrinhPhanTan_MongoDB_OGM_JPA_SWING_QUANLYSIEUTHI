package impls;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.bson.Document;
import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.MongoClient;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import Entities.HangHoa;
import interface_rmi.HangHoaDAO;

public class HangHoaDAOImpl extends java.rmi.server.UnicastRemoteObject implements HangHoaDAO {
	private static final long serialVersionUID = 1L;
	private EntityManager em;
	public HangHoaDAOImpl() throws java.rmi.RemoteException {
		em = SieuThiEntityManager.getInstance().getEntityManager();
	}
	public HangHoa addHangHoa(HangHoa hangHoa) throws RemoteException{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(hangHoa);
			tr.commit();
		} catch (IllegalStateException e2) {
			// TODO: handle exception
			tr.rollback();
			e2.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
			
		}
		return hangHoa;
	}
	public List<HangHoa> getDsHangHoa() throws RemoteException{
		return em.createNativeQuery("db.HangHoa.find({})", HangHoa.class).getResultList();
	} 
	public List<HangHoa> getMaHangHoaByTen(String tenHang) throws RemoteException {
		String query = "db.HangHoa.find({tenHangHoa:\""+ tenHang +"\"})";
		return em.createNativeQuery(query, HangHoa.class).getResultList();
	}
	public List<HangHoa> getHangHoaByLoaiHang(String loaiHang) throws RemoteException {
		String query = "db.HangHoa.find({loaiHangHoa:\""+ loaiHang +"\"})";
		return em.createNativeQuery(query, HangHoa.class).getResultList();
	}
	public int getIdHangHoaMax() throws RemoteException {
		int idMax =0;
		String query = "db.HangHoa.find({}).sort({_id:-1}).limit(1)";
		List<HangHoa> hangHoas= em.createNativeQuery(query, HangHoa.class).getResultList();
		for(HangHoa hangHoa : hangHoas) {
			idMax = hangHoa.getId();
		} 
		return idMax;	
	}
	public HangHoa updateHangHoa(HangHoa hangHoa) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(hangHoa);
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hangHoa;
	}
	public long deleteHangHoaById(int id) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(HangHoa.class,id));
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 1;
	}
	@Override
	public HangHoa getHangHoaById(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return em.find(HangHoa.class, id);
	}
}
