package BankingSystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import jdbc.DateParsing;
@Component
public class CreateAccountPSS implements PreparedStatementSetter{
	@Autowired
	Account acc;

	@Override
	public void setValues(PreparedStatement pst) throws SQLException {

				pst.setInt(1,acc.getAccNo());
				pst.setString(2, acc.getCustomerName());
				//pst.setString(, acc.getAddress().getStreet());
				//pst.setString(, acc.getAddress().getCity());
				pst.setDouble(3, acc.getBalance());
				pst.setDate(4, DateParsing.ConvertToSqlDate(acc.getDate()));	
	}

}
