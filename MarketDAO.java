package com.klu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.klu.Bean.MarketBean;
import com.klu.Connection.DBUtil;

public class MarketDAO {
	
	public int MarketInsert(MarketBean market) throws ClassNotFoundException, SQLException{
			
			Connection con=DBUtil.DBConnection();
			PreparedStatement ps=con.prepareStatement("insert into sales values(?,?,?)");  
			ps.setInt(1,market.getItem_id());
			ps.setString(2,market.getItem_name());
			ps.setFloat(3,market.getCost());
			int i = ps.executeUpdate();
			con.close();
			return i;
	}
	
	public void Market_Display() throws ClassNotFoundException, SQLException{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("select * from sales ");
		ResultSet d = (ResultSet) ps.executeQuery();
		System.out.println("Item ID		Item Name		Cost");
		while(d.next()) {
			System.out.print(d.getInt(1));
			System.out.print("		"+d.getString(2));
			System.out.print("		"+d.getFloat(3));
			System.out.println();
		}
		con.close();
	}
	
	public void Market_Cost() throws ClassNotFoundException, SQLException{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("select sum(cost) from sales ");
		ResultSet d = ps.executeQuery();
		System.out.print("Total cost = ");
		while(d.next()) {
			System.out.println(d.getFloat(1));
		}
		con.close();
	}
}
