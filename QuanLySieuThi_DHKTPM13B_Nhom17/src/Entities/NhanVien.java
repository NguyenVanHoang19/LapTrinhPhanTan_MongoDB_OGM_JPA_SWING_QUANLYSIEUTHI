package Entities;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table(name = "NhanVien")
@Entity
public class NhanVien implements Serializable {
	@Id
	private int _id;
	private String tenNhanVien;
	private LocalDate ngaySinh;
	private String gioiTinh;
	private String soCMND;
	private String soDienThoai;
	private String loaiNV;
	private String diaChi;
	private String trangThai;
	@Embedded
	private TaiKhoan taiKhoan;
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getLoaiNV() {
		return loaiNV;
	}
	public void setLoaiNV(String loaiNV) {
		this.loaiNV = loaiNV;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	public NhanVien(int _id, String tenNhanVien, LocalDate ngaySinh, String gioiTinh, String soCMND, String soDienThoai,
			String loaiNV, String diaChi, String trangThai, TaiKhoan taiKhoan) {
		super();
		this._id = _id;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.loaiNV = loaiNV;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.taiKhoan = taiKhoan;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _id;
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
		NhanVien other = (NhanVien) obj;
		if (_id != other._id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NhanVien [_id=" + _id + ", tenNhanVien=" + tenNhanVien + ", ngaySinh=" + ngaySinh + ", gioiTinh="
				+ gioiTinh + ", soCMND=" + soCMND + ", soDienThoai=" + soDienThoai + ", loaiNV=" + loaiNV + ", diaChi="
				+ diaChi + ", trangThai=" + trangThai + ", taiKhoan=" + taiKhoan + "]";
	}
	
	
	
	
	
	
	
}
