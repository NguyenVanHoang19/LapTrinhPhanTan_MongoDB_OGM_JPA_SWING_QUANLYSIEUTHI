package interface_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityExistsException;

import Entities.NhanVien;
import Entities.TaiKhoan;

public interface NhanVienDAO extends Remote {
	public void addNhanVien(NhanVien nhanVien) throws RemoteException;
	public List<NhanVien> getDsNhanVien() throws RemoteException;
	public NhanVien updateNhanVien(NhanVien nhanVien) throws RemoteException;
	public long deleteNhanVienById(int id) throws RemoteException;
	public List<NhanVien> getDsNhanVienByTen(String tenNV) throws RemoteException;
	public NhanVien getNhanVienById(int id)  throws RemoteException;
	public List<NhanVien> getNhanVienBySDT(String sDT) throws RemoteException;
	public List<NhanVien> getNhanVienByCMND(String cmnd) throws RemoteException;
	public TaiKhoan getTaiKhoanById(int id) throws RemoteException;
	public int getIdNhanVienMax() throws RemoteException;
}
