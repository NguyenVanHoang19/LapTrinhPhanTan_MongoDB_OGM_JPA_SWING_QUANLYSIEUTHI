package Entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
@Table(name = "HangHoa")
@Entity
public class HangHoa implements Serializable {
	@Id
	private int _id;
	private String tenHangHoa;
	private LocalDate ngaySanXuat;
	private LocalDate hanSuDung;
	private String donViTinh;
	private double donGia;
	private String loaiHangHoa;
	private String tenNhaCungCap;
	private String diaChiCungCap;
	private String trangThai;
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}
	public String getTenHangHoa() {
		return tenHangHoa;
	}
	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}
	public LocalDate getHanSuDung() {
		return hanSuDung;
	}
	public void setHanSuDung(LocalDate hanSuDung) {
		this.hanSuDung = hanSuDung;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getLoaiHangHoa() {
		return loaiHangHoa;
	}
	public void setLoaiHangHoa(String loaiHangHoa) {
		this.loaiHangHoa = loaiHangHoa;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public String getDiaChiCungCap() {
		return diaChiCungCap;
	}
	public void setDiaChiCungCap(String diaChiCungCap) {
		this.diaChiCungCap = diaChiCungCap;
	}
	
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	public HangHoa(int _id, String tenHangHoa, LocalDate ngaySanXuat, LocalDate hanSuDung, String donViTinh,
			double donGia, String loaiHangHoa, String tenNhaCungCap, String diaChiCungCap, String trangThai) {
		super();
		this._id = _id;
		this.tenHangHoa = tenHangHoa;
		this.ngaySanXuat = ngaySanXuat;
		this.hanSuDung = hanSuDung;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
		this.loaiHangHoa = loaiHangHoa;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChiCungCap = diaChiCungCap;
		this.trangThai = trangThai;
	}
	public HangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (_id ^ (_id >>> 32));
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
		HangHoa other = (HangHoa) obj;
		if (_id != other._id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HangHoa [_id=" + _id + ", tenHangHoa=" + tenHangHoa + ", ngaySanXuat=" + ngaySanXuat + ", hanSuDung="
				+ hanSuDung + ", donViTinh=" + donViTinh + ", donGia=" + donGia + ", loaiHangHoa=" + loaiHangHoa
				+ ", tenNhaCungCap=" + tenNhaCungCap + ", diaChiCungCap=" + diaChiCungCap + ", trangThai=" + trangThai
				+ "]";
	}
	
	
	
	
	
}
