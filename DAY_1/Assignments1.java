
import java.sql.*;
import java.util.Scanner;

/* create a table "Student" rollno,name,age write a java program to accept rollno,name,age from user and insert a row. after inserting that row try to view using a query.*/

public class assignment1 
{
	public static void main(String args[])
	{
		String ss="jdbc:mysql://localhost:3306/bit";
		try(Connection con=DriverManager.getConnection(ss,"root","root"))
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter roll no");
		int rollno=sc.nextInt();
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("enter  age");
		int age=sc.nextInt();
		
		PreparedStatement pst=con.prepareStatement("insert into student(rollno , name , age) values(? , ? , ?)" );
		pst.setInt(1,rollno);
		pst.setString(2, name);
		pst.setInt(3,age);
		int mod=pst.executeUpdate();
		if (mod>0)
		{
		System.out.println("data inserted");	
		}
		else
		{
			System.out.println("failed to insert");
		}
		PreparedStatement pst1=con.prepareStatement("select * from student" );
		ResultSet rs=pst1.executeQuery();
		while(rs.next())
		{
			int no=rs.getInt(1);
			String n=rs.getString(2);
			int a=rs.getInt(3);
			System.out.println(no +"\t"+ n +"   \t" + a  );
			
		}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	
}










						