package main;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bson.Document;
import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Entities.ChiTietHoaDon;
import Entities.HangHoa;
import Entities.HoaDon;
import Entities.NhanVien;
import Entities.TaiKhoan;
import impls.HangHoaDAOImpl;
import impls.HoaDonDAOImpl;
import impls.NhanVienDAOImpl;

public class Main {
	public static void main(String[] args) throws RemoteException {
		
		/*
		 * Them hang hoa
		 * 
		 * 
		 * */
		HangHoa hangHoa = new HangHoa( 1,"Vinamilk", LocalDate.parse("2019-01-02"),LocalDate.parse("2020-01-20"), "Hop",32000,"Sữa","Công ty cổ phần sữa Hà Lan", "Ho chi minh","Đang kinh doanh");
		HangHoa hangHoa1 = new HangHoa(2, "Chuối", LocalDate.parse("2019-01-03"),LocalDate.parse("2020-07-01"), "Kg",12000,"Trái Cây","Nông Sản Việt", "Khánh Hòa","Ngừng kinh doanh");
		
		/*
		 * them loai hang gia vi
		 * 
		 * */
		HangHoa hangHoa2 = new HangHoa(3, "Dầu ăn kiddy", LocalDate.parse("2018-01-03"),LocalDate.parse("2020-08-12"), "Chai",36000,"Gia vị","Dầu ăn Việt", "Phú Yên","Đang kinh doanh");
		HangHoa hangHoa3 = new HangHoa(4, "Dầu ăn Neptune 400ml", LocalDate.parse("2018-02-13"),LocalDate.parse("2019-08-12"), "Chai",15000,"Gia vị","Dầu ăn Việt Phú", "Đắc Nông","Đang kinh doanh");
		HangHoa hangHoa4 = new HangHoa(5, "Dầu ăn Mezan 1l", LocalDate.parse("2018-07-22"),LocalDate.parse("2019-10-12"), "Chai",43000,"Gia vị","Dầu ăn Thái Nguyên", "Lâm Đồng","Đang kinh doanh");
		HangHoa hangHoa5 = new HangHoa(6, "Dầu ăn Cái Lân 1l", LocalDate.parse("2018-04-21"),LocalDate.parse("2019-12-12"), "Chai",62000,"Gia vị","Dầu ăn Toàn Phá", "Hồ Chí Minh","Đang kinh doanh");
		/*
		 * them loai hang my pham
		 * 
		 * */
		HangHoa hangHoa6 = new HangHoa(7, "SRM nivia tẩy trang", LocalDate.parse("2017-05-22"),LocalDate.parse("2020-12-12"), "Lọ",34000,"Mỹ Phẩm","Mỹ Phẩm Nivia", "Hồ Chí Minh","Đang kinh doanh");
		HangHoa hangHoa7 = new HangHoa(8, "SRM mờ vết thâm", LocalDate.parse("2017-07-21"),LocalDate.parse("2020-11-12"), "Lọ",60000,"Mỹ Phẩm","Mỹ Phẩm Nivia", "Hồ Chí Minh","Đang kinh doanh");
		HangHoa hangHoa8 = new HangHoa(9, "Kem Soft", LocalDate.parse("2019-07-21"),LocalDate.parse("2022-11-12"), "Lọ",120000,"Mỹ Phẩm","Mỹ Phẩm Soft", "New York","Đang kinh doanh");
		HangHoa hangHoa9 = new HangHoa(10, "Sữa tắm cool nivia", LocalDate.parse("2018-02-11"),LocalDate.parse("2022-12-12"), "Chai",44000,"Mỹ Phẩm","Mỹ Phẩm Nivia", "Hồ Chí Minh","Đang kinh doanh");
		
		/*
		 * them loai hang do hop
		 * 
		 * 
		 * */
		HangHoa hangHoa10 = new HangHoa(11, "Xúc xích dinh dưỡng heo", LocalDate.parse("2019-10-11"),LocalDate.parse("2019-12-12"), "Túi",34000,"Đồ hộp","Công ty thực phẩm Việt Nam", "Nha Trang, Khánh Hòa","Đang kinh doanh");
		HangHoa hangHoa11 = new HangHoa(12, "Thịt hộp heo bầm", LocalDate.parse("2019-11-03"),LocalDate.parse("2019-12-15"), "Hộp",22000,"Đồ hộp","Công ty thực phẩm Việt Nam", "Nha Trang, Khánh Hòa","Đang kinh doanh");
		HangHoa hangHoa12 = new HangHoa(13, "Thịt hộp bò xay", LocalDate.parse("2019-11-02"),LocalDate.parse("2019-11-30"), "Hộp",44000,"Đồ hộp","Công ty thực phẩm Thái Dương", "Phú Yên","Đang kinh doanh");
		HangHoa hangHoa13 = new HangHoa(14, "Xúc xích 3 bông mai", LocalDate.parse("2019-11-01"),LocalDate.parse("2019-11-04"), "Hộp",56000,"Đồ hộp","Công ty thực phẩm Thái Dương", "Phú Yên","Đang kinh doanh");
		HangHoa hangHoa14 = new HangHoa(15, "Thịt hộp cá xốt cà", LocalDate.parse("2019-11-01"),LocalDate.parse("2019-11-03"), "Hộp",65000,"Đồ hộp","Công ty thực phẩm Thái Dương", "Phú Yên","Đang kinh doanh");
		/*
		 * Them loai hang Bột Giặc
		 * 
		 * 
		 * */
		HangHoa hangHoa15 = new HangHoa(16, "Bột giặc Aba 800g", LocalDate.parse("2018-11-10"),LocalDate.parse("2020-11-03"), "Bịch",45000,"Bột giặc","Công ty Cổ phần bột giặc Aba", "Quận 12,Tp.Hồ Chí Minh","Đang kinh doanh");
		HangHoa hangHoa16 = new HangHoa(17, "Nước giặc Aba 1000g", LocalDate.parse("2018-11-10"),LocalDate.parse("2020-11-03"), "Chai",45000,"Bột giặc","Công ty Cổ phần bột giặc Aba", "Quận 12,Tp.Hồ Chí Minh","Đang kinh doanh");
		/*
		 * Them loai hang do uong
		 * 
		 * 
		 * */
		HangHoa hangHoa17 = new HangHoa(18, "Nước yến thạch", LocalDate.parse("2019-06-10"),LocalDate.parse("2020-11-03"), "Lon",12000,"Đồ uống","Công ty giải khát Khánh Hòa", "Ninh diêm,Ninh Hòa,Khánh Hòa","Đang kinh doanh");
		HangHoa hangHoa18 = new HangHoa(19, "Nước red yak", LocalDate.parse("2019-05-10"),LocalDate.parse("2019-11-01"), "Lon",15000,"Đồ uống","Công ty giải khát Khánh Hòa", "Ninh diêm,Ninh Hòa,Khánh Hòa","Đang kinh doanh");
		/*
		 * them loai hang sữa
		 * 
		 * */
		HangHoa hangHoa19 = new HangHoa(20, "Canxi pro 900g", LocalDate.parse("2019-06-10"),LocalDate.parse("2020-11-01"), "Hộp",7000,"Sữa","Công ty sữa bột Việt Nam", "14 Đại lộ tự do, Vsip1,Bình Dương","Đang kinh doanh");
		HangHoa hangHoa20 = new HangHoa(21, "Canxi pro 500g", LocalDate.parse("2019-06-10"),LocalDate.parse("2020-11-01"), "Chai",12000,"Sữa","Công ty sữa bột Việt Nam", "14 Đại lộ tự do, Vsip1,Bình Dương","Đang kinh doanh");
		HangHoa hangHoa21 = new HangHoa(22, "Ridielac alpha Gao 350g", LocalDate.parse("2019-07-10"),LocalDate.parse("2020-12-01"), "Hộp",7000,"Sữa","Công ty sữa bột Việt Nam", "14 Đại lộ tự do, Vsip1,Bình Dương","Đang kinh doanh");
		/*
		 * them loai hang banh keo
		 * */
		
		HangHoa hangHoa22 = new HangHoa(23, "Thạch sữa chua", LocalDate.parse("2019-10-10"),LocalDate.parse("2019-11-01"), "Bịch",4000,"Bánh kẹo","Công ty bánh kẹo Việt Nam", "14 Đại lộ tự do, Vsip1,Bình Dương","Đang kinh doanh");
		HangHoa hangHoa23 = new HangHoa(24, "Thạch sữa chua", LocalDate.parse("2019-10-10"),LocalDate.parse("2019-11-01"), "Hộp",6000,"Bánh kẹo","Công ty bánh kẹo Việt Nam", "14 Đại lộ tự do, Vsip1,Bình Dương","Đang kinh doanh");
		
		
		HangHoaDAOImpl hangHoaDAO = new HangHoaDAOImpl();
		hangHoaDAO.addHangHoa(hangHoa);
		hangHoaDAO.addHangHoa(hangHoa1);
		hangHoaDAO.addHangHoa(hangHoa2);
		hangHoaDAO.addHangHoa(hangHoa3);
		hangHoaDAO.addHangHoa(hangHoa4);
		hangHoaDAO.addHangHoa(hangHoa5);
		hangHoaDAO.addHangHoa(hangHoa6);
		hangHoaDAO.addHangHoa(hangHoa7);
		hangHoaDAO.addHangHoa(hangHoa8);
		hangHoaDAO.addHangHoa(hangHoa9);
		hangHoaDAO.addHangHoa(hangHoa10);
		hangHoaDAO.addHangHoa(hangHoa11);
		hangHoaDAO.addHangHoa(hangHoa12);
		hangHoaDAO.addHangHoa(hangHoa13);
		hangHoaDAO.addHangHoa(hangHoa14);
		hangHoaDAO.addHangHoa(hangHoa15);
		hangHoaDAO.addHangHoa(hangHoa16);
		hangHoaDAO.addHangHoa(hangHoa17);
		hangHoaDAO.addHangHoa(hangHoa18);
		hangHoaDAO.addHangHoa(hangHoa19);
		hangHoaDAO.addHangHoa(hangHoa20);
		hangHoaDAO.addHangHoa(hangHoa21);
		hangHoaDAO.addHangHoa(hangHoa22);
		hangHoaDAO.addHangHoa(hangHoa23);
		
		
		
		
		NhanVienDAOImpl nhanVienDAO = new NhanVienDAOImpl();
		TaiKhoan taiKhoan = new TaiKhoan("NguyenHoang", "12345");
		NhanVien nhanVien = new NhanVien(1, "Nguyễn Văn Hoàng", LocalDate.parse("1999-11-21"),"Nam", "225723176", "017245896", "QL", "Ninh Hòa,Khánh Hòa,Việt Nam", "Đang làm việc",taiKhoan);
		nhanVienDAO.addNhanVien(nhanVien);
		
		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(1, 22000, hangHoa);
		ChiTietHoaDon chiTietHoaDon1 = new ChiTietHoaDon(1, 22000, hangHoa);
		List<ChiTietHoaDon> tietHoaDons = new ArrayList<ChiTietHoaDon>();
		tietHoaDons.add(chiTietHoaDon);
		tietHoaDons.add(chiTietHoaDon1);
		
		HoaDon hoaDon = new HoaDon("1", LocalDate.parse("2019-10-22"), 22000, nhanVien, tietHoaDons);
		HoaDonDAOImpl hoaDonDAO = new HoaDonDAOImpl();
		hoaDonDAO.addHoaDon(hoaDon);
		HangHoaDAOImpl hangHoaDAOImpl = new HangHoaDAOImpl();
		hangHoaDAOImpl.getDsHangHoa().forEach(x->{
			System.out.println(x);
		});
		hangHoaDAOImpl.getMaHangHoaByTen("Vinamilk").forEach(x->{
			System.out.println(x);
		});
		System.out.println(hangHoaDAOImpl.getIdHangHoaMax());
		
		hangHoaDAOImpl.getHangHoaByLoaiHang("Thực Phẩm").forEach(x->{
			System.out.println(x);
		});

		
	}
}
