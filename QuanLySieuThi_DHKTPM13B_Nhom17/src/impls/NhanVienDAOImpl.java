package impls;

import java.rmi.RemoteException;
import java.util.ArrayList;
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
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import Entities.HangHoa;
import Entities.HoaDon;
import Entities.NhanVien;
import Entities.TaiKhoan;
import interface_rmi.NhanVienDAO;

public class NhanVienDAOImpl extends java.rmi.server.UnicastRemoteObject implements NhanVienDAO{
	private EntityManager em;
	public NhanVienDAOImpl() throws java.rmi.RemoteException{
		em = SieuThiEntityManager.getInstance().getEntityManager();
	}
	public void addNhanVien(NhanVien nhanVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(nhanVien);
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
	}
	public List<NhanVien> getDsNhanVien() throws RemoteException{
		return em.createNativeQuery("db.NhanVien.find({})", NhanVien.class).getResultList();
	}
	public NhanVien updateNhanVien(NhanVien nhanVien) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(nhanVien);
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return nhanVien;
	}
	public long deleteNhanVienById(int id) throws RemoteException{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(NhanVien.class, id));
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 1;
	}
	public List<NhanVien> getDsNhanVienByTen(String tenNV) throws RemoteException{
		String query = "db.NhanVien.find({tenNhanVien:\""+tenNV+"\"})";
		return em.createNativeQuery(query, NhanVien.class).getResultList();
	}
	public NhanVien getNhanVienById(int id) throws RemoteException{
		return em.find(NhanVien.class, id);
	}
	public List<NhanVien> getNhanVienBySDT(String sDT) throws RemoteException {
		return em.createNativeQuery("db.NhanVien.find({soDienThoai:\""+sDT+"\"})", NhanVien.class).getResultList();
	}
	public List<NhanVien> getNhanVienByCMND(String cmnd) throws RemoteException{
		return em.createNativeQuery("db.NhanVien.find({soCMND:\""+cmnd+"\"})", NhanVien.class).getResultList();
	}
	public TaiKhoan getTaiKhoanById(int id) throws RemoteException{
		NhanVien nhanVien = em.find(NhanVien.class,id);
		return nhanVien.getTaiKhoan();
	}
	public int getIdNhanVienMax() throws RemoteException {
		int idMax =0;
		String query = "db.NhanVien.find({}).sort({_id:-1}).limit(1)";
		List<NhanVien> nhanViens= em.createNativeQuery(query, NhanVien.class).getResultList();
		for(NhanVien nhanVien : nhanViens) {
			idMax = nhanVien.getId();
		}
		return idMax;	
	}
}
