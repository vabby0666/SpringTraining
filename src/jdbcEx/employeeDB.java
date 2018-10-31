package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import java.util.Scanner;
public class employeeDB {

	public static void main(String[] args) throws SQLException {
		Scanner in=new Scanner(System.in); 
		int w;
		int k;
		int c;
		String n;
		Double s;
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		String url="jdbc:mysql://localhost:3306/employee";
		String user="root";
		String pass="root";
		Connection conn=DriverManager.getConnection(url,user,pass);
		do {
		System.out.println("Enter 1 to Insert or 2 to Update or 3 to Delete\n");
		w=in.nextInt();
		if(w==1) {
		String sql="insert into employee values(?,?,?)";
		
		PreparedStatement pst=conn.prepareStatement(sql);
		System.out.println("Enter Code , Name & Salary");
		c=in.nextInt();
		n=in.next();
		s=in.nextDouble();
		pst.setInt(1, c);
		pst.setString(2, n);
		pst.setDouble(3, s);
		int rows=pst.executeUpdate();
		if(rows>0)
		{
			System.out.println("Inserted");
		}
		else System.out.println("Not Inserted");
    	}
		else if(w==2) {
		String sql1="update employee set name=? where code=?";
		PreparedStatement pst1=conn.prepareStatement(sql1);
		System.out.println("Enter the new Name & Code of employee");
		n=in.next();
		c=in.nextInt();
		pst1.setString(1,n);
		pst1.setInt(2, c);
		int rows=pst1.executeUpdate();
		if(rows>0)
		{
			System.out.println("Inserted");
		}
		else System.out.println("Not Inserted");
	    }
		else
		{
			String sql2="delete from employee where code=?";
			PreparedStatement pst2=conn.prepareStatement(sql2);
			System.out.println("Enter the Code of employee to delete");
			c=in.nextInt();
			pst2.setInt(1, c);
			int rows=pst2.executeUpdate();
			if(rows>0)
			{
				System.out.println("Deleted");
			}
			else System.out.println("Not Deleted");
		 }	
		
	System.out.println("Enter 1 to continue, 2 to close");
	k=in.nextInt();
}while(k!=2);
		in.close();
	}
}
