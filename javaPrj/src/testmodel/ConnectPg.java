package testmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import insertMode.Data;

public class ConnectPg {
	Connection con;
	String[] account = new String[3];

	public ConnectPg() throws Exception {
		con = DBcon.getConnection();
	}

	public void insertData(Data da) throws Exception {
		String sql = "insert into playground values (SEQ_P_CODE.nextval,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, da.getName());
		ps.setInt(2, da.getPrice());
		ps.setString(3, da.getThem());
		ps.setString(4, da.getReview());
		ps.setInt(5, da.getStar());

		ps.executeUpdate();

		ps.close();

	}

	public ArrayList insert2() throws Exception {
		String sql = "select VICODE,NAME,PRICE,THEMA,REVIEW,STAR from playground";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList data = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("VICODE"));
			temp.add(rs.getString("NAME"));
			temp.add(rs.getInt("PRICE"));
			temp.add(rs.getString("THEMA"));
			temp.add(rs.getString("REVIEW"));
			temp.add(rs.getInt("STAR"));
			data.add(temp);

		}
		rs.close();
		ps.close();

		return data;
	}

	public void setInfo(Data da) throws Exception {
		String sql = "insert into acinfo values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, da.getLoca());
		ps.setString(2, da.getId());
		ps.setString(3, da.getPass());
		ps.setString(4, da.getChild());
		ps.setString(5, da.getPrefer());

		ps.executeUpdate();

		ps.close();

	}

	public String checkID(String id) throws Exception {
		String sql = "select id from acinfo where id ='" + id + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		String idChec = "";
		while (rs.next()) {
			idChec = rs.getString("id");
		}
		rs.close();
		ps.close();
		return idChec;

	}

	public String[] loginIdPass(String id) throws Exception {
		String sql = "select id,pass,prefer from acinfo where id ='" + id + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			account[0] = rs.getString("id");
			account[1] = rs.getString("pass");
			account[2] = rs.getString("prefer");
		}
		rs.close();
		ps.close();
		return account;
	}

	public Data selectbyPK(int no) throws Exception {
		Data da = new Data();
		String sql = "SELECT * FROM PLAYGROUND WHERE VICODE = " + no;
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			da.setVicode(Integer.parseInt(rs.getString("VICODE")));
			da.setName(rs.getString("NAME"));
			da.setPrice(Integer.parseInt(rs.getString("PRICE")));
			da.setThem(rs.getString("THEMA"));
			da.setReview(rs.getString("REVIEW"));
			da.setStar(Integer.parseInt(rs.getString("STAR")));
		}
		rs.close();
		ps.close();
		return da;
	}

	public void modifyData(Data dat) throws Exception {

		String sql = "update playground set NAME =?,PRICE=?,THEMA=?,REVIEW=?,STAR=? where VICODE = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dat.getName());
		ps.setInt(2, dat.getPrice());
		ps.setString(3, dat.getThem());
		ps.setString(4, dat.getReview());
		ps.setInt(5, dat.getStar());
		ps.setInt(6, dat.getVicode());

		ps.executeUpdate();// ½ÇÇà
		ps.close();
	}

	public void deleteData(int no) throws Exception {
		String sql = "delete from playground where vicode = " + no;
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.executeUpdate();
		ps.close();
		
	}

}
