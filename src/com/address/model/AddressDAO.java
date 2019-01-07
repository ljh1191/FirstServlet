package com.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.net.resolver.AddrResolution;

public class AddressDAO {
	private static AddressDAO instance;
	public static AddressDAO getInstance() {
		if(instance==null) {
			instance = new AddressDAO();
		}
		return instance;
	}
	//db연결
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	//추가
	public void addressInsert(AddressDTO ad) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into addressdb values(addressdb_seq.nextval,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, ad.getName());
			ps.setString(2, ad.getAddr());
			ps.setString(3, ad.getZipcode());
			ps.setString(4, ad.getTell());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseOn(con, ps);
		}
	}
	//전체보기
	public ArrayList<AddressDTO> addressList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<AddressDTO> arr = new ArrayList<>();
		
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select * from addressdb";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AddressDTO dto = new AddressDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setTell(rs.getString("tell"));
				arr.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseOn(con, st, rs);
		}
		return arr;
	}
	//상세보기
	public AddressDTO addressView(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		AddressDTO dto = null;
		
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select * from addressdb where num = "+num;
			rs = st.executeQuery(sql);
			if(rs.next()) {
				dto = new AddressDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddr(rs.getString("addr"));
				dto.setTell(rs.getString("tell"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseOn(con, st, rs);
		}
		return dto;
	}
	
	//주소 검색
	public ArrayList<ZipcodeDTO> zipList(String dong) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<ZipcodeDTO> arr = new ArrayList<>();
		
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select * from zipcode where dong like '%"+dong+"%'";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ZipcodeDTO dto = new ZipcodeDTO();
				dto.setZipcode(rs.getString("zipcode"));
				dto.setSido(rs.getString("sido"));
				dto.setGugun(rs.getString("gugun"));
				dto.setDong(rs.getString("dong"));
				dto.setBunji(rs.getString("bunji"));
				dto.setSeq(rs.getInt("seq"));
				arr.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	//수정
	public void addressUpdate(AddressDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "update addressdb set name=?,addr=?,zipcode=?,tell=? where num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getAddr());
			ps.setString(3, dto.getZipcode());
			ps.setString(4, dto.getTell());
			ps.setInt(5, dto.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseOn(con, ps);
		}
		
	}
	//삭제
	public void addressDelete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "delete from addressdb where num ="+num;
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseOn(con, st);
		}
		
	}
	//검색
	public ArrayList<AddressDTO> addressSearch(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<AddressDTO> arr = new ArrayList<>();
		
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select * from addressdb where "+field+" like '%"+word+"%'";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AddressDTO dto = new AddressDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setTell(rs.getString("tell"));
				arr.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseOn(con, st, rs);
		}
		return arr;
	}
	//총게시물 수
	public int addressCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count  = 0;
		
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select count(*) cnt from addressdb";
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseOn(con, st, rs);
		}
		return count;
	}
	
	//검색게시물 수
		public int addressSearchCount(String field, String word) {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			int count  = 0;
			
			try {
				con = getConnection();
				st = con.createStatement();
				String sql = "select count(*) cnt from addressdb where "+field+" like '%"+word+"%'";
				rs = st.executeQuery(sql);
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				CloseOn(con, st, rs);
			}
			return count;
		}
	
	//닫는함수
	public void CloseOn(Connection con, PreparedStatement ps ) {
		try {
			if(con!=null) {con.close();}
			if(ps!=null) {ps.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CloseOn(Connection con, Statement st ) {
		try {
			if(con!=null) {con.close();}
			if(st!=null) {st.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CloseOn(Connection con, Statement st , ResultSet rs) {
		try {
			if(con!=null) {con.close();}
			if(st!=null) {st.close();}
			if(rs!=null) {rs.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
