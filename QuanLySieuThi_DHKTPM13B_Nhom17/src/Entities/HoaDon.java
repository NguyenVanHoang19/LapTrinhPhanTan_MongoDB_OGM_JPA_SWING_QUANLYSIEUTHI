package Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Table(name = "HoaDon")
@Entity
public class HoaDon implements Serializable {
	@Id
	private String _id;
	private LocalDate ngayLap;
	private double tongTien;	
	@ManyToOne
	private NhanVien nhanVien;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public List<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public HoaDon(String id, LocalDate ngayLap, double tongTien, NhanVien nhanVien, List<ChiTietHoaDon> chiTietHoaDons) {
		super();
		this._id = id;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.nhanVien = nhanVien;
		this.chiTietHoaDons = chiTietHoaDons;
	}

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HoaDon [id=" + _id + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", nhanVien=" + nhanVien
				+ ", chiTietHoaDons=" + chiTietHoaDons + "]";
	}

	
	
	
	
}
