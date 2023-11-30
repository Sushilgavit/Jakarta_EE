
/*create table "Employee"
	empid,empname,desig
add 5 records manually. Now write a java program to accept "designation" from user and retrieve employees with the given designation.*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class assignment2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the designation");
		String desig=sc.next();
		String ss="jdbc:mysql://localhost:3306/bit";
		
		
		try (Connection con =DriverManager.getConnection(ss,"root" ,"root"))
		{
			
			PreparedStatement pst=con.prepareStatement("select * from  employee where desig=?" );	
			pst.setString(1,desig);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				System.out.println("empid= "+rs.getInt("empid")+" empname= "+rs.getString("empname"));
			}
		}
		catch(Exception  ee)
		{
			System.out.println(ee);
		}

	}

}
