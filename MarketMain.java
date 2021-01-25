package com.klu.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.klu.Bean.MarketBean;
import com.klu.DAO.MarketDAO;

public class MarketMain {
	
	private static Scanner sc;
	 
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		MarketBean mb = new MarketBean();
		MarketDAO mi = new MarketDAO();
		sc = new Scanner(System.in);
		int i;
		while(true) {
			System.out.println("Select an Operation");
			System.out.println("1.Insertion");
			System.out.println("2.Display");
			System.out.println("3.Cost of Items");
			System.out.println("4.Exit");
			System.out.println("Enter your choice : ");
			int ch =sc.nextInt();
			switch(ch) {
				case 1 : System.out.println("Insertion");
						System.out.println("Enter Item ID: ");
						int item_id = sc.nextInt();
						mb.setItem_id(item_id);
						System.out.println("Enter Item Name: ");
						String item_name = sc.next();
						mb.setItem_name(item_name);
						System.out.println("Enter Cost of Item: ");
						Float cost = sc.nextFloat();
						mb.setCost(cost);
						i = mi.MarketInsert(mb);
						if(i>0)
						{
							System.out.println("Insertion is successfull");
						}
						else
						{
							System.out.println("Insertion is failed");
						}
						break;
						
				case 2 : System.out.println("Display Data \n");
						mi.Market_Display();
						break;
					
				case 3: mi.Market_Cost();
						break;
			 		
				case 4 : System.exit(0);
				
				default: System.out.println("Invalid Choice \n");
			}
		}		
	}
}
