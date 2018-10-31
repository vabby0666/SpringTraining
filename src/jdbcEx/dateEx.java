package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.Driver;

public class dateEx {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		String url="jdbc:mysql://localhost:3306/employee";
		String user="root";
		String pass="root";
		Connection conn=DriverManager.getConnection(url,user,pass);
		String doj="13-11-1996";
		SimpleDateFormat dt=new SimpleDateFormat("dd-mm-yyyy");
		Date sd=dt.parse(doj);
		String sql="insert into employee values(?,?,?,?)";
		
		PreparedStatement pst=conn.prepareStatement(sql);
		java.sql.Date sqldate=new java.sql.Date(sd.getTime());
		pst.setInt(1, 121);
		pst.setString(2, "hello");
		pst.setDouble(3, 500);
		pst.setDate(4, sqldate);
		int rows=pst.executeUpdate();
		if(rows>0)
		{
			System.out.println("Inserted");
		}
		else System.out.println("Not Inserted");
	}

}
