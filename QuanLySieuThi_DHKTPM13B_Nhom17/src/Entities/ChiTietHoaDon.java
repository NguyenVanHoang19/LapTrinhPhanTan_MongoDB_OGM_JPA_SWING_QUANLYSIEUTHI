package Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;

@Embeddable
public class ChiTietHoaDon implements Serializable{
	private int soLuong;
	private double donGia;
	@ManyToOne
	private HangHoa hangHoa;
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public HangHoa getHangHoa() {
		return hangHoa;
	}
	public void setHangHoa(HangHoa hangHoa) {
		this.hangHoa = hangHoa;
	}
	public ChiTietHoaDon(int soLuong, double donGia, HangHoa hangHoa) {
		super();
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.hangHoa = hangHoa;
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuong=" + soLuong + ", donGia=" + donGia + ", hangHoa=" + hangHoa + "]";
	}
	
}
