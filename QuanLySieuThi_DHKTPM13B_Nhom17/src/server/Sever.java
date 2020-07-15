package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import impls.HangHoaDAOImpl;
import impls.NhanVienDAOImpl;

public class Sever {
	public static void main(String[] args) throws Exception {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "mypolicy\\policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		LocateRegistry.createRegistry(1099);
		System.out.println("rmiregistry started on port 1092");
		
		HangHoaDAOImpl hangHoaDAOImpl = new HangHoaDAOImpl();
		NhanVienDAOImpl nhanVienDAOImpl = new NhanVienDAOImpl();
		Context ctx = new InitialContext();
		ctx.bind("rmi://localhost:1099/xyLyHangHoa", hangHoaDAOImpl);
		ctx.bind("rmi://localhost:1099/xyLyNhanVien",nhanVienDAOImpl);
		System.out.println("Service has bound to rmiregistry");
	}
}
