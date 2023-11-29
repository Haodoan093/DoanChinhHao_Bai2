package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.giangvien;



public class giangvienDao {
	
	private String con = "jdbc:mysql://localhost:3306/ql_giangvien?useSSL=false";
	private String username = "root";
	private String password = "";
	private String getall="SELECT * FROM giangvien";
	private String insert = "INSERT INTO giangvien(hoten,ngaysinh,tenbomon,hesoluong) VALUES (?, ?,?,?)";

	private String selectGV = "SELECT * FROM giangvien WHERE maGV =?";
	//seảchư
	private String searchname = "SELECT * FROM giangvien WHERE hoten LIKE ? ";
	
	private String searchma = "SELECT * FROM giangvien WHERE maGV LIKE  ?";
	//xóa
	private String delete = "DELETE FROM giangvien WHERE maGV =?";
	
	//sua
	private String UPDATE="update giangvien set hoten=?,ngaysinh=?,tenbomon=?,hesoluong=? where maGV=?";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(con, username, password);
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: " + e.getMessage());
			e.printStackTrace();
		}

		return connection;
	}
	public List<giangvien> getAll() {
		List<giangvien> ls = new ArrayList<>();// khoi tao
		try (Connection connection = getConnection()) {
			if (connection != null) {
				try (PreparedStatement pr = connection.prepareStatement(getall)) {

					ResultSet rs = pr.executeQuery();

					while (rs.next()) {
						int magv = rs.getInt("maGV");
						String hoten = rs.getString("hoten");
						String ngaysinh = rs.getString("ngaysinh");
						String tenbomon = rs.getString("tenbomon");
						float hesoluong = rs.getFloat("hesoluong");
						ls.add(new giangvien(hoten, ngaysinh, tenbomon, hesoluong, magv));
					}
				}
			} else {
				System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
			}
		} catch (Exception e) {
			System.err.println("Ngoại lệ: " + e.getMessage());
			e.printStackTrace();
		}
		return ls;
	}
	//them moi
	public void insertGV(giangvien gv) {
		try (Connection connection = getConnection()) {
			if (connection != null) {
				try (PreparedStatement pr = connection.prepareStatement(insert)) {
					pr.setString(1, gv.getHoten());
					pr.setString(2, gv.getNgaysinh());
					pr.setString(3, gv.getTenbomon());
					pr.setFloat(4, gv.getHesoluong());
					pr.executeUpdate();
					System.out.println("Thêm thành công!");
				}
			} else {
				System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
			}
		} catch (Exception e) {
			System.err.println("Ngoại lệ: " + e.getMessage());
			e.printStackTrace();
		}
	}
	//xoa
	public void DeleteGV(int id) {
		try (Connection connection = getConnection()) {
			if (connection != null) {
				try (PreparedStatement pr = connection.prepareStatement(delete)) {
					pr.setInt(1, id);

					pr.executeUpdate();

				}
			} else {
				System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
			}
		} catch (Exception e) {
			System.err.println("Ngoại lệ: " + e.getMessage());
			e.printStackTrace();
		}
	}
	// tim kiem
	public List<giangvien> SearchAllStudent(String type, String key) {
		List<giangvien> ls = new ArrayList<>();
		try (Connection connection = getConnection()) {
			if (connection != null) {
				PreparedStatement pr = connection.prepareStatement(searchname);
				pr.setString(1, "%" + key + "%");
				if (type.contains("ma")) {
					pr = connection.prepareStatement(searchma);
					pr.setInt(1, Integer.parseInt(key));
				}
				ResultSet rs = pr.executeQuery();
				while (rs.next()) {
					int magv = rs.getInt("maGV");
					String hoten = rs.getString("hoten");
					String ngaysinh = rs.getString("ngaysinh");
					String tenbomon = rs.getString("tenbomon");
					float hesoluong = rs.getFloat("hesoluong");
					ls.add(new giangvien(hoten, ngaysinh, tenbomon, hesoluong, magv));

				}
			} else {
				System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
			}
		} catch (Exception e) {
			System.err.println("Ngoại lệ: " + e.getMessage());
			e.printStackTrace();
		}
		return ls;
	}
	// lay GV
	public giangvien getGV(int id) {
		giangvien gv = null;
		try (Connection connection = getConnection()) {
			if (connection != null) {
				PreparedStatement pr = connection.prepareStatement(selectGV);
				pr.setInt(1, id);
				ResultSet rs = pr.executeQuery();

				while (rs.next()) {
					
					String hoten = rs.getString("hoten");
					String ngaysinh = rs.getString("ngaysinh");
					String tenbomon = rs.getString("tenbomon");
					float hesoluong = rs.getFloat("hesoluong");
					gv= new giangvien(hoten, ngaysinh, tenbomon, hesoluong, id);
				}

			} else {
				System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
			}
		} catch (Exception e) {
			System.err.println("Ngoại lệ: " + e.getMessage());
			e.printStackTrace();
		}
		return gv;
	}
	//sua 
	public boolean updateGV (giangvien gv) {
		boolean updated =false;
		try {
		Connection connection=getConnection();
		PreparedStatement pr = connection.prepareStatement(UPDATE);
		pr.setString(1, gv.getHoten());
		pr.setString(2, gv.getNgaysinh());
		pr.setString(3, gv.getTenbomon());
		pr.setFloat(4, gv.getHesoluong());
		pr.setInt(5, gv.getMaGV());
	    
	    updated = pr.executeUpdate() > 0;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}



}
