/*Object Persistence inside database

create a table "Product" with
	pid number
	qty number
	cost decimal 
	pname varchar
[ do not add any record ]

define a class "Product" with
	private int pid,qty;
	private double cost;
	private String pname;
		setters,getters,parameterized constructor and toString()

*/

package assignment3;

public class product {

		private int pid ;
		private int qty;
		private double cost;
		private String pname;
		
	@Override
		public String toString() {
			return "product [pid=" + pid + ", qty=" + qty + ", cost=" + cost + ", pname=" + pname + "]";
		}

	public product(int pid, int qty, double cost, String pname) {
			super();
			this.pid = pid;
			this.qty = qty;
			this.cost = cost;
			this.pname = pname;
		}

	public int getPid() {
			return pid;
		}

		public void setPid(int pid) {
			this.pid = pid;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}

		public String getPname() {
			return pname;
		}

		public void setPname(String pname) {
			this.pname = pname;
		}

	

}


/*create 1 instance of above class , display it and then insert a row inside Product with the help of above instance.

	now assign "null" to the above instance. That means your heap based object will be soon garbage collected , but you need not worry as you have saved the state of an object inside the database.

	now fire a query to read that record and with the help of it initialize new object of "Product" and display it.*/


package assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.cj.xdevapi.Statement;

public class program {

	public static void main(String[] args) {
		product p=new product(1,10,97.5,"NoteBook");
		System.out.println(p);
		String ss ="jdbc:mysql://localhost:3306/bit";
		try(Connection con=DriverManager.getConnection(ss,"root","root"))
		{
			PreparedStatement prt=con.prepareStatement("insert into product values(?,?,?,?)");
			prt.setInt(1,p.getPid());
			prt.setInt(2, p.getQty());
			prt.setDouble(3, p.getCost());
			prt.setString(4, p.getPname());
			int val=prt.executeUpdate();
			if(val>0)
				System.out.println(val+"record updated");
			p=null;
			java.sql.Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from product");
			rs.next();
			p=new product(rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getString(4));
			System.out.println(p);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
