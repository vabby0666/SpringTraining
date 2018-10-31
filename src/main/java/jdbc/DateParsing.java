package jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParsing {
	public static java.sql.Date ConvertToSqlDate(java.util.Date date) {
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		return sqldate;
	}
	public static java.util.Date convertToUtilDate(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dt=null;
		try {
			dt=sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;
	}
	
}
