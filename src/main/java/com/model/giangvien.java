package com.model;

public class giangvien {
	private String hoten,ngaysinh,tenbomon;
	private float hesoluong;
	private int maGV;
	
	
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getTenbomon() {
		return tenbomon;
	}
	public void setTenbomon(String tenbomon) {
		this.tenbomon = tenbomon;
	}
	public float getHesoluong() {
		return hesoluong;
	}
	public void setHesoluong(float hesoluong) {
		this.hesoluong = hesoluong;
	}
	public int getMaGV() {
		return maGV;
	}
	public void setMaGV(int maGV) {
		this.maGV = maGV;
	}
	public giangvien(String hoten, String ngaysinh, String tenbomon, float hesoluong, int maGV) {
		super();
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.tenbomon = tenbomon;
		this.hesoluong = hesoluong;
		this.maGV = maGV;
	}
	public giangvien() {
		super();
	}
	public giangvien(String hoten, String ngaysinh, String tenbomon, float hesoluong) {
		super();
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.tenbomon = tenbomon;
		this.hesoluong = hesoluong;
	}
	
	
	
	
	

}
