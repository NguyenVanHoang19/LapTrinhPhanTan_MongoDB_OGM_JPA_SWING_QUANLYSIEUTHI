package interface_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.text.html.ListView;

import Entities.HangHoa;

public interface HangHoaDAO extends Remote {
	public HangHoa addHangHoa(HangHoa hangHoa) throws RemoteException;
	public List<HangHoa> getDsHangHoa() throws RemoteException;
	public List<HangHoa> getMaHangHoaByTen(String tenHang) throws RemoteException;
	public int getIdHangHoaMax() throws RemoteException;
	public HangHoa updateHangHoa(HangHoa hangHoa) throws RemoteException;
	public long deleteHangHoaById(int id) throws RemoteException;
	public List<HangHoa> getHangHoaByLoaiHang(String loaiHang) throws RemoteException ;
	public HangHoa getHangHoaById(int id) throws RemoteException;
}
